package com.example.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        View view1 = findViewById(R.id.view1);
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int action = motionEvent.getAction();

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if (action == MotionEvent.ACTION_BUTTON_PRESS){
                    textView.append("손가락눌림" + curX +" , "+ curY);
                }

                if (action == MotionEvent.ACTION_MOVE){
                    textView.append("손가락움직임" + curX +" , "+ curY);
                }

                if (action == MotionEvent.ACTION_UP){
                    textView.append("손가락 땜" + curX +" , "+ curY);
                }
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });

        detector = new GestureDetector(this,new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                textView.append("OnDown() 호출됨");
                return false;
            }
            @Override
            public void onShowPress(MotionEvent motionEvent) {
                textView.append("onShowPress() 호출됨");

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                textView.append("onSingleTapUp() 호출됨");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                textView.append("onScroll() 호출됨" + v + ", " + v1);
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                textView.append("onLongPress() 호출됨");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                textView.append("onFling() 호출됨");
                return false;
            }
        });
    }
    public class myButton extends View {
        public myButton(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            detector.onTouchEvent(event);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(MainActivity.this,"시스템 BACK버튼이 눌렷습니다.",Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

}