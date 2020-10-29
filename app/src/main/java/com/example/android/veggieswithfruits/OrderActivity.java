package com.example.android.veggieswithfruits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //find the TextView that opens the vegetables activity
        TextView vegetables = (TextView) findViewById(R.id.vegetables);
        //set a click listener on orderButton
        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vegetablesIntent = new Intent(OrderActivity.this, VegetablesActivity.class);
                startActivity(vegetablesIntent);
            }
        });

        //find the TextView that opens the vegetables activity
        TextView fruits = (TextView) findViewById(R.id.fruits);
        //set a click listener on orderButton
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fruitsIntent = new Intent(OrderActivity.this, FruitsActivity.class);
                startActivity(fruitsIntent);
            }
        });

    }

}
