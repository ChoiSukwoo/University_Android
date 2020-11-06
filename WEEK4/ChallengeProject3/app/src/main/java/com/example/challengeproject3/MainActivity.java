package com.example.challengeproject3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class   MainActivity extends AppCompatActivity {

    ScrollView Challenge3Scroll1;
    ImageView Challenge3Image1;
    ScrollView Challenge3Scroll2;
    ImageView Challenge3Image2;
    Button Challenge3Button1;
    Button Challenge3Button2;

    EditText Challenge4EditText;
    TextView Challenge4TextView;
    Button Challenge4Button1;
    Button Challenge4Button2;

    BitmapDrawable Image;

    static Integer Challenge3State;
    final static Integer Up = 0;
    final static Integer Down = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Challenge3State = Down;

        //스크롤 뷰와 이미지뷰 할당후 기능까지 장착
        Challenge3Scroll1 = (ScrollView)findViewById(R.id.challenge3ScrollView1);
        Challenge3Scroll1.setHorizontalScrollBarEnabled(true);
        Challenge3Image1 = (ImageView)findViewById(R.id.challenge3Image1);
        Challenge3Scroll2 = (ScrollView)findViewById(R.id.challenge3ScrollView2);
        Challenge3Scroll2.setHorizontalScrollBarEnabled(true);
        Challenge3Image2 = (ImageView)findViewById(R.id.challenge3Image2);

        //버튼 할당밍 온클릭 리스너 재할당
        Challenge3Button1 = (Button)findViewById(R.id.challenge3Button1);
        Challenge3Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeView(R.id.challenge3Button1);
            }
        });
        Challenge3Button2 = (Button)findViewById(R.id.challenge3Button2);
        Challenge3Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeView(R.id.challenge3Button2);
            }
        });


        //도전 4 각 뷰 할당 및 기능할당
        Challenge4EditText = (EditText)findViewById(R.id.challenge4EditText);
        Challenge4EditText.addTextChangedListener(
                new TextWatcher(){
                    @Override
                    public void beforeTextChanged(CharSequence charSequence,  int start, int count, int after) {
                    }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int count, int after, int start) {
                        int Count = charSequence.length();
                        Challenge4TextView.setText(""+Count+"/80 바이트" );
                    }
                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                }
        );
        Challenge4TextView = (TextView)findViewById(R.id.challenge4TextView);
        Challenge4Button1 = (Button)findViewById(R.id.challenge4Button1);
        Challenge4Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),Challenge4EditText.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        Challenge4Button2 = (Button)findViewById(R.id.challenge4Button2);
        Challenge4Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Challenge4EditText.setText("");
                Challenge4TextView.setText("0/80 바이트" );
            }
        });




        Image = (BitmapDrawable)getResources().getDrawable(R.drawable.background_img);
        ChangeView(R.id.challenge3Button1);
    }


    //이미지뷰의 이미지지 전환 기능
   public void ChangeView(Integer ButtonId){
        switch (ButtonId){
            case R.id.challenge3Button1:
                if(Challenge3State == Down) {
                    Challenge3State = Up;

                    Challenge3Image1.setImageDrawable(Image);
                    Challenge3Image1.getLayoutParams().width = Image.getIntrinsicWidth();
                    Challenge3Image1.getLayoutParams().height = Image.getIntrinsicHeight();

                    Challenge3Image2.setImageDrawable(null);
                }
                break;
            case R.id.challenge3Button2:
                if(Challenge3State == Up) {
                    Challenge3State = Down;

                    Challenge3Image2.setImageDrawable(Image);
                    Challenge3Image2.getLayoutParams().width = Image.getIntrinsicWidth();
                    Challenge3Image2.getLayoutParams().height = Image.getIntrinsicHeight();

                    Challenge3Image1.setImageDrawable(null);
                }
                break;
        }


    }



}


