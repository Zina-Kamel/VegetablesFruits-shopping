package com.example.android.veggieswithfruits;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class VegetablesActivity extends AppCompatActivity {

    public int totalPrice = 0;
    public int quantity = 0;
    public String order = "my order is: ";

    public TextView quantityTextView;
    public TextView checkPriceTextView;
    public int index=-1;

    String [] products = {"one", "two", "three","four", "five", "six", "seven"};
    int [] prices = {10,20,30,40,50,60,70};

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }



    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private void displayQuantity(int quantity) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);


        TextView nextButton = findViewById(R.id.next);
        final TextView productTextview = findViewById(R.id.product);
        final TextView productPriceTextview = findViewById(R.id.productPrice);
        //final ImageView image = (ImageView) findViewById(R.id.productPic);



        nextButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(index < products.length - 1){
                    index++;
                }
                productTextview.setText(products[index]);
                productPriceTextview.setText(Integer.toString(prices[index]));


            }
        });

        checkPriceTextView = (TextView) findViewById(R.id.checkPrice);
        checkPriceTextView.setText(Integer.toString(totalPrice));

        Button addToCart = findViewById(R.id.addProductButton);
        quantityTextView = findViewById(R.id.quantity_text_view);



    }


    public void shareItem(View view){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    @SuppressLint("SetTextI18n")
    public void addToCart(View view){
            int thisPrice = prices[index];
            totalPrice += Integer.parseInt((String) quantityTextView.getText()) * thisPrice;
            checkPriceTextView.setText(Integer.toString(totalPrice));
            order += products[index] + "  quantity: "  + (String) quantityTextView.getText()  + ", ";

    }
    public String subject = "name: " + InformationActivity.name + "   address: " + InformationActivity.address + " my number:  " + InformationActivity.number + " Other requirements:  "  + InformationActivity.number + ", " + "\n";
    public void startCheckout(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, order);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }


}

