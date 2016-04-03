package com.example.kamil.androidcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDisplayer((TextView) findViewById(R.id.textViewDisplayer));
        displayer.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putCharSequence("displayer", displayer.getText());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        displayer.setText(savedInstanceState.getCharSequence("displayer"));
    }

    public void solveEquation(View view){
        try {
         //   Solver.solveEquation(displayer.getText().toString());
        }catch(Exception e){
           // System.out.println(e.getMessage());
        }
    }

    public void writeSymbolToDisplayer(View view) {
        Button btn = (Button)view;
        StringBuilder symbol = new StringBuilder();
        symbol.append(btn.getText().toString());
        if(symbol.toString().equals("log") || symbol.toString().equals("√")){
            symbol.append('(');
        }
        displayer.append(symbol.toString());
    }

    public void clearDisplayer(View view){
        displayer.setText("");
    }

    public void deletePreviousSymbol(View view){
        if(displayer.length()>0){
            String revertedText = displayer.getText().subSequence(0,displayer.length()-1).toString();
            displayer.setText(revertedText);
        }
    }

    public void setDisplayer(TextView displayer) {
        this.displayer = displayer;
    }
}
