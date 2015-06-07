package com.example.shijanshrest.financecalculator;
// ordinary annuity

import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.content.res.Configuration;

import java.text.NumberFormat;


public class MainActivity extends BaseClass {

    private EditText prsVal;
    private EditText timeVal;
    private EditText rateVal;
    private EditText mainFV;
    private EditText mainPV;
    private TextView FVAnswer;
    private TextView PVAnswer;
    private TextView RAnswer,NAnswer,cfAnswer;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prsVal=(EditText) findViewById(R.id.prsVal);
        rateVal=(EditText) findViewById(R.id.rteVal);
        timeVal=(EditText) findViewById(R.id.timeVal);
         mainFV=(EditText) findViewById(R.id.mainFV);
        mainPV=(EditText) findViewById(R.id.mainPV);
        RAnswer=(TextView)findViewById(R.id.rAnswer);
        NAnswer=(TextView)findViewById(R.id.nAnswer);
        cfAnswer=(TextView)findViewById(R.id.cfAnswer);
        FVAnswer=(TextView)findViewById(R.id.fvAnswer);
        PVAnswer=(TextView)findViewById(R.id.pvAnswer);


    }


    public void calculate1(View view) {
        double rteVal1 = Double.NaN, prsVal1 = Double.NaN, time = Double.NaN;
        double fv,pv;

        double solution = 0;
        double solution1 = 0;
        try {
            prsVal1 = new Double((prsVal.getText().toString()));

        } catch (NumberFormatException e) {
            prsVal1 = Double.NaN;
        }

        try {
            rteVal1 = new Double(Double.parseDouble(rateVal.getText().toString()));


        } catch (NumberFormatException e) {
            rteVal1 = Double.NaN;
        }

        try {
            time = new Double(Double.parseDouble(timeVal.getText().toString()));

        } catch (NumberFormatException e) {
            time = Double.NaN;
        }


        try {
            fv = new Double(Double.parseDouble(mainFV.getText().toString()));

        } catch (NumberFormatException e) {
            fv = Double.NaN;
        }

        try
        {
            pv=new Double(Double.parseDouble(mainPV.getText().toString()));
        }
        catch (NumberFormatException e)
        {
            pv=Double.NaN;
        }


        if (!Double.isNaN(time) && !Double.isNaN(prsVal1) && !Double.isNaN(rteVal1)) {
            solution = prsVal1 * ((1 - 1 / Math.pow((1 + rteVal1), time)) / rteVal1);
            solution = (double) Math.round(solution * 100) / 100.0;

            solution1 = prsVal1 * ((Math.pow((1 + rteVal1), time) - 1) / rteVal1);
            solution1 = (double) Math.round(solution1 * 100) / 100.0;

         //   answer1.setText("PV = " + Double.toString(solution) + "\r\n\r\nFV = " + Double.toString(solution1));

            RAnswer.setText(Double.toString(rteVal1));
            NAnswer.setText(Double.toString(time));
            cfAnswer.setText(Double.toString(prsVal1));
            FVAnswer.setText(Double.toString(solution));
            PVAnswer.setText(Double.toString(solution1));


        } else if (!Double.isNaN(time) && !Double.isNaN(prsVal1) && !Double.isNaN(fv)) {
            // find rate through fv formula
            solution=prsVal1;


        } else if (!Double.isNaN(rteVal1) && !Double.isNaN(prsVal1) && !Double.isNaN(fv)) {
            // find time through fv formula

        }
        else if (!Double.isNaN(rteVal1) && !Double.isNaN(fv) && !Double.isNaN(time))
        {
            // find present value through fv formula
        }
        //
        else if (!Double.isNaN(time) && !Double.isNaN(prsVal1) && !Double.isNaN(pv)) {
            // find rate through fv formula


        } else if (!Double.isNaN(rteVal1) && !Double.isNaN(prsVal1) && !Double.isNaN(pv)) {
            // find time through fv formula

        }
        else if (!Double.isNaN(rteVal1) && !Double.isNaN(pv) && !Double.isNaN(time))
        {
            // find present value through fv formula
        }
        // present value

        else {
           // answer1.setText("Insufficient Parameters!");
        }

    }

    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);

    }

}
