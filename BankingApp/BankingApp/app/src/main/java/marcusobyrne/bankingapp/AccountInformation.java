package marcusobyrne.bankingapp;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccountInformation extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);
        setTitle("");

        TextView textName = (TextView) findViewById(R.id.textViewName);
        TextView textAddress1 = (TextView) findViewById(R.id.textViewAddress1);
        TextView textAddress2 = (TextView) findViewById(R.id.textViewAddress2);
        TextView textAccNo = (TextView) findViewById(R.id.textViewAccNo);
        TextView textPIN = (TextView) findViewById(R.id.textViewPIN);
        TextView textBalance = (TextView) findViewById(R.id.textViewBalance);


        textName.setText(DataHolder.getName());
        textAddress1.setText(DataHolder.getAddress1());
        textAddress2.setText(DataHolder.getAddress2());

        String accNo = String.valueOf(DataHolder.getAccNo());
        textAccNo.setText(accNo);

        String PIN = String.valueOf(DataHolder.getPIN());
        textPIN.setText(PIN);

        String balance = String.valueOf(DataHolder.getBalance());
        textBalance.setText(balance);


    }
}
