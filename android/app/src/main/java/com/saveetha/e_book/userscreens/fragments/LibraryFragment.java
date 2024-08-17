package com.saveetha.e_book.userscreens.fragments;

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

        return binding.getRoot();
    }
}