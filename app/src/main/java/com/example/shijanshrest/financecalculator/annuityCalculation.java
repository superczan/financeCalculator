package com.example.shijanshrest.financecalculator;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Fragment;

import java.text.NumberFormat;
// Time Value calculation

/**
 * Created by shijan shrest on 1/18/2015.
 */
public class annuityCalculation extends BaseClass
{

    private EditText pv,fv,tvRate,tvTime,tvN;

    private TextView fvAnswer,pvAnswer,rAnswer, nAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.annuity);
        pv=(EditText)findViewById(R.id.pv);
        fv=(EditText)findViewById(R.id.fv);
        tvRate=(EditText)findViewById(R.id.tvRate);
        tvTime=(EditText)findViewById(R.id.tvTime);
        tvN=(EditText)findViewById(R.id.tvTime);
        fvAnswer=(TextView)findViewById(R.id.fvAnswer);
        pvAnswer=(TextView)findViewById(R.id.pvAnswer);
        rAnswer=(TextView)findViewById(R.id.rAnswer);
        nAnswer=(TextView)findViewById(R.id.nAnswer);

    }
    public void calculate1(View view)
    {

        double pvDouble=Double.NaN;
        double fvDouble=Double.NaN;
        double tvRateDouble=Double.NaN;
        double tvNDouble=Double.NaN;
        double answer=Double.NaN;

        try {
            pvDouble = Double.parseDouble(pv.getText().toString());
             }
        catch (NumberFormatException e)
        {
            pvDouble=Double.NaN;
         }
        try {
            fvDouble = Double.parseDouble(fv.getText().toString());
        }
        catch( NumberFormatException e)
        {
            fvDouble=Double.NaN;
        }

        try{

            tvRateDouble = Double.parseDouble(tvRate.getText().toString());
        }
        catch(NumberFormatException e)
        {
            tvRateDouble=Double.NaN;
        }

        try {
            tvNDouble = Double.parseDouble(tvN.getText().toString());
        }
        catch (NumberFormatException e)
        {
            tvNDouble=Double.NaN;
        }


        if (!Double.isNaN(pvDouble) && !Double.isNaN(tvRateDouble) && !Double.isNaN(tvNDouble))
        {
            answer=pvDouble*Math.pow((1+tvRateDouble),tvNDouble);
            //fv.setText(Double.toString(Math.round(answer)));
            answer=(double)Math.round(answer*100)/100.0;
            pvAnswer.setText(Double.toString(pvDouble));
            fvAnswer.setText(Double.toString(answer));
            rAnswer.setText(Double.toString(tvRateDouble));
            nAnswer.setText(Double.toString(tvNDouble));

        }
        else if (!Double.isNaN(fvDouble) && !Double.isNaN(tvRateDouble) && !Double.isNaN(tvNDouble))
        {
           answer=fvDouble/Math.pow((1+tvRateDouble),tvNDouble);
            answer=(double)Math.round(answer*100)/100.0;

            pvAnswer.setText(Double.toString(answer));
            fvAnswer.setText(Double.toString(fvDouble));
            rAnswer.setText(Double.toString(tvRateDouble));
            nAnswer.setText(Double.toString(tvNDouble));

        }
        else if (!Double.isNaN(pvDouble) && !Double.isNaN(fvDouble) && !Double.isNaN(tvRateDouble))
        {
            answer=Math.log(fvDouble/pvDouble)/Math.log(1+tvRateDouble);
            answer=(double)Math.round(answer*100)/100.0;

            pvAnswer.setText(Double.toString(pvDouble));
            fvAnswer.setText(Double.toString(fvDouble));
            rAnswer.setText(Double.toString(tvRateDouble));
            nAnswer.setText(Double.toString(answer));

        }
        else if (!Double.isNaN(pvDouble) && !Double.isNaN(fvDouble) && !Double.isNaN(tvNDouble))
        {
            answer=-1+Math.pow(fvDouble/pvDouble,1/tvNDouble);
            answer=(double)Math.round(answer*100)/100.0;

            pvAnswer.setText(Double.toString(pvDouble));
            fvAnswer.setText(Double.toString(fvDouble));
            rAnswer.setText(Double.toString(answer));
            nAnswer.setText(Double.toString(tvNDouble));

        }
        else
        ;
    }





}
