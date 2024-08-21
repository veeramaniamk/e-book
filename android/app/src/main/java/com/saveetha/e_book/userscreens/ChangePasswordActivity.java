package com.saveetha.e_book.userscreens;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.R;
import com.saveetha.e_book.databinding.ActivityChangePasswordBinding;

public class AdminBookDetailsActivity extends AppCompatActivity {

    ActivityChangePasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
 }
