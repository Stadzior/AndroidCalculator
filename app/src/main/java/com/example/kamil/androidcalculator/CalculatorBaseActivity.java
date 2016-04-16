package com.example.kamil.androidcalculator;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorBaseActivity extends AppCompatActivity {

    private TextView displayer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    protected void initializeCalculator(int activity) {
        setContentView(activity);
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
            throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){
            displayToast(this,"Formuła jest niepoprawna! Nie można jej rozwiązać.",Color.RED,Color.BLACK,Toast.LENGTH_LONG);
        }
        catch(Exception e){
            displayToast(this,"Ups! wystąpił nieznany problem :(", Color.RED,Color.BLACK, Toast.LENGTH_LONG);
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

    public static void displayToast(Context activity,String text,int textColor,int backgroundColor,int duration)
    {
        Toast toast = Toast.makeText(activity,text, duration);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(textColor);
        v.setBackgroundColor(backgroundColor);
        toast.show();
    }
}
