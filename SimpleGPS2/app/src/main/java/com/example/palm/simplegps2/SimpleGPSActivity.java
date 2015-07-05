package com.example.palm.simplegps2;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.Toast;


public class SimpleGPSActivity extends Activity {
    private LocationManager lm;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_gps);
        lm=(LocationManager) getSystemService(Context,LOCATION_SERVICE);
        locationListener = new MyLocationListener();
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,1,locationListener);
    }

    private class MyLocationListener implements LocationListener{
        public  void onLocationChange(Location loc){
            if(loc != null){
                Toast.makeText(getBaseContext(),"Location change /nLat: " +loc.getLatitude()+"/nLng: "+loc.getLongitude(),Toast.LENGTH_SHORT).show();
            }
        }
        public  void onProviderDisabled(String provider){

        }
        public void onProviderEnabled(String provider){

        }
        public void onStatusChanged(String provider,int ststus,Bundle extras){

        }
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_g, menu);
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
