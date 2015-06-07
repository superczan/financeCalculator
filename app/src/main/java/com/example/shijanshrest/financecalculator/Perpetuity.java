package com.example.shijanshrest.financecalculator;

/**
 * Created by shijan shrest on 2/8/2015.
 */
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
public class Perpetuity extends BaseClass {

    EditText PV;
    EditText c;
    EditText r;
    TextView pvAnswer,fvAnswer,rAnswer;

    public void onCreate(Bundle s)
    {
        super.onCreate(s);
        setContentView(R.layout.perpetuity);
        PV=(EditText)findViewById(R.id.perpetuityPV);
        c=(EditText)findViewById(R.id.perpetuityC);
        r=(EditText)findViewById(R.id.perpetuityR);
        rAnswer=(TextView)findViewById(R.id.rAnswer);
        fvAnswer=(TextView)findViewById(R.id.fvAnswer);
        pvAnswer=(TextView)findViewById(R.id.pvAnswer);

    }

    public void calculate1(View view)
    {
      double pv=0;
      double c1=0;
      double r1=0;

      try{
        pv=Double.parseDouble(PV.getText().toString());
      }
      catch (NumberFormatException e)
      {
        pv=Double.NaN;
      }

      try{
         c1=Double.parseDouble(c.getText().toString());
      }
      catch (NumberFormatException e)
      {
        c1=Double.NaN;
      }

      try {
        r1=Double.parseDouble(r.getText().toString());

      }
      catch(NumberFormatException e)
      {
            r1=Double.NaN;
      }

      if (!Double.isNaN(c1) && !Double.isNaN(r1))
      {
         pv=c1/r1;
         pv=(int)(pv*100.0)/100.0;
         fvAnswer.setText(Double.toString(pv));
          rAnswer.setText(Double.toString(r1));
          pvAnswer.setText(Double.toString(c1));
      }
      else if (!Double.isNaN(pv) && !Double.isNaN(c1))
      {
         r1=c1/pv;
         r1=(int)(r1*100)/100.0;
          rAnswer.setText(Double.toString(r1));
            pvAnswer.setText(Double.toString(c1));
            fvAnswer.setText(Double.toString(pv));
      }
      else if (!Double.isNaN(pv) && !Double.isNaN(r1))
      {
        c1=pv*r1;
          c1=(int)(c1*100)/100.0;
          fvAnswer.setText(Double.toString(pv));
          pvAnswer.setText(Double.toString(c1));
          rAnswer.setText(Double.toString(r1));
      }
        else
      {
          pvAnswer.setText("??");
          fvAnswer.setText("??");
          rAnswer.setText("??");


      }
    }
}
