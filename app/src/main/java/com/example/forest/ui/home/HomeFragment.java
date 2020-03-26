package com.example.forest.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.forest.R;
import com.example.forest.monedero;

import java.util.Locale;

public class HomeFragment extends Fragment {
TextView tiempo;
Vibrator satysfier;
Button suma,resta,empezar,salir,SI,NO;
final int tempoDefault=600000;
int tempo=tempoDefault;
CountDownTimer cronometro;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
         //TextView textView = root.findViewById(R.id.text_home);
         tiempo = root.findViewById(R.id.text_tiempo);
         suma= root.findViewById(R.id.button);
         resta = root.findViewById(R.id.button2);
         empezar = root.findViewById(R.id.button3);
         salir = root.findViewById(R.id.button4);
        SI = root.findViewById(R.id.button5);
        NO = root.findViewById(R.id.button6);
         tiempo.setText(Formateo(tempo));
         empezar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 empezar.setVisibility(View.INVISIBLE);
                 suma.setVisibility(View.INVISIBLE);
                 resta.setVisibility(View.INVISIBLE);
                 salir.setVisibility(View.VISIBLE);
                 cronometro = new CountDownTimer(tempo,1000){

                     @Override
                     public void onTick(long millisUntilFinished) {
                         tiempo.setText("Quedan "+Formateo(millisUntilFinished));
                     }

                     @Override
                     public void onFinish() {
                         tiempo.setText("tiempoooo");
                         empezar.setVisibility(View.VISIBLE);
                         salir.setVisibility(View.INVISIBLE);
                     }
                 };
                 cronometro.start();
             }
         });
         suma.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (tempo==14400000){

                 }else {
                     tempo += 300000;
                     tiempo.setText(Formateo(tempo));
                 }
             }
         });
         resta.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (tempo==tempoDefault){

                 }else{
                 tempo-=300000;
                 tiempo.setText(Formateo(tempo));
                 }
             }
         });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SI.setVisibility(View.VISIBLE);
                NO.setVisibility(View.VISIBLE);
                salir.setVisibility(View.INVISIBLE);
            }
        });
        SI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cronometro.cancel();
                SI.setVisibility(View.INVISIBLE);
                NO.setVisibility(View.INVISIBLE);
                suma.setVisibility(View.VISIBLE);
                resta.setVisibility(View.VISIBLE);
                empezar.setVisibility(View.VISIBLE);
                tempo=tempoDefault;
                tiempo.setText(Formateo(tempo));

            }
        });
        NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SI.setVisibility(View.INVISIBLE);
                NO.setVisibility(View.INVISIBLE);
                salir.setVisibility(View.VISIBLE);
            }
        });




        return root;
    }
    public String Formateo(long i){
        int minutes = (int) (i/1000)/60;
        int secs= (int)(i/1000)%60;
        return String.format(Locale.getDefault(),"%02d:%02d",minutes,secs);

    }

}