package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int mSelectedPosition = -1;
    NumberFragment numberFragment;
    DisplayFragment displayFragment;
    public double firstNum;
    private Operation operation;
    public Button btnDot;

    private enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        X2,
        PRCENT,
        STARTOVER,
        NONE

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView1 = findViewById(R.id.tv_text);
        TextView textView2 = findViewById(R.id.textView);
        Button btnDot = findViewById(R.id.btn_dot);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/digital7.ttf");
        numberFragment = new NumberFragment();
        displayFragment = new DisplayFragment();
        textView1.setTypeface(type);
        textView1.setText("");
        textView2.setTypeface(type);

        if (savedInstanceState != null){
            mSelectedPosition = savedInstanceState.getInt("position",0);
            textView1.setTypeface(type);
            textView2.setTypeface(type);
        }
        if (mSelectedPosition == -1) return;

    }

  public void operationButtonClick(View view) {
      Button btnDot = findViewById(R.id.btn_dot);
      btnDot.setEnabled(true);
      TextView textView1 = findViewById(R.id.tv_text);
        firstNum = Double.parseDouble(textView1.getText().toString());
        textView1.setText("");
        switch (view.getId()) {
            case R.id.btn_sum:
                operation = Operation.ADD;
                addSymbol('+');
                break;
            case R.id.btn_umn:
                operation = Operation.MULTIPLY;
                addSymbol('*');
                break;
            case R.id.btn_razn:
                operation = Operation.SUBTRACT;
                addSymbol('-');
                break;
            case R.id.btn_del:
                operation = Operation.DIVIDE;
                addSymbol('/');
                break;
            case R.id.btn_x2:
                operation = Operation.X2;
               firstNum = Math.pow(firstNum,2);
               equalButtonClick(view);
                break;
            case R.id.btn_procent:
                operation = Operation.PRCENT;
                addSymbol('%');
                break;
        }
    }

    public void onClick(View view) {
        TextView textView1 = findViewById(R.id.tv_text);
        TextView textView2 = findViewById(R.id.textView);

        Button btnDot = findViewById(R.id.btn_dot);
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
                    textView2.setText("");
                    break;
                case R.id.btn_backspace:
                    textView1.setText("");
                    break;
                case R.id.btn_dot:
                    btnDot.setEnabled(false);
                    addSymbol('.');
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
     }


    public void addDigital(int digital){
        TextView textView1 = findViewById(R.id.tv_text);
        TextView textView2 = findViewById(R.id.textView);
        String bString = (String) textView1.getText();
        String aString = Integer.toString(digital);
        textView1.setText(bString + aString);
        textView2.setText( textView2.getText() + aString);
    }
    private void addSymbol(char symbol) {
        TextView textView2 = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.tv_text);
        String s1 = (String) textView2.getText();
        textView2.setText(s1 + symbol);
        if (symbol == '.')
        { String s2 = (String) textView1.getText();
        textView1.setText(s2 + symbol);
        }

    }

    public void equalButtonClick(View view) {
        Button btnDot = findViewById(R.id.btn_dot);
        btnDot.setEnabled(true);
        double secondNum;
        TextView textView1 = findViewById(R.id.tv_text);
        TextView textView2 = findViewById(R.id.textView);
        String a = textView1.getText().toString();
        if ( a != "") {
            secondNum = Double.parseDouble(textView1.getText().toString());
        } else secondNum = firstNum;
        addSymbol('=');

        switch (operation) {
            case ADD:
                firstNum += secondNum;
                break;
            case SUBTRACT:
                firstNum -= secondNum;
                break;
            case MULTIPLY:
                firstNum *= secondNum;
                break;
            case DIVIDE:
                firstNum /= secondNum;
                break;
            case PRCENT:
                firstNum = (firstNum/100)*secondNum;
                firstNum = roundAvoid(firstNum, 3);
                break;
            default:
                firstNum = secondNum;
        }
        textView1.setText(firstNum + "");
        String aString = Double.toString(firstNum);
        textView2.setText( textView2.getText() + aString);
        operation = Operation.STARTOVER;
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}

