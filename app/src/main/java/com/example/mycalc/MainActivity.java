package com.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private double operand1 = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        Button buttonZero = findViewById(R.id.buttonZero);
        Button buttonZeroZero = findViewById(R.id.buttonZeroZero);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDot = findViewById(R.id.buttonDot);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);//
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEqual = findViewById(R.id.buttonEqual);
        Button buttonDelete = findViewById(R.id.buttonDelete);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonModule = findViewById(R.id.buttonModule);



        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                resultTextView.append(button.getText().toString());
            }
        };

        buttonZero.setOnClickListener(listener);
        buttonZeroZero.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        View.OnClickListener operatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String op = button.getText().toString();
                String value = resultTextView.getText().toString();

                if (value.length() != 0) {
                    operand1 = Double.parseDouble(value);
                }

                operator = op;
                resultTextView.setText("");
            }
        };

        buttonAdd.setOnClickListener(operatorListener);
        buttonSubtract.setOnClickListener(operatorListener);
        buttonMultiply.setOnClickListener(operatorListener);
        buttonDivide.setOnClickListener(operatorListener);
        buttonModule.setOnClickListener(operatorListener);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = resultTextView.getText().toString();

                if (value.length() > 0) {
                    // If the value has at least one character, remove the last one
                    value = value.substring(0, value.length() - 1);
                    resultTextView.setText(value);
                }
            }
        });








        buttonClear.setOnClickListener(operatorListener);

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = resultTextView.getText().toString();

                if (value.length() != 0) {
                    double operand2 = Double.parseDouble(value);
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "x":
                            result = operand1 * operand2;
                            break;
                        case "/":
                            result = operand1 / operand2;
                            break;
                        case "%":
                            result = operand1 % operand2;
                            break;
                        case "del":
                            if (value.length() > 0) {
                                // If the value has at least one character, remove the last one
                                value = value.substring(0, value.length() - 1);
                                resultTextView.setText(value);
                            }
                            break;

                    }
                    switch (value.length()) {
                        case 0:
                            // If the value is already empty, do nothing
                            break;
                        case 1:
                            // If the value has only one character, set it to zero
                            resultTextView.setText("0");
                            break;
                        default:
                            // Otherwise, remove the last character from the value
                            value = value.substring(0, value.length() - 1);
                            resultTextView.setText(value);
                            break;
                    }
                    resultTextView.setText(Double.toString(result));
                }
            }
        });
    }
}
