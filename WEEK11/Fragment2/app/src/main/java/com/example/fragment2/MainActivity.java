package com.example.fragment2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements com.example.fragment2.ListFragment.ImgSelectionCallback {

    ListFragment ListFragmnet;
    ImgFragment ImgFragmnet;

    int[] images = {R.drawable.dream01,R.drawable.dream02,R.drawable.dream03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        ListFragmnet = (ListFragment) manager.findFragmentById(R.id.ListFragment);
        ImgFragmnet = (ImgFragment) manager.findFragmentById(R.id.ImgFragment);
    }

    public void onImgSelect(int pos){
        Log.d("test : ",""+pos);
        ImgFragmnet.setImgView(images[pos]);
    }
}