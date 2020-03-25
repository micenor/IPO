package com.example.forest.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.forest.R;

import org.w3c.dom.Text;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tienda, container, false);
        ImageButton comprar = root.findViewById(R.id.buyButton);
        final TextView monedas = root.findViewById(R.id.textView);
        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monedas.setText("500");
            }
        });
        return root;
    }
}