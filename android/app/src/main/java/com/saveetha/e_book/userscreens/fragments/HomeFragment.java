package com.saveetha.e_book.userscreens.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saveetha.e_book.userscreens.BooksListActivity;
import com.saveetha.e_book.userscreens.adapters.CategoryListAdapter;
import com.saveetha.e_book.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        binding.allTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), BooksListActivity.class);
                intent.putExtra("CATEGORY_TYPE","ALL");
                startActivity(intent);
            }
        });

//        CategoryListAdapter adapter = new CategoryListAdapter(this, categories);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL,false);
//        binding.categoryRV.setLayoutManager(gridLayoutManager);
//        binding.categoryRV.setAdapter(adapter);

        return binding.getRoot();
    }
}