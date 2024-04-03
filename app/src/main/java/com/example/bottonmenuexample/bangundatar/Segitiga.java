package com.example.bottonmenuexample.bangundatar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
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

public class Segitiga extends Fragment {

    private EditText etAlas, etTinggi;
    private TextView tvHasilLuas;
    Button btnBack;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.segitiga, container, false);

        etAlas = view.findViewById(R.id.input1);
        etTinggi = view.findViewById(R.id.input2);
        tvHasilLuas = view.findViewById(R.id.hasiljumlah);

        // Set inputType agar hanya dapat menginput angka
        etAlas.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        etTinggi.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        etAlas.addTextChangedListener(textWatcher);
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
        double alas = etAlas.getText().toString().isEmpty() ? 0 : Double.parseDouble(etAlas.getText().toString());
        double tinggi = etTinggi.getText().toString().isEmpty() ? 0 : Double.parseDouble(etTinggi.getText().toString());

        double luas = 0.5 * alas * tinggi;

        // Format hasil perhitungan dengan menghapus angka desimal jika bagian pecahannya adalah nol
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedLuas = decimalFormat.format(luas);

        tvHasilLuas.setText("Luas: " + formattedLuas);
    }
}
