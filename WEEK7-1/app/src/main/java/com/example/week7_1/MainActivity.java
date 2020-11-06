package com.example.week7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    public static final  int Int= 101 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivityForResult(intent,Int);
            }
        });
    }

    public void onActivityResult(int req,int result,Intent intent){
        super.onActivityResult(req,result,intent );

        if(req == Int ){
            Toast.makeText(getApplicationContext(),"onActivityResult메소드 호출됨. 요청코드 : " + req + "  결과코드 : "+ result,Toast.LENGTH_SHORT).show();
        }

        if(req == RESULT_OK ){
            String name = intent.getExtras().getString("name");
            Toast.makeText(getApplicationContext(),"응답으로 전달된 name :  "+ name,Toast.LENGTH_LONG).show();
        }
    };
}