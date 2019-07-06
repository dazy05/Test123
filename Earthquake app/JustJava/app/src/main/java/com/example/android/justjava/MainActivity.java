 package com.example.android.justjava;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Desi Coffee");
    }


    private int calculatePrice()
    {
        int price = quantity * 5;
        return  price;
    }

    private String createOrderSummery(int price,boolean hasCheckedWippedCream,boolean hasCheckedChoclate,String name)
    {
        String priceMessage = "Name : " + name;
        priceMessage += "\nAdd whipped cream? " + hasCheckedWippedCream;
        priceMessage += "\nAdd Choclate? " + hasCheckedChoclate;
        priceMessage +=  " \nQuantity:" + quantity;
        if(hasCheckedWippedCream && hasCheckedChoclate)
        priceMessage +=  "\nTotal: $" + price + "+" + quantity * (2 + 1) + "(For Toppings)";
        else if(hasCheckedChoclate)
            priceMessage +=  "\nTotal: $" + price + "+" + quantity * 1 + "(For Choclate)";
        else if(hasCheckedWippedCream)
            priceMessage +=  "\nTotal: $" + price + "+" + quantity * 2 + "(For whipped Cream)";
            else
            priceMessage +=  "\nTotal: $" + price;
        priceMessage +=  "\nThank you!";
        return priceMessage;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitOrder(View view)
    {
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        String name = nameEditText.getText().toString();
        CheckBox wippedCream = (CheckBox) findViewById(R.id.wipped_cream);
        boolean hasCheckedWippedCream = wippedCream.isChecked();
        CheckBox choclate = (CheckBox) findViewById(R.id.choclate_checkbox);
        boolean hasCheckedChoclate = choclate.isChecked();
        int price = calculatePrice();
        String priceMessage = createOrderSummery(price,hasCheckedWippedCream,hasCheckedChoclate,name);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java app for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    private void displayQuantity(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increment(View view)
    {
        if(quantity < 99)
            quantity = quantity + 1;

        else
            Toast.makeText(MainActivity.this,"you can order maximum 99 coffees",Toast.LENGTH_SHORT).show();

        displayQuantity(quantity);
    }

    public void decrement(View view)
    {
        if(quantity < 1)
            Toast.makeText(MainActivity.this,"Minimum order should be 1 coffee",Toast.LENGTH_SHORT).show();
        else
            quantity = quantity - 1;
        displayQuantity(quantity);
    }

}
