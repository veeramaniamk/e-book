package com.saveetha.e_book.userscreens;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.saveetha.e_book.R;
import com.saveetha.e_book.databinding.ActivityBookDetailsBinding;

public class BookDetailsActivity extends AppCompatActivity {

    ActivityBookDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}