package com.example.palm.mytabwidget;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Tab1");

        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Home");
        tabHost.addTab(tabSpec);

        tabSpec=tabHost.newTabSpec("tab2");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Setting");
        tabHost.addTab(tabSpec);

        tabSpec=tabHost.newTabSpec("tab3");
        tabSpec.setContent(R.id.tab3);
        //tabSpec.setContent(new Intent(this,MyActivity.class));
        tabSpec.setIndicator("About", getResources().getDrawable(android.R.drawable.ic_dialog_info));
        tabHost.addTab(tabSpec);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
