package com.saveetha.e_book.adminscreens;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.R;
import com.saveetha.e_book.RestClient;
import com.saveetha.e_book.StaticMethods;
import com.saveetha.e_book.databinding.ActivityAdminBookDetailsBinding;
import com.saveetha.e_book.databinding.RejectBookDialogBinding;
import com.saveetha.e_book.request.ApproveBookRequest;
import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.CommonResponse;
import com.saveetha.e_book.response.SignInResponse;
import com.saveetha.e_book.response.admin.GetBooksData;
import com.saveetha.e_book.response.admin.GetSingleBookData;
import com.saveetha.e_book.response.admin.GetSingleBookResponse;

import java.util.Objects;

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
        if(status!=null) {
            if (status.equalsIgnoreCase("CANCELLED")) {
                binding.Reason.setVisibility(View.VISIBLE);
                binding.rejectedMessage.setVisibility(View.VISIBLE);
            } else {
                binding.Reason.setVisibility(View.INVISIBLE);
                binding.rejectedMessage.setVisibility(View.INVISIBLE);
            }
            if (!status.equalsIgnoreCase("NEW")) {
                binding.buttonLayout.setVisibility(View.GONE);
            } else {
                binding.buttonLayout.setVisibility(View.VISIBLE);
            }
        } else {
            binding.buttonLayout.setVisibility(View.GONE);
        }
        apiCall(bookId);
        try{
            context = this;
        } catch (Exception e){
            e.printStackTrace();
        }
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
                        StaticMethods.setGlide(AdminBookDetailsActivity.this, binding.imageBook, data1.getBook_cover_image());
                        binding.bookName.setText("Book Name : "+data1.getBook_title());
                        binding.autherName.setText("Auther Name : "+data1.getAuther_name());
                        binding.bookDescription.setText(data1.getBook_description());
                        if(data1.getBook_cancelled_msg()!=null){
                            binding.rejectedMessage.setText(data1.getBook_cancelled_msg());
                        }
                        binding.approveButton.setOnClickListener(v -> bookApprovalApiCall(data1.getBook_id(),data1.getPublisher_id()));
                        binding.rejectButton.setOnClickListener(v -> bookRejectApiCall(data1.getBook_id(),data1.getPublisher_id()));

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

    private void bookRejectApiCall(int bookId, int publisherId) {
        Dialog dialog = new Dialog(context);
        RejectBookDialogBinding binding = RejectBookDialogBinding.inflate(dialog.getLayoutInflater());
        dialog.setContentView(binding.getRoot());
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
        binding.cancelButton.setOnClickListener(view ->  dialog.dismiss());
        binding.rejectButton.setOnClickListener(view -> {
            String msg = binding.textMessage.getText().toString();
            ApproveBookRequest.RejectBookRequest request  = new ApproveBookRequest.RejectBookRequest(bookId,publisherId,msg);
            if(msg.isEmpty()) {
                Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();
                return;
            }
            Call<CommonResponse> responseCall = RestClient.makeAPI().rejectBook(request);
            responseCall.enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(@NonNull Call<CommonResponse> call, @NonNull Response<CommonResponse> response) {
                    dialog.dismiss();
                    if(response.isSuccessful()) {
                        if(response.body().getStatus() ==200) {
                            Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<CommonResponse> call, @NonNull Throwable t) {
                    dialog.dismiss();
                    Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Error", t.getMessage());
                }
            });
        });
    }

    private void bookApprovalApiCall(int bookId, int publisherId) {
        ApproveBookRequest request  = new ApproveBookRequest(bookId,publisherId);
        Call<CommonResponse> responseCall = RestClient.makeAPI().approveBook(request);
        responseCall.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(@NonNull Call<CommonResponse> call, @NonNull Response<CommonResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus() ==200) {
                        Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CommonResponse> call, @NonNull Throwable t) {
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getMessage());
            }
        });
    }
}