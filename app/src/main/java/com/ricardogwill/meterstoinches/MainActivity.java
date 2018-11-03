package com.ricardogwill.meterstoinches;
// This app was fully designed and created by me,
// of course with some help from sources online regarding some specifics.

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText metersEditText;
    Button convertButton;
    TextView metersTextView, resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewSetup();
        convert();
    }

    public void viewSetup() {
        metersEditText = findViewById(R.id.meters_editText);
        convertButton = findViewById(R.id.convert_button);
        metersTextView = findViewById(R.id.meters_textView);
        resultTextView = findViewById(R.id.result_textView);
    }

    public void convert() {
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Make sure text is input into EditText.
                if (metersEditText.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
                } else {
                    // Get Double from EditText and multiply it to get a result in inches.
                    double metersDouble = Double.parseDouble(metersEditText.getText().toString());
                    double inchesInMeterDouble = 39.37;
                    double result = metersDouble*inchesInMeterDouble;

                    // Make the Doubles into BigDecimals.
                    BigDecimal metersBigDecimal = new BigDecimal(metersDouble);
                    BigDecimal inchesBigDecimal = new BigDecimal(result);

                    // Format the BigDecimals.
                    DecimalFormat metersDecimalFormat = new DecimalFormat("###,###,###.#####");
                    DecimalFormat inchesDecimalFormat = new DecimalFormat("###,###,###.#####");

                    //  Turn the formatted BigDecimals into Strings.
                    String metersString = metersDecimalFormat.format(metersBigDecimal);
                    String inchesResultString = inchesDecimalFormat.format(inchesBigDecimal);

                    // Change the Explanation TextView.
                    if (metersString.equals("1")) {
                        metersTextView.setText(metersString + " meter " + "=");
                    } else {
                        metersTextView.setText(metersString + " meters " + "=");
                    }

                    // Erase the EditText.
                    metersEditText.setText("");

                    // Put the result String into the Result TextView.
                    if (inchesResultString.equals("1")) {
                        resultTextView.setText(inchesResultString + " inch");
                    } else {
                        resultTextView.setText(inchesResultString + " inches");
                    }
                }

            }
        });
    }

}
