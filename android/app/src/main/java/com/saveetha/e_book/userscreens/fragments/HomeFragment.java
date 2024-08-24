package com.saveetha.e_book.userscreens.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.saveetha.e_book.RestClient;
import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.GetCategoryResponse;
import com.saveetha.e_book.response.SignInResponse;
import com.saveetha.e_book.response.admin.GetBooksResponse;
import com.saveetha.e_book.userscreens.BooksListActivity;
import com.saveetha.e_book.databinding.FragmentHomeBinding;
import com.saveetha.e_book.userscreens.adapters.CategoryListAdapter;
import com.saveetha.e_book.userscreens.dataclass.CategoryModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<CategoryModel> categories;
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        binding.allBooksTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), BooksListActivity.class);
                intent.putExtra("CATEGORY_TYPE","ALL");
                startActivity(intent);
            }
        });

        try {

            context = requireContext();

        }catch (Exception e){
            e.printStackTrace();
        }

        loadHome();
        return binding.getRoot();
    }

    private void loadHome() {

        categories= new ArrayList<>();

        Call<GetCategoryResponse> responseCall = RestClient.makeAPI().getCategories();
        responseCall.enqueue(new Callback<GetCategoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetCategoryResponse> call, @NonNull Response<GetCategoryResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus().equals("200")) {
                        ArrayList<GetCategoryResponse.data> item = response.body().getData();
                        if(item.size()>0){
                            for(GetCategoryResponse.data data : item){
                                categories.add(new CategoryModel(data.getCategory_name(),data.getCategory_image()));
                            }
                            CategoryListAdapter categoryAdapter = new CategoryListAdapter(context, categories);
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL,false);
                            binding.categoryRV.setLayoutManager(gridLayoutManager);
                            binding.categoryRV.setAdapter(categoryAdapter);
                        } else {
                            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetCategoryResponse> call, @NonNull Throwable t) {
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getMessage());
            }
        });


    }
}