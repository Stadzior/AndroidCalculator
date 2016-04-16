package com.example.kamil.androidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CalculatorBasicActivity extends CalculatorBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.initializeCalculator(R.layout.activity_basic);
    }
}
