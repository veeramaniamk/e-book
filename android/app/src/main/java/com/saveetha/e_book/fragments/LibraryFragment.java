package com.saveetha.e_book.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saveetha.e_book.R;
import com.saveetha.e_book.databinding.FragmentLibraryBinding;

public class LibraryFragment extends Fragment {

    FragmentLibraryBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLibraryBinding.inflate(getLayoutInflater());

        binding.savedTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(requireContext(), BooksListActivity.class);
//                startActivity(intent);
            }
        });

        binding.finishedTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(requireContext(), BooksListActivity.class);
//                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}