package com.example.palm.myoptionmeni;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuInflater;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.help:
                Toast.makeText(getBaseContext(),"Go to Help.",Toast.LENGTH_LONG).show();
                return true;
            case R.id.setting:
                Toast.makeText(getBaseContext(),"Go to Setting.",Toast.LENGTH_LONG).show();
                break;
        }

        return false;
    }
}
