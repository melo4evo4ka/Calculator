package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.graphics.Typeface;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {

    public NumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_number, container, false);
    }

    public void addDigital(int digital){

      /* TextView textView1 = textView1.findViewById(R.id.tv_text);
        String bString = (String) textView1.getText();
        String aString = Integer.toString(digital);
        textView1.setText(bString + aString);
        */
    }

    public void addAction(char symbol){
        /*
        TextView textView1 = textView1.findViewById(R.id.tv_text);
        String bString = (String) textView1.getText();
        double number = Double.parseDouble(bString);
        textView1.setText(bString + symbol);
    */
    }

}
