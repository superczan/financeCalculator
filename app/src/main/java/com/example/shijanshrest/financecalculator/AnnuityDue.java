package com.example.shijanshrest.financecalculator;

/**
 * Created by shijan sh
 * rest on 2/7/2015.
 */
import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class AnnuityDue extends BaseClass{

    EditText annuityCash;
    EditText annuityN;
    EditText annuityRate;
    TextView annuityAnswer;
    EditText annuityPV;
    EditText annuityFV;
    private TextView FVAnswer;
    private TextView PVAnswer;
    private TextView RAnswer,NAnswer,cfAnswer;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.annuity_due);
        annuityCash=(EditText) findViewById(R.id.annuityCash);
        annuityN=(EditText)findViewById(R.id.annuityN);
        annuityRate=(EditText)findViewById(R.id.annuityRate);
        annuityPV=(EditText)findViewById(R.id.annuityPV);
        annuityFV=(EditText)findViewById(R.id.annuityFV);
        RAnswer=(TextView)findViewById(R.id.rAnswer);
        NAnswer=(TextView)findViewById(R.id.nAnswer);
        cfAnswer=(TextView)findViewById(R.id.cfAnswer);
        FVAnswer=(TextView)findViewById(R.id.fvAnswer);
        PVAnswer=(TextView)findViewById(R.id.pvAnswer);

    }

    public void calculate(View view)
    {
        double c=Double.NaN;
        double n=Double.NaN;
        double r=Double.NaN;
        double fv=Double.NaN;
        double pv=Double.NaN;
        double answer=Double.NaN;

        try {
            c = Double.parseDouble(annuityCash.getText().toString());
        }
        catch (NumberFormatException e) {
            c=Double.NaN;
        }
        try {
            n=Double.parseDouble(annuityN.getText().toString());

        }
        catch (NumberFormatException e) {
            n=Double.NaN;
        }
        try {

            r=Double.parseDouble(annuityRate.getText().toString());
        }
        catch (NumberFormatException e) {
            r=Double.NaN;
        }

        try{
            fv=Double.parseDouble(annuityFV.getText().toString());

        }
        catch (NumberFormatException e)
        {
            fv=Double.NaN;
        }
        try{
            pv=Double.parseDouble(annuityPV.getText().toString());


        }
        catch (NumberFormatException e)
        {
            pv=Double.NaN;
        }

        if (!Double.isNaN(c) && !Double.isNaN(n) && !Double.isNaN(r)) {
            answer = (1 + r) * c * ((Math.pow(1 + r, n) - 1) / r);
            annuityAnswer.setText("FV of Annuity Due: " + Double.toString(answer));
            answer = c * ((1 - Math.pow(1 + r, -1 * n)) / r) * (1 + r);
            annuityAnswer.setText(annuityAnswer.getText().toString() + "\n\r PV OF Annuity Due: " + Double.toString(answer));
        }
        else if (!Double.isNaN(c) && !Double.isNaN(n) && !Double.isNaN(fv))
        {

        }
        else if (!Double.isNaN(c) && !Double.isNaN(n) && !Double.isNaN(pv))
        {

        }
        else if (!Double.isNaN(n) && !Double.isNaN(r) && !Double.isNaN(pv))
        {

        }
        else if (!Double.isNaN(n) && !Double.isNaN(r) && !Double.isNaN(fv))
        {

        }
        else if (!Double.isNaN(c) && !Double.isNaN(r) && !Double.isNaN(pv))
        {

        }
        else if(!Double.isNaN(c) && !Double.isNaN(r) && !Double.isNaN(fv))
        {

        }

    }



}
