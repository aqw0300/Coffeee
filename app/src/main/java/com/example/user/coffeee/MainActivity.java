package com.example.user.coffeee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void decrement(View view) {
        quantity=quantity-1;
        if(quantity<0){
            quantity=0;
        }
        displayquantity(quantity);

    }

    private void displayquantity(int quantity) {
        TextView quantity1 = (TextView) findViewById(R.id.quantityTxt);
        quantity1.setText(""+quantity);


    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayquantity(quantity);
    }





    private void displayMessage(String finalMessage) {
        TextView Message = (TextView) findViewById(R.id.resultTxt);
        Message.setText(""+finalMessage);


    }

    private String createFinalMessage(String names, Boolean espresso, Boolean whipped,int price) {
        String Message =
                "Name: "+names+"\n"+
                        "Espresso :" +espresso+"\n"+
                        "Americano :" +whipped+"\n"+
                        "Total Price $: " +price;
        return  Message;


    }

    private int calculatePrice(Boolean espresso, Boolean whipped) {
        int price =30;
        if (espresso)
        {
            price =price+70;

        }
        if (whipped)
        {
            price=price+40;
        }
        return price*quantity;
    }

    public void orderButton(View view) {

        TextView textView = (TextView) findViewById(R.id.resultTxt);
        textView.setVisibility(View.VISIBLE);

        EditText name = (EditText) findViewById(R.id.nameTxt);
        String names = name.getText().toString();



        CheckBox espressoo = (CheckBox) findViewById(R.id.espresso_checkbox);
        Boolean espresso = espressoo.isChecked();
        CheckBox whippedCream = (CheckBox) findViewById(R.id.american_checkbox);
        Boolean whipped = whippedCream.isChecked();



        int price = calculatePrice(espresso,whipped);
        String finalMessage =createFinalMessage (names,espresso,whipped,price);
        displayMessage(finalMessage);
    }
}


