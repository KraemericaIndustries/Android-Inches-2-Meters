package com.kraemericaindustries.inches2meters;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private Button calculateButton;
    private EditText stringInches;
    private String inchesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        button();
    }

    private void findViews() {
        //  Save the views as Class variables.  See types in declaration (above)
        stringInches = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.calculate);
        resultText = findViewById(R.id.text_view_result);
    }
    @SuppressLint("SetTextI18n")
    private void button() {
        calculateButton.setOnClickListener(view -> {
            inchesText = stringInches.getText().toString();

            if(inchesText.isEmpty()) {
                Toast.makeText(MainActivity.this,"Enter a number, dummy!",Toast.LENGTH_LONG).show();
                resultText.setText("Enter a number...");
            } else {
                double metersResult = convertToMeters();
                displayResult(metersResult);
            }
        });
    }
    private double convertToMeters() {
            //  Converting numbers of type String, to a type of 'int':
            int inches = Integer.parseInt(inchesText);
            return inches * 0.0254;
    }
    private void displayResult(double meters) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String metersTextResult = myDecimalFormatter.format(meters);
        resultText.setText(metersTextResult);
    }
}