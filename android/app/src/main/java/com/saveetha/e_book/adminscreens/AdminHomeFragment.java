package com.saveetha.e_book.adminscreens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayoutMediator;
import com.saveetha.e_book.R;
import com.saveetha.e_book.databinding.FragmentAdminHomeBinding;


public class AdminHomeFragment extends Fragment {

    FragmentAdminHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAdminHomeBinding.inflate(inflater, container, false);

        setUpTab();

        return binding.getRoot();
    }

    private void setUpTab() {

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {

            View view = getLayoutInflater().inflate(R.layout.tab_custom, null);
            TextView tabText = view.findViewById(R.id.tabText);

            switch (position) {
                case 0:
                    tabText.setText("New");
                    break;
                case 1:
                    tabText.setText("Approved");
                    break;
                case 2:
                    tabText.setText("Rejected");
                    break;
            }

            tab.setCustomView(view);

        }).attach();

    }
}