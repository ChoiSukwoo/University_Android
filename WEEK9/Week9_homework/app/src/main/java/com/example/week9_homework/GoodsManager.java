package com.example.week9_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GoodsManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_manager);

        Intent intent = getIntent();
        if(intent!=null) {
            Toast.makeText(getApplicationContext(), intent.getStringExtra("name")+" 페이지", Toast.LENGTH_LONG).show();
        }

        Button goods_button1 = findViewById(R.id.goods_button1);
        goods_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button goods_button2 = findViewById(R.id.goods_button2);
        goods_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult( new Intent(getApplicationContext(), MainActivity.class).putExtra("name","상품 관리"), 105);
            }
        });
    }
}