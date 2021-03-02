package com.example.sampleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }


    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(TAG,"onCreate() 호출");
    }

    @Override
    public int onStartCommand(Intent intent,int flag,int StartId){
        Log.d(TAG,"onStartCommand() 호출");

        if(intent == null){
            return Service.START_STICKY;
        }else {
            processCommand(intent);
        }
        return super.onStartCommand(intent,flag,StartId);
    }


    private void processCommand(Intent intent){
        String Command = intent.getStringExtra("Command");
        String Name = intent.getStringExtra("Name");

        Log.d(TAG,"command : " + Command + " Name : " + Name);

        for (int i =0;i<5;i++){
            try {
                Thread.sleep(1000);
            } catch (Exception e){ }
            Log.d(TAG,"Wait : " + i + " Second" );
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }




}
