package com.saveetha.e_book.reviewerscrees;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.databinding.ActivityReviewerDashboardBinding;

public class ReviewerDashboardActivity extends AppCompatActivity {

    ActivityReviewerDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityReviewerDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}