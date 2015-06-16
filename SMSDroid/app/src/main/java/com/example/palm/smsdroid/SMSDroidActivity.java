package com.example.palm.smsdroid;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;


public class SMSDroidActivity extends Activity {

    Button btnSendSMS;
    EditText txtPhoneNo;
    EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsdroid);
        btnSendSMS =(Button) findViewById(R.id.btnSendSMS);
        txtPhoneNo=(EditText) findViewById(R.id.txtPhoneNo);
        txtMessage=(EditText) findViewById(R.id.txtMessage);
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = txtPhoneNo.getText().toString();
                String message= txtMessage.getText().toString();
                if(phoneNo.length()>0&&message.length()>0){
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phoneNo,null,message,null,null);
                }else{
                    Toast.makeText(getBaseContext(),"Please enter both phone and message.",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_smsdroid, menu);
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
