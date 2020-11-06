package com.example.week9_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    boolean check=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        check = intent.getBooleanExtra("check", false);
        Log.d("check", ""+check);


        if(intent!=null) {
            Toast.makeText(getApplicationContext(), intent.getStringExtra("name")+" 페이지", Toast.LENGTH_LONG).show();
        }

        if (check == true) {//정상 로그인으로 들어왓을때
            String id = intent.getStringExtra("id");
            String pass = intent.getStringExtra("pw");
        }


        Button menu_Button1 = findViewById(R.id.menu_button_1);
        Button menu_Button2 = findViewById(R.id.menu_button_2);
        Button menu_Button3 = findViewById(R.id.menu_button_3);


        menu_Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == true) {
                    Intent intent = new Intent(getApplicationContext(), GuestManager.class);
                    intent.putExtra("name", "메인메뉴");
                    startActivityForResult(intent, 102);
                } else {
                    finish();
                }
            }
        });

        menu_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == true) {
                    Intent intent = new Intent(getApplicationContext(), MarginManager.class);
                    intent.putExtra("name", "메인메뉴");
                    startActivityForResult(intent, 102);
                } else {
                    finish();
                }
            }
        });

        menu_Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == true) {
                    Intent intent = new Intent(getApplicationContext(), GoodsManager.class);
                    intent.putExtra("name", "메인메뉴");
                    startActivityForResult(intent, 102);
                }else {
                    finish();
                }
            }
        });
    }
}