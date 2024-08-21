package com.saveetha.e_book.userscreens.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saveetha.e_book.Constant;
import com.saveetha.e_book.R;
import com.saveetha.e_book.databinding.FragmentProfileBinding;
import com.saveetha.e_book.openingscreens.SignInActivity;
import com.saveetha.e_book.userscreens.ChangePasswordActivity;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater());

        binding.changePasswordBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        binding.logoutIV.setOnClickListener(v -> {
            SharedPreferences sf = requireActivity().getSharedPreferences(Constant.SIGN_IN_SF, Context.MODE_PRIVATE);
            sf.edit().clear().apply();
            startActivity(new Intent(requireContext(), SignInActivity.class));
            requireActivity().finish();
        });

        return binding.getRoot();
    }
}