package com.example.kamil.androidcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdvancedActivity extends AppCompatActivity {

    private TextView displayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
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
            displayer.setText(Solver.solveEquation(displayer.getText().toString()).toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
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
