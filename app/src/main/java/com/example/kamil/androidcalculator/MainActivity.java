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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void writeSymbolToDisplayer(View view) {
        Button btn = (Button)view;
        StringBuilder symbol = new StringBuilder();
        symbol.append(btn.getText().toString());
        if(symbol.equals("Log") || symbol.equals("√")){
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
