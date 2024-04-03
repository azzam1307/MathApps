package com.example.bottonmenuexample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.bottonmenuexample.R;

public class Profile extends Fragment {

    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment3, container, false);

        // Mendapatkan referensi ImageView untuk tombol logout
        ImageView logoutImageView = view.findViewById(R.id.btn_logout);

        // Menambahkan OnClickListener untuk gambar logout
        logoutImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lakukan tindakan ketika gambar logout diklik di sini
                // Misalnya, tutup fragment atau lakukan tindakan lain
                getActivity().onBackPressed(); // Menutup fragment saat tombol logout diklik
            }
        });

        return view;
    }
}
