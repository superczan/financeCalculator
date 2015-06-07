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

/**
 * Created by shijan shrest on 2/7/2015.
 */
public class BaseClass extends Activity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuItem1) {
            Intent intent = new Intent(BaseClass.this, MainActivity.class);
            startActivityForResult(intent,0);
        } else if (id == R.id.menuItem2) {
            Intent intent = new Intent(BaseClass.this, annuityCalculation.class);
            startActivityForResult(intent,0);

        } else if (id == R.id.menuItem3) {
            Intent intent = new Intent(BaseClass.this, AnnuityDue.class);
            startActivityForResult(intent,0);
        }
        else if (id==R.id.menuItem4)
        {
            Intent intent=new Intent(BaseClass.this,Perpetuity.class);
            startActivityForResult(intent,0);

        }
        return super.onOptionsItemSelected(item);
    }




}
