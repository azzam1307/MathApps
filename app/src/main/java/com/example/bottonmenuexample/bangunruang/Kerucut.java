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

public class Kerucut extends Fragment {

    private EditText etJariJari, etTinggi;
    private TextView tvHasilVolume;
    private Button btnBack;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kerucut, container, false);

        etJariJari = view.findViewById(R.id.input1);
        etTinggi = view.findViewById(R.id.input2);
        tvHasilVolume = view.findViewById(R.id.hasiljumlah);
        btnBack = view.findViewById(R.id.btn_back);

        etJariJari.addTextChangedListener(textWatcher);
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
        double jariJari = etJariJari.getText().toString().isEmpty() ? 0 : Double.parseDouble(etJariJari.getText().toString());
        double tinggi = etTinggi.getText().toString().isEmpty() ? 0 : Double.parseDouble(etTinggi.getText().toString());

        double volume = (1.0 / 3.0) * 3.14 * jariJari * jariJari * tinggi;

        // Mengatur format tampilan volume agar tidak menampilkan pecahan nol
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedVolume = decimalFormat.format(volume);

        // Menampilkan hasil volume
        tvHasilVolume.setText("Volume: " + formattedVolume);
    }

    private void goBackToPreviousFragment() {
        if (getFragmentManager() != null) {
            getFragmentManager().popBackStack();
        }
    }
}
