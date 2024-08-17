package com.saveetha.e_book.userscreens;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.databinding.ActivityBooksListBinding;

public class BooksListActivity extends AppCompatActivity {

    ActivityBooksListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBooksListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_books_list);
    }
}