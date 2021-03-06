package com.example.kamil.androidcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenAdvanced(View view) {
        Intent myIntent = new Intent(MainActivity.this, CalculatorAdvancedActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
    public void OpenBasic(View view) {
        Intent myIntent = new Intent(MainActivity.this, CalculatorBasicActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
    public void OpenAbout(View view) {
        Intent myIntent = new Intent(MainActivity.this, AboutActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void CloseApplication(View view) {
        this.finishAffinity();
    }
}
