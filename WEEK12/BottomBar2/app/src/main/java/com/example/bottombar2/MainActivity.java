package com.example.bottombar2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment1 frame1;
    Fragment2 frame2;
    Fragment3 frame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame1 = new Fragment1();
        frame2 = new Fragment2();
        frame3 = new Fragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,frame1).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "첫번째 탭 선택됨", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, frame1).commit();
                        return true;
                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(), "듀번째 탭 선택됨", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, frame2).commit();
                        return true;
                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "세번째 탭 선택됨", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, frame3).commit();
                        return true;
                }
                return false;
            }
        });
    }
}