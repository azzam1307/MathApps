package com.example.bottonmenuexample;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bottonmenuexample.fragments.BangunDatar;
import com.example.bottonmenuexample.fragments.BangunRuang;
import com.example.bottonmenuexample.fragments.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        // Load the default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new BangunDatar())
                .commit();
    }

    private BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.menu_item1) {
                        selectedFragment = new BangunDatar();
                    } else if (item.getItemId() == R.id.menu_item2) {
                        selectedFragment = new BangunRuang();
                    } else if (item.getItemId() == R.id.menu_item3) {
                        selectedFragment = new Profile();
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, selectedFragment)
                            .commit();

                    return true;
                }
            };
}
