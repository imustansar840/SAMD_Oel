package marcusobyrne.bankingapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.provider.ContactsContract;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user.db";
    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS1 = "address1";
    public static final String COLUMN_ADDRESS2 = "address2";
    public static final String COLUMN_ACCNO = "accNo";
    public static final String COLUMN_PIN = "PIN";
    public static final String COLUMN_BALANCE = "currentbalance";

    public static final String TABLE_TRANSACTIONS = "transactions";
    public static final String COLUMN_TID = "_tid";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_AMOUNT = "amount";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_USER + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_ADDRESS1 + " TEXT, " +
                COLUMN_ADDRESS2 + " TEXT, " +
                COLUMN_ACCNO + " INTEGER, " +
                COLUMN_PIN + " INTEGER UNIQUE, " +
                COLUMN_BALANCE + " INTEGER " +
                ");";

        db.execSQL(query);

        String query2 = "CREATE TABLE " + TABLE_TRANSACTIONS + "(" +
                COLUMN_TID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_AMOUNT + " INTEGER);";

        db.execSQL(query2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTIONS);
        onCreate(db);
    }

    //Add new row
    public void addUser(User user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.get_name());
        values.put(COLUMN_ADDRESS1, user.get_address1());
        values.put(COLUMN_ADDRESS2, user.get_address2());
        values.put(COLUMN_ACCNO, user.get_accNo());
        values.put(COLUMN_PIN, user.get_PIN());
        values.put(COLUMN_BALANCE, user.get_currentbalance());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USER, null, values);
        db.close();
    }
    public void saveTransaction(Transaction transaction){
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, transaction.get_description());
        values.put(COLUMN_AMOUNT, transaction.get_amount());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_TRANSACTIONS, null, values);
        db.close();
    }

    public boolean getUser(int PIN){

        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_PIN + " = " + PIN + ";";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        if(cursor.getCount() > 0){

            DataHolder.setID(Integer.valueOf(cursor.getString(0)));
            DataHolder.setName(cursor.getString(1));
            DataHolder.setAddress1(cursor.getString(2));
            DataHolder.setAddress2(cursor.getString(3));
            DataHolder.setAccNo(Integer.valueOf(cursor.getString(4)));
            DataHolder.setPIN(Integer.valueOf(cursor.getString(5)));
            DataHolder.setBalance(Double.valueOf(cursor.getString(6)));

            return true;
        }
        cursor.close();
        db.close();

        return false;

    }

    //Delete a user from the database
    public void deleteUser(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_USER + " WHERE " + COLUMN_NAME + "=\"" + name + "\";");
    }

    //Display DB as string
    public List<String> databaseToString(){
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_TRANSACTIONS + ";";

        Cursor c = db.rawQuery(query, null);
        if(c.moveToFirst()){
            do{

                list.add(c.getString(1));
                list.add(String.valueOf(c.getString(2)));

            }while (c.moveToNext());
        }

        db.close();
        return list;
    }

    public int updateUser(User user) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.get_name());
        values.put(COLUMN_ADDRESS1, user.get_address1());
        values.put(COLUMN_ADDRESS2, user.get_address2());
        values.put(COLUMN_ACCNO, user.get_accNo());
        values.put(COLUMN_PIN, user.get_PIN());
        values.put(COLUMN_BALANCE, user.get_currentbalance());

        // updating row
        return db.update(TABLE_USER, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(user.get_id())});


    }

    public boolean checkUser(String PIN) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_ADDRESS1,
                COLUMN_ADDRESS2,
                COLUMN_ACCNO,
                COLUMN_PIN,
                COLUMN_BALANCE
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_PIN + " = ?";

        // selection arguments
        String[] selectionArgs = {PIN};

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;

    }

    public void updateBalance(double amount){
        SQLiteDatabase db = getWritableDatabase();

        Double balance = DataHolder.getBalance();
        int PIN = DataHolder.getPIN();

        balance = balance - amount;

        DataHolder.setBalance(balance);

        ContentValues values = new ContentValues();
        values.put(COLUMN_BALANCE, balance);


        db.update(TABLE_USER, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(PIN)});

    }



}
