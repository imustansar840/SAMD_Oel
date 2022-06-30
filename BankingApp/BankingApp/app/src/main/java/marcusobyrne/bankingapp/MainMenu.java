package marcusobyrne.bankingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setTitle("");


    }

    public void viewAccount(View view){

        Intent viewAcc = new Intent(MainMenu.this, AccountInformation.class);
        startActivity(viewAcc);

    }

    public void logoutClicked(View view){
        Intent logout = new Intent(this, MainActivity.class);

        startActivity(logout);
    }

    public void addTransactionClicked(View view){
        Intent addTrans = new Intent(MainMenu.this, newTrans.class);
        startActivity(addTrans);

    }

    public void viewTransactionClicked(View view){
        Intent viewTrans = new Intent(MainMenu.this, viewTransactions.class);
        startActivity(viewTrans);

    }


}
