package com.example.week9_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GuestManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_manager);

        Intent intent = getIntent();
        if(intent!=null) {
            Toast.makeText(getApplicationContext(), intent.getStringExtra("name")+" 페이지", Toast.LENGTH_LONG).show();
        }

        Button menu_Button1 = findViewById(R.id.guest_button1);
        menu_Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button menu_Button2 = findViewById(R.id.guest_button2);
        menu_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult( new Intent(getApplicationContext(), MainActivity.class).putExtra("name","고객 관리"), 103);
            }
        });
    }
}