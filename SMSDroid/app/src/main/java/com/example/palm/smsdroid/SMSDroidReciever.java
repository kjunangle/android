package com.example.palm.smsdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.util.Objects;

public class SMSDroidReciever  extends BroadcastReceiver{
    private  static final String SMS_RECEIVED = "androd.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context,Intent intent){
        if(intent.getAction().equals(SMS_RECEIVED)){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                Object[] pdus = (Object[]) bundle.get("pdus");
                final  SmsMessage[] messages = new SmsMessage[pdus.length];
                for(int i =0;i<pdus.length;i++){
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                if(messages.length>-1){
                    Toast.makeText(context,"Messagr From :"+messages[0].getOriginatingAddress()+"/n"+messages[0].getMessageBody(),Toast.LENGTH_LONG).show();

                }
            }
        }
    }

}
