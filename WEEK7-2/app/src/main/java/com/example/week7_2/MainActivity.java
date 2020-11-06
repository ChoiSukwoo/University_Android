package com.example.week7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

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
                String data = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("MyAction");
                //Intent intent1 = new Intent(getApplicationContext(),MainActivity2.class);
                //ComponentName name = new ComponentName("com.example.week7_2","com.example.week7_2.MainActivity2");
                //intent.setComponent(name);
                startActivity(intent);
            }
        });

    }
}