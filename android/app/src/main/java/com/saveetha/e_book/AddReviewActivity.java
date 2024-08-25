package com.saveetha.e_book;

import android.annotation.SuppressLint;
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
import com.saveetha.e_book.request.Request;
import com.saveetha.e_book.response.ReviewResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddReviewActivity extends AppCompatActivity {

    List<ReviewModule> reviewModules = new ArrayList<>();

    ActivityAddReviewBinding binding;

    private String book_name, book_image, book_description, book_id, book_author, book_price, book_publisher_id;
    private int user_id;
    private String reviewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddReviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user_id = getSharedPreferences(Constant.SIGN_IN_SF,MODE_PRIVATE).getInt(Constant.ID_SI_SF,0);

        if (getIntent() != null) {
            book_name = getIntent().getStringExtra("book_name");
            book_image = getIntent().getStringExtra("book_image");
            book_description = getIntent().getStringExtra("book_description");
            book_id = getIntent().getStringExtra("book_id");
            book_author = getIntent().getStringExtra("book_author");
            book_price = getIntent().getStringExtra("book_price");
            book_publisher_id = getIntent().getStringExtra("book_publisher_id");
        }

        onClick();
        loadData();

    }

    private void loadData() {
        Call<ReviewResponse> res = RestClient.makeAPI().getBookReview(Integer.parseInt(book_id));

        res.enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                if(response.isSuccessful()){
                    if(response.body().getStatus().equals("200")){

                        List<ReviewResponse.Review> reviews = response.body().getData();
                        if(reviews.size()>0){

                            for(ReviewResponse.Review review : reviews){
                                reviewModules.add(new ReviewModule(review.getProfile(),review.getUser_name(),review.getReview_text(),review.getDate()));
                            }



                        }
                    }
                } else {
                    Toast.makeText(AddReviewActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {
                Toast.makeText(AddReviewActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void onClick() {
        binding.addReviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPopupWindow(v);
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
                if(sendReview(review)){
                    popupWindow.dismiss();
                }
            }
        });

        popupWindow.showAtLocation(anchorView, Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0); // Adjust gravity and position as needed

    }

    private boolean sendReview(EditText review) {

        final boolean[] isAdded = {true};
        reviewText = review.getText().toString();

        if(reviewText.isEmpty()){
            Toast.makeText(this, "write something!", Toast.LENGTH_SHORT).show();
            isAdded[0] = false;
        }

        Request.SendReview request = new Request.SendReview(book_id,user_id,book_publisher_id,reviewText);

        Call<ReviewResponse> res = RestClient.makeAPI().sendReview(request);

        res.enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                if(response.isSuccessful()){
                    if(response.body().getStatus().equals("200")){
                        Toast.makeText(AddReviewActivity.this, "review added", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddReviewActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {

                isAdded[0] = false;
                Toast.makeText(AddReviewActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        return isAdded[0];
    }
}