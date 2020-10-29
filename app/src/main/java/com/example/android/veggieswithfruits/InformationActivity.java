package com.example.android.veggieswithfruits;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity {

    public static EditText nameField;
    public static EditText addressField;
    public static EditText numberField;
    public static EditText requirementsField;

    public static Editable nameEditable;
    public static Editable numberEditable = null;
    public static Editable addressEditable = null;
    public static Editable requirementsEditable = null;

    public static String name;
    public static String address = null;
    public static String number = null;
    public static String requirements = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        nameField = (EditText) findViewById(R.id.name);
        addressField = (EditText)  findViewById(R.id.address);
        numberField = (EditText)  findViewById(R.id.number);
        requirementsField = (EditText)  findViewById(R.id.requirements);

        try{

            nameEditable = nameField.getText();
            numberEditable = numberField.getText();
            addressEditable = addressField.getText();
            requirementsEditable = requirementsField.getText();

            name = nameEditable.toString();
            address = addressEditable.toString();
            number = numberEditable.toString();
            requirements = requirementsEditable.toString();

        }catch(NullPointerException ignored){

        }

        Button proceed = findViewById(R.id.proceed);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceedIntent = new Intent(InformationActivity.this, OrderActivity.class);
                startActivity(proceedIntent);
            }
        });

    }










}
