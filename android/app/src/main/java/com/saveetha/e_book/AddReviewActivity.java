package com.saveetha.e_book;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.databinding.ActivityAddReviewBinding;

public class AddReviewActivity extends AppCompatActivity {

    ActivityAddReviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddReviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onClick();

    }

    private void onClick() {
        binding.addReviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO
                // add review
                // show Dialog Box To Add Review
                // dialog Box @layout Name : add_review_layout.xml

            }
        });
    }
}