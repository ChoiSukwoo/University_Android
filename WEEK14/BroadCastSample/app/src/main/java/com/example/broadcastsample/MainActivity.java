package com.example.broadcastsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoPermissions.Companion.loadAllPermissions(this,101);
    }

    @Override
    public void onDenied(int i, String[] strings) {
        Toast.makeText(this,"permissions Denied : " + strings.length,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onGranted(int i, String[] strings) {
        Toast.makeText(this,"permissions Granted : " + strings.length,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResult) {
        super.onRequestPermissionsResult(requestCode,permissions,grantResult);
        AutoPermissions.Companion.parsePermissions(this,requestCode,permissions,this);
    }
}