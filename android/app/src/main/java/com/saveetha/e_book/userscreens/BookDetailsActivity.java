package com.saveetha.e_book.userscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.saveetha.e_book.AddReviewActivity;
import com.saveetha.e_book.Constant;
import com.saveetha.e_book.R;
import com.saveetha.e_book.RestClient;
import com.saveetha.e_book.SF;
import com.saveetha.e_book.databinding.ActivityBookDetailsBinding;
import com.saveetha.e_book.response.CommonResponse;
import com.saveetha.e_book.response.admin.GetSingleBookResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDetailsActivity extends AppCompatActivity {

    ActivityBookDetailsBinding binding;
    private String book_name, book_image, book_description, book_id, book_author, book_price, book_publisher_id, book_publisher_name, book_submit_date, book_year, book_approval_status, book_approval_date, book_cancelled_msg, book_demo_book, book_pdf, book_cover_image, book_title;
    private int user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBookDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String userId = SF.getSignInSFValue(this).get(Constant.ID_SI_SF);
        if (userId != null) {
            this.user_id = Integer.parseInt(userId);
        } else {
            Toast.makeText(this, "Error in getting user id", Toast.LENGTH_SHORT).show();
        }

        if (getIntent() != null) {

            book_name = getIntent().getStringExtra("book_name");
            book_image = getIntent().getStringExtra("book_image");
            book_description = getIntent().getStringExtra("book_description");
            book_id = getIntent().getStringExtra("book_id");
            book_author = getIntent().getStringExtra("book_author");
            book_price = getIntent().getStringExtra("book_price");
            book_publisher_id = getIntent().getStringExtra("book_publisher_id");
            book_publisher_name = getIntent().getStringExtra("book_publisher_name");
            book_submit_date = getIntent().getStringExtra("book_submit_date");
            book_year = getIntent().getStringExtra("book_year");
            book_approval_status = getIntent().getStringExtra("book_approval_status");
            book_approval_date = getIntent().getStringExtra("book_approval_date");
            book_cancelled_msg = getIntent().getStringExtra("book_cancelled_msg");
            book_demo_book = getIntent().getStringExtra("book_demo_book");
            book_pdf = getIntent().getStringExtra("book_pdf");
            book_cover_image = getIntent().getStringExtra("book_cover_image");
            book_title = getIntent().getStringExtra("book_title");
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

        binding.backCV.setOnClickListener(v->{
            finish();
        });

        binding.saveBookCV.setOnClickListener(v->{
            saveBook();
        });
    }

    private void saveBook() {

        Call<CommonResponse> res = RestClient.makeAPI().saveBook(Integer.parseInt(book_id),user_id);

        res.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                if(response.isSuccessful()){
                    if(response.body().getStatus() == 200){
                        Toast.makeText(BookDetailsActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(BookDetailsActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(BookDetailsActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                Toast.makeText(BookDetailsActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void loadBookDetails() {
//
        Call<GetSingleBookResponse> call = RestClient.makeAPI().getUserSingleBook(Integer.parseInt(book_id),user_id);
        call.enqueue(new Callback<GetSingleBookResponse>() {
            @Override
            public void onResponse(Call<GetSingleBookResponse> call, Response<GetSingleBookResponse> response) {

                if(response.isSuccessful()){
                    if(response.body().getStatus() == 200){
                        GetSingleBookResponse getSingleBookResponse = response.body();
                        if(getSingleBookResponse != null){
                            binding.bookNameTV.setText(getSingleBookResponse.getData().getBook_title());
                            binding.autherNameTV.setText(getSingleBookResponse.getData().getAuther_name());
                            binding.bookDescription.setText(getSingleBookResponse.getData().getBook_description());
                            binding.bookPriceTV.setText(getSingleBookResponse.getData().getPrice());
                            Glide.with(BookDetailsActivity.this)
                                    .load(getSingleBookResponse.getData().getBook_cover_image())
                                    .placeholder(R.drawable.book_icon)
                                    .error(R.drawable.book_icon)
                                    .into(binding.imageBookSIV);
                            if(getSingleBookResponse.getData().isPayment_status() == true){
                                binding.buyReadBTN.setText("Read");
                                binding.readDemoBTN.setVisibility(View.GONE);
                            }

                            binding.buyReadBTN.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(getSingleBookResponse.getData().isPayment_status() == true){
                                        //TODO
                                        // redirect to read book
                                    } else {
                                        //TODO
                                        // redirect To Buy book Payment
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(BookDetailsActivity.this, "Error in getting book details", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(BookDetailsActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<GetSingleBookResponse> call, Throwable t) {
                Toast.makeText(BookDetailsActivity.this, "Error in getting book details", Toast.LENGTH_SHORT).show();
            }
        });
    }


}