package com.example.run.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    public  enum  Operation{
        ADD,SUBTRACT,MULTIPLY,DIVIDE,EQUAL
    }



    TextView resultTxt;

    String runningNumber = "";
    String leftNumString = "";
    String rightNumString = "";
    Operation currentOP = null;
    String result = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button) findViewById(R.id.btn1);
        Button twoBtn = (Button) findViewById(R.id.btn2);
        Button threeBtn = (Button) findViewById(R.id.btn3);
        Button fourBtn = (Button) findViewById(R.id.btn4);
        Button fiveBtn = (Button) findViewById(R.id.btn5);
        Button sixBtn = (Button) findViewById(R.id.btn6);
        Button sevenBtn = (Button) findViewById(R.id.btn7);
        Button eightBtn = (Button) findViewById(R.id.btn8);
        Button nineBtn = (Button) findViewById(R.id.btn9);
        Button zeroBtn = (Button) findViewById(R.id.btn0);
        Button clearBtn = (Button) findViewById(R.id.clearBtn);

        ImageButton equalBtn = (ImageButton) findViewById(R.id.equalBtn);
        ImageButton divideBtn = (ImageButton) findViewById(R.id.divideBtn);
        ImageButton addBtn = (ImageButton) findViewById(R.id.plusBtn);
        ImageButton subBtn = (ImageButton) findViewById(R.id.substractBtn);
        ImageButton multiBtn = (ImageButton) findViewById(R.id.multipyBtn);

        resultTxt = (TextView) findViewById(R.id.resultTxt);
        resultTxt.setText("");


        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(2);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(4);
            }
        });


        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberPressed(0);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftNumString = "";
                rightNumString = "";
                runningNumber = "";
                currentOP = null;
                result = "";
                resultTxt.setText(result);

            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);
            }
        });

        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });
    }

    void onNumberPressed(float i) {
        runningNumber += String.valueOf(i);
        resultTxt.setText(runningNumber);
    }

    void processOperation(Operation op){
        if (currentOP != Operation.EQUAL && currentOP != null ){
            if (runningNumber != ""){
                rightNumString = runningNumber;
                runningNumber = "";

                if (currentOP == Operation.ADD){
                    result = String.valueOf(Float.parseFloat(leftNumString) + Float.parseFloat(rightNumString));
                }else if (currentOP == Operation.SUBTRACT){
                    result = String.valueOf(Float.parseFloat(leftNumString) - Float.parseFloat(rightNumString));
                }else if (currentOP == Operation.DIVIDE){
                    result = String.valueOf(Float.parseFloat(leftNumString) / Float.parseFloat(rightNumString));
                }else if (currentOP == Operation.MULTIPLY){
                    result = String.valueOf(Float.parseFloat(leftNumString) + Float.parseFloat(rightNumString));
                }
                leftNumString = result;
                resultTxt.setText(result);
            }

            currentOP = op;
        }else if (currentOP == Operation.EQUAL){
            if (op == Operation.EQUAL){
                leftNumString = runningNumber;
                runningNumber = "";
            }else {
                leftNumString = result;
                runningNumber = "";
            }

            currentOP = op;
        }else {
            leftNumString = runningNumber;
            runningNumber = "";
            currentOP = op;
        }

    }


}

