package com.example.forest.ui.home;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.forest.R;

public class HomeFragment extends Fragment {
TextView tiempo;
Vibrator satysfier;
Button suma,resta,empezar;
int tempo=5000;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
         TextView textView = root.findViewById(R.id.text_home);
         tiempo = root.findViewById(R.id.text_tiempo);
         suma= root.findViewById(R.id.button);
         resta = root.findViewById(R.id.button2);
         empezar = root.findViewById(R.id.button3);
         tiempo.setText(""+(tempo/1000)/60);
         empezar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 empezar.setVisibility(View.INVISIBLE);
                 new CountDownTimer(tempo,1000){

                     @Override
                     public void onTick(long millisUntilFinished) {
                         tiempo.setText("Quedan "+(millisUntilFinished/1000)/60+":"+(millisUntilFinished/1000)%60);

                     }

                     @Override
                     public void onFinish() {
                         tiempo.setText("tiempoooo");
                         empezar.setVisibility(View.VISIBLE);
                     }
                 }.start();
             }
         });
         suma.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 tempo+=300000;
                 tiempo.setText(""+(tempo/1000)/60);
             }
         });
         resta.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 tempo-=300000;
                 tiempo.setText(""+(tempo/1000)/60);
             }
         });



        return root;
    }

}