package com.example.bottonmenuexample.bangundatar;

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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bottonmenuexample.R;
import com.example.bottonmenuexample.fragments.BangunRuang;

import java.text.DecimalFormat;

public class PersegiPanjang extends Fragment {

    private EditText etPanjang, etLebar;
    private TextView tvHasilLuas;
    private Button btnBack;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.persegipanjang, container, false);

        etPanjang = view.findViewById(R.id.input1);
        etLebar = view.findViewById(R.id.input2);
        tvHasilLuas = view.findViewById(R.id.hasiljumlah);
        btnBack = view.findViewById(R.id.btn_back);

        // Set inputType agar hanya dapat menginput angka
        etPanjang.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        etLebar.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        etPanjang.addTextChangedListener(textWatcher);
        etLebar.addTextChangedListener(textWatcher);

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
        double panjang = etPanjang.getText().toString().isEmpty() ? 0 : Double.parseDouble(etPanjang.getText().toString());
        double lebar = etLebar.getText().toString().isEmpty() ? 0 : Double.parseDouble(etLebar.getText().toString());

        double luas = panjang * lebar;

        // Format hasil perhitungan dengan menghapus angka desimal jika bagian pecahannya adalah nol
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedLuas = decimalFormat.format(luas);

        tvHasilLuas.setText("Luas: " + formattedLuas);
    }

    private void goBackToPreviousFragment() {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new BangunRuang());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
