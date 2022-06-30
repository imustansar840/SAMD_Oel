package marcusobyrne.bankingapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class newTrans extends AppCompatActivity {

    DBHandler dbHandler;
    EditText Description;
    EditText Amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trans);

        setTitle("");

        Description = (EditText) findViewById(R.id.editTextDecription);
        Amount = (EditText) findViewById(R.id.editTextAmount);

        dbHandler = new DBHandler(this, null, null, 1);




    }



    public void saveTransaction(View view){
        Transaction transaction = new Transaction(Description.getText().toString(),
                Double.valueOf(Amount.getText().toString()));

        dbHandler.saveTransaction(transaction);
        dbHandler.updateBalance(Double.valueOf(Amount.getText().toString()));


        final Intent transactionAdded = new Intent(this, MainMenu.class);

        AlertDialog alertDialog = new AlertDialog.Builder(newTrans.this).create();
        alertDialog.setTitle("Success");
        alertDialog.setMessage("Transaction has been added successfully");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            startActivity(transactionAdded);
                        }
                    });
        alertDialog.show();


    }
}
