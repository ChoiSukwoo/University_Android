package com.example.week6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

    }


    public void myClick(View view){
        try {
            Toast toastView = Toast.makeText(this,"위치가 바뀐 토스트 메세지 입니다.",Toast.LENGTH_SHORT);
            int xOffset = Integer.parseInt(editText1.getText().toString());
            int yOffset = Integer.parseInt(editText2.getText().toString());
            toastView.setGravity(Gravity.TOP|Gravity.TOP,xOffset,yOffset);
            toastView.show();
        }catch (NumberFormatException exception){
            exception.printStackTrace();
        }
    }

    public void myClick1(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toastborder, (ViewGroup)findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewById(R.id.text);
        text.setText("모양 바꾼 토스트");

        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER,0,-100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void myClick2(View view){
        Snackbar.make(view,"스낵바 입니다.",Snackbar.LENGTH_SHORT).show();
    }


}