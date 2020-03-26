package com.example.forest.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.forest.R;

public class ShareFragment extends Fragment {
    TextView monedas;
    final int MonedasDefault= 5000;
    int money=MonedasDefault;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tienda, container, false);
        ImageButton comprar = root.findViewById(R.id.buyButton);
        monedas = root.findViewById(R.id.textMoney);
        monedas.setText(String.valueOf(money));
        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money - 4500;
                monedas.setText(String.valueOf(money));
            }
        });
        return root;
    }
}