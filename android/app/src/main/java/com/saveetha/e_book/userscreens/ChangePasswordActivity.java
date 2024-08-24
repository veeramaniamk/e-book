package com.saveetha.e_book.userscreens;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.databinding.ActivityChangePasswordBinding;

public class ChangePasswordActivity extends AppCompatActivity {


    ActivityChangePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backCV.setOnClickListener(v -> finish());

        binding.saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}