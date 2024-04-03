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

import com.example.bottonmenuexample.R;

import java.text.DecimalFormat;

public class Balok extends Fragment {

    private EditText etPanjang, etLebar, etTinggi;
    private TextView tvHasilVolume;
    Button btnBack;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.balok, container, false);

        etPanjang = view.findViewById(R.id.input1);
        etLebar = view.findViewById(R.id.input2);
        etTinggi = view.findViewById(R.id.input3);
        tvHasilVolume = view.findViewById(R.id.hasiljumlah);

        etPanjang.addTextChangedListener(textWatcher);
        etLebar.addTextChangedListener(textWatcher);
        etTinggi.addTextChangedListener(textWatcher);

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
        double panjang = etPanjang.getText().toString().isEmpty() ? 0 : Double.parseDouble(etPanjang.getText().toString());
        double lebar = etLebar.getText().toString().isEmpty() ? 0 : Double.parseDouble(etLebar.getText().toString());
        double tinggi = etTinggi.getText().toString().isEmpty() ? 0 : Double.parseDouble(etTinggi.getText().toString());

        double volume = panjang * lebar * tinggi;

        // Mengatur format tampilan volume agar tidak menampilkan pecahan nol
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedVolume = decimalFormat.format(volume);

        tvHasilVolume.setText("Volume: " + formattedVolume);
    }
}
