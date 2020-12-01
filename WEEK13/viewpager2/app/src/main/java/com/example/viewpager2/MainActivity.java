package com.example.viewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Fragment1 fragment1 ;
    Fragment2 fragment2 ;
    Fragment3 fragment3 ;

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        fragment1 = new Fragment1();
        adapter.additem(fragment1);
        fragment2 = new Fragment2();
        adapter.additem(fragment2);
        fragment3 = new Fragment3();
        adapter.additem(fragment3);

        pager.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
            }
        });

    }


    class MyPagerAdapter extends FragmentStatePagerAdapter{
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(@NonNull FragmentManager fm) { super(fm); }

        public void additem(Fragment item){ items.add(item); }

        @NonNull
        @Override
        public Fragment getItem(int position) { return items.get(position); }

        @Override
        public int getCount() { return items.size() ; }

        @NonNull
        @Override
        public CharSequence getPageTitle(int position){
            return "페이지" + position;
        }
    }
}