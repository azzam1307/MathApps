package com.example.bottonmenuexample.bangunruang;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bottonmenuexample.R;
import com.example.bottonmenuexample.fragments.BangunRuang;

import java.text.DecimalFormat;

public class Prisma extends Fragment {

    private EditText etAlas, etTinggi;
    private TextView tvHasilVolume;
    private Button btnBack;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.prisma, container, false);

        etAlas = view.findViewById(R.id.input1);
        etTinggi = view.findViewById(R.id.input2);
        tvHasilVolume = view.findViewById(R.id.hasiljumlah);
        btnBack = view.findViewById(R.id.btn_back);

        etAlas.addTextChangedListener(textWatcher);
        etTinggi.addTextChangedListener(textWatcher);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToPreviousFragment();
            }
        });

        return view;
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            hitung();
        }
    };

    private void hitung() {
        double alas = etAlas.getText().toString().isEmpty() ? 0 : Double.parseDouble(etAlas.getText().toString());
        double tinggiPrisma = etTinggi.getText().toString().isEmpty() ? 0 : Double.parseDouble(etTinggi.getText().toString());

        double volume = 0.5 * alas * tinggiPrisma;

        // Mengatur format tampilan volume agar tidak menampilkan pecahan nol
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedVolume = decimalFormat.format(volume);

        tvHasilVolume.setText("Volume: " + formattedVolume);
    }

    private void goBackToPreviousFragment() {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new BangunRuang());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
