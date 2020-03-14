package com.example.makeitrain_moneycounterapp_missionandroid116;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView amount;
    TextView richMessage;
    private int initialAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.textView_amount);
        richMessage = findViewById(R.id.textView_rich);
    }
    public void depositMoney(View view){
        initialAmount += 1000;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(); //$1000
        amount.setText(String.valueOf(numberFormat.format(initialAmount)));
//        if(initialAmount>10000){
//            amount.setTextColor(getResources().getColor(R.color.colorPop));
//        }

        //or you can use switch case to keep it simple if you dont want to use nested if statements
        switch (initialAmount){
            case 10000:
                richMessage.setText(R.string.text_rich);

                amount.setTextColor(getResources().getColor(R.color.colorPop));

            case 15000:
                amount.setTextColor(getResources().getColor(R.color.colorAccent));
                break;

            case 20000:
                amount.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;

            default:
                break;
        }

        Log.d("DEPOSIT-TAG", "depositMoney: deposit button clicked");
    }

    public void showTag(View view){
        Log.d("SHOW-TAG", "showTag: Tag button clicked");

    }

    public void showToast(View view){
        Toast.makeText(getApplicationContext(), "This is a toast message", Toast.LENGTH_SHORT).show();
    }
}
