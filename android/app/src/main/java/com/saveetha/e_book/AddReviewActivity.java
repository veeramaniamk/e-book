package com.saveetha.e_book;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.databinding.ActivityAddReviewBinding;
import com.saveetha.e_book.reviewerscrees.ReviewerAddBookActivity;
import com.saveetha.e_book.reviewerscrees.ReviewerAddCategoryActivity;

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


            }
        });
    }

    private void showPopupWindow(View anchorView) {
        // Inflate the custom layout
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.add_review_layout, null);

        // Create the PopupWindow
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText review = popupView.findViewById(R.id.reviewET);
        Button send = popupView.findViewById(R.id.sendBtn);



        send.setOnClickListener(v -> {
            String reviewText = review.getText().toString();
            if (reviewText.isEmpty()) {
                Toast.makeText(this, "write something!", Toast.LENGTH_SHORT).show();
            } else {
                sendReview();
            }
        });

        popupWindow.showAtLocation(anchorView, Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0); // Adjust gravity and position as needed

    }

    private void sendReview() {

    }
}