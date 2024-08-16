package com.saveetha.e_book.adminscreens;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.saveetha.e_book.R;
import com.saveetha.e_book.databinding.ActivityAdminDashboardBinding;

public class AdminDashboardActivity extends AppCompatActivity {

    ActivityAdminDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityAdminDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.adminNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                int itemId = item.getItemId();

                if (itemId == R.id.admin_home) {
                    selectedFragment = new AdminHomeFragment();
                } else if (itemId == R.id.admin_request) {
                    selectedFragment = new AdminRequestFragment();
                }    else if (itemId == R.id.admin_profile) {
                    selectedFragment = new AdminHomeFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.adminContainer, selectedFragment).commit();
                return true;
            }
        });



    }
}