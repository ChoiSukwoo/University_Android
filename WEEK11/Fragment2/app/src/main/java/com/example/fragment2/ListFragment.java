package com.example.fragment2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ListFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public interface ImgSelectionCallback {
        public void onImgSelect(int pos);
    }

    ImgSelectionCallback callback;

    ViewGroup rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list,container,false);

        Button button1 = rootView.findViewById(R.id.Button1);
        Button button2 = rootView.findViewById(R.id.Button2);
        Button button3 = rootView.findViewById(R.id.Button3);

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ImgSelectionCallback){
            callback = (ImgSelectionCallback)context;
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (callback != null) {
                switch (v.getId()){
                    case R.id.Button1 :
                        callback.onImgSelect(0);
                        break;
                    case R.id.Button3 :
                        callback.onImgSelect(1);
                        break;
                    case R.id.Button2 :
                        callback.onImgSelect(2);
                        break;

                }
            }
        }
    };

}