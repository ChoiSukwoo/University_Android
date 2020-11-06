package com.example.week9_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText id_text;
    EditText pw_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_text = findViewById(R.id.id_text);
        pw_text = findViewById(R.id.pw_text);


        Intent intent = getIntent();
        if(intent!=null & intent.getStringExtra("name")!=null) {
            Toast.makeText(getApplicationContext(), intent.getStringExtra("name")+" 페이지", Toast.LENGTH_LONG).show();
        }

        Button main_button = findViewById(R.id.main_button);
        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                if (id_text.getText().toString().equals("") | pw_text.getText().toString().equals("")) {
                    intent.putExtra("check", false);
                    Toast.makeText(getApplicationContext(),"입력하시오",Toast.LENGTH_LONG).show();
                } else {
                    Log.d("check","id : " + ""+id_text.getText()+" pass: " + pw_text.getText() );
                    intent.putExtra("check", true);
                    intent.putExtra("id", id_text.getText());
                    intent.putExtra("data1", pw_text.getText());
                }

                intent.putExtra("name", "메인");
                startActivityForResult(intent,101);
            }
        });
    }
}