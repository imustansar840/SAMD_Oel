package marcusobyrne.bankingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class viewTransactions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);
        setTitle("");

        TextView transactions = (TextView) findViewById(R.id.textViewTransactions);
        DBHandler dbHandler = new DBHandler(this, null, null, 1);

        List<String> list = new ArrayList<String>();
        list = dbHandler.databaseToString();

        StringBuilder builder = new StringBuilder();
        for (String details : list) {
            builder.append(details + "\n");
        }

        transactions.setText(builder.toString());
    }


}
