package com.saveetha.e_book.userscreens;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.saveetha.e_book.AddReviewActivity;
import com.saveetha.e_book.R;
import com.saveetha.e_book.databinding.ActivityBookDetailsBinding;

public class BookDetailsActivity extends AppCompatActivity {

    ActivityBookDetailsBinding binding;
    private String book_name, book_image, book_description, book_id, book_author, book_price, book_publisher_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent() != null) {
            book_name = getIntent().getStringExtra("book_name");
            book_image = getIntent().getStringExtra("book_image");
            book_description = getIntent().getStringExtra("book_description");
            book_id = getIntent().getStringExtra("book_id");
            book_author = getIntent().getStringExtra("book_author");
            book_price = getIntent().getStringExtra("book_price");
            book_publisher_id = getIntent().getStringExtra("book_publisher_id");
        }

        loadBookDetails();
        onClick();
    }

    private void onClick() {
        binding.reviewCV.setOnClickListener(v->{
            Intent intent = new Intent(this, AddReviewActivity.class);
            intent.putExtra("book_id", book_id);
            intent.putExtra("book_name", book_name);
            intent.putExtra("book_image", book_image);
            intent.putExtra("book_publisher_id", book_publisher_id);
            intent.putExtra("book_author", book_author);
            intent.putExtra("book_price", book_price);
            intent.putExtra("book_description", book_description);
            startActivity(intent);
        });
    }

    private void loadBookDetails() {
        binding.bookNameTV.setText(book_name);
        binding.autherNameTV.setText(book_author);
        binding.bookDescription.setText(book_description);
        binding.bookPriceTV.setText(book_price);
    }
}