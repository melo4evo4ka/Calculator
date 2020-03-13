package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.CollationElementIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/digital7.ttf");
        TextView textView1 = findViewById(R.id.textView1);
       textView1.setText("");
        textView1.setTypeface(type);
        TextView btn_del = findViewById(R.id.btn_del);
        btn_del.setText("/");

    }
    public void onClick(View view) {
        TextView textView1 = findViewById(R.id.textView1);
        int digital;
        char symbol;
        switch (view.getId()){
            case R.id.btn_1:
                addDigital(1);
                break;
            case R.id.btn_2:
                addDigital(2);
                break;
            case R.id.btn_3:
                addDigital(3);
                break;
            case R.id.btn_4:
                addDigital(4);
                break;
            case R.id.btn_5:
                addDigital(5);
                break;
            case R.id.btn_6:
                addDigital(6);
                break;
            case R.id.btn_7:
                addDigital(7);
                break;
            case R.id.btn_8:
                addDigital(8);
                break;
            case R.id.btn_9:
                addDigital(9);
                break;
            case R.id.btn_0:
                addDigital(0);
                break;
            case R.id.btn_clear:
                textView1.setText("");
                break;
            case R.id.btn_procent:
                addAction('%');
                break;
            case R.id.btn_dot:
                addAction(',');
                break;

            case R.id.btn_rezult:
                addAction('=');
                break;
            case R.id.btn_razn:
                addAction('-');
                break;
            case R.id.btn_sum:
                addAction('+');
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
    public void addDigital(int digital){
        TextView textView1 = findViewById(R.id.textView1);
        String bString = (String) textView1.getText();
        String aString = Integer.toString(digital);
        textView1.setText(bString + aString);
    }
    public void addAction(char symbol){
        TextView textView1 = findViewById(R.id.textView1);
        String bString = (String) textView1.getText();
        textView1.setText(bString + symbol);
    }
}

