package com.example.week5_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();
                Toast.makeText(MainActivity.this,"입력된 값 저장" + name, Toast.LENGTH_LONG).show();
            }
        });
        if(savedInstanceState != null){
            name = savedInstanceState.getString("name") ;
            Toast.makeText(MainActivity.this,"입력된 값 호출" + name, Toast.LENGTH_LONG).show();
            editText.setText(name);
        }
    }

    @Override
    protected void onStart() {
        Toast.makeText(this, "onStart 호출됨", Toast.LENGTH_LONG).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop 호출됨", Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy 호출됨", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        name = editText.getText().toString();
        outState.putString("name",name);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this,"가로방향",Toast.LENGTH_SHORT).show();
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this,"세로방향",Toast.LENGTH_SHORT).show();
        }
    }


}