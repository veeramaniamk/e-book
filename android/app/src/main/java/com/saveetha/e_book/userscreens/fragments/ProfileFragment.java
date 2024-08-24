package com.saveetha.e_book.userscreens.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.saveetha.e_book.Constant;
import com.saveetha.e_book.R;
import com.saveetha.e_book.SF;
import com.saveetha.e_book.StaticMethods;
import com.saveetha.e_book.databinding.FragmentProfileBinding;
import com.saveetha.e_book.openingscreens.SignInActivity;
import com.saveetha.e_book.userscreens.ChangePasswordActivity;
import com.saveetha.e_book.userscreens.UpdateUserActivity;

import java.util.Map;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    Context context;
    FragmentActivity activity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater());

        try {
            context =  requireContext();
            activity = requireActivity();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        binding.changePasswordBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        binding.updateProfileBTN.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), UpdateUserActivity.class);
            startActivity(intent);
        });

        setProfileInfo();

        binding.logoutIV.setOnClickListener(v -> {
            SharedPreferences sf = SF.getSignInSF(activity);
            sf.edit().clear().apply();
            startActivity(new Intent(requireContext(), SignInActivity.class));
            requireActivity().finish();
        });

        binding.profileSIV.setOnClickListener(v -> {
            
        });

        return binding.getRoot();
    }

    private void setProfileInfo(){

        Map<String, String> key = SF.getSignInSFValue(activity);
        binding.userNameET.setText(key.get(Constant.NAME_SI_SF));
        binding.emailET.setText(key.get(Constant.EMAIL_SI_SF));
        binding.phoneET.setText(key.get(Constant.PHONE_SI_SF));
        StaticMethods.setGlide(activity,binding.profileSIV,key.get(Constant.PROFILE_SI_SF));
        binding.genderS.setText(key.get(Constant.GENDER_SI_SF));

    }
}