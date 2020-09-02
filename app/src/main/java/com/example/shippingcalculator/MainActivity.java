package com.example.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText weightET;
    private ShipItem shipItem;
    private TextView baseTV, addedTV, totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightET = (EditText) findViewById(R.id.editText_weight);
        shipItem = new ShipItem();
        baseTV = (TextView) findViewById(R.id.baseOutput);
        addedTV = (TextView) findViewById(R.id.addedOutput);
        totalTV = (TextView) findViewById(R.id.totalOutput);


        weightET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //leave empty
            }

            @Override
            public void onTextChanged(CharSequence sequence, int i, int i1, int i2) {
                try{
                    shipItem.setWeight(Double.parseDouble(sequence.toString()));
                }
                catch(NumberFormatException e){
                    shipItem.setWeight(0.0);
                }
                displayShipping();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //leave empty
            }
        });
    }
    public void displayShipping(){
        String base = String.format("$ %.2f",shipItem.getBaseCost());
        String add = String.format("$ %.2f",shipItem.getAddedCost());
        String total = String.format("$ %.2f",shipItem.getTotalCost());
        baseTV.setText(base.toString());
        addedTV.setText(add.toString());
        totalTV.setText(total.toString());
    }



}
