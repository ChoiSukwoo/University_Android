package com.example.extra;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        int a = intent.getIntExtra("data",0);
    }



    public  void MyClick(View v){
        Intent intent = new Intent();
        intent.putExtra("name","mike");
        setResult(RESULT_OK,intent);
        finish();
    }
}
