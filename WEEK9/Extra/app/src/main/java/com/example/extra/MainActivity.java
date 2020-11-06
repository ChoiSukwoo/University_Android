package com.example.extra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_CODE_MENU = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);

                intent.putExtra("data",100);
                intent.putExtra("data1",200);
                intent.putExtra("data2",true);
                startActivityForResult(intent,REQ_CODE_MENU);
            }
        });
    }

    public void onActivityResult(int req,int result,Intent intent){
        super.onActivityResult(req,result,null );

        intent.getStringExtra("name");
    };
}