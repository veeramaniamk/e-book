package com.saveetha.e_book.adminscreens;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.R;
import com.saveetha.e_book.RestClient;
import com.saveetha.e_book.StaticMethods;
import com.saveetha.e_book.databinding.ActivityAdminBookDetailsBinding;
import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.SignInResponse;
import com.saveetha.e_book.response.admin.GetBooksData;
import com.saveetha.e_book.response.admin.GetSingleBookData;
import com.saveetha.e_book.response.admin.GetSingleBookResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminBookDetailsActivity extends AppCompatActivity {

    ActivityAdminBookDetailsBinding binding;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityAdminBookDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onClickListener();
        int bookId = getIntent().getIntExtra("bookId",0);
        String status = getIntent().getStringExtra("status");
//        Toast.makeText(context, ""+bookId, Toast.LENGTH_SHORT).show();
        if(!status.equalsIgnoreCase("NEW")) {
            binding.buttonLayout.setVisibility(View.GONE);
        } else {
            binding.buttonLayout.setVisibility(View.VISIBLE);
        }
        apiCall(bookId);
        context = this;
    }

    void onClickListener(){
        binding.backCard.setOnClickListener(v -> finish());

    }
    private void apiCall(int bookId) {
        Call<GetSingleBookResponse> responseCall = RestClient.makeAPI().getSingleBook(bookId);
        responseCall.enqueue(new Callback<GetSingleBookResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetSingleBookResponse> call, @NonNull Response<GetSingleBookResponse> response) {
                if(response.isSuccessful()) {
                    GetSingleBookResponse data = response.body();
                    GetSingleBookData data1 = data.getData();
                    if(data1==null){
                        Toast.makeText(context, ""+data.getMessage(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(response.body().getStatus() == 200) {
                        StaticMethods.setGlide(AdminBookDetailsActivity.this, binding.imageBook, data1.getBookCoverImage());
                        binding.bookName.setText(data1.getBook_title());
                        binding.autherName.setText(data1.getAutherName());
                        binding.bookDescription.setText(data1.getBookDescription());
                        Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, ""+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetSingleBookResponse> call, @NonNull Throwable t) {
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getMessage());
            }
        });

    }
}