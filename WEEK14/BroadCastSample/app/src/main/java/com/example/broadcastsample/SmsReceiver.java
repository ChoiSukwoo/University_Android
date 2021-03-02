package com.example.broadcastsample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {
    public static final String TAG = "SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(TAG,"onReceiver");

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages != null && messages.length>0){

            String sender = messages[0].getOriginatingAddress();
            Log.i(TAG,"smsSender" + sender);

            String contents = messages[0].getMessageBody();
            Log.i(TAG,"onContents" + contents);

            Date ReceivedData = new Date(messages[0].getTimestampMillis());
            Log.i(TAG,"onReceiver");
        }
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle){
        Object[] obj = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[obj.length];

        int smsCount = obj.length;
        for (int i =0;i<smsCount;i++){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[])obj[i],format);
            }else {
                messages[i] = SmsMessage.createFromPdu((byte[])obj[i]);
            }
        }
        return  messages;
    }
}
