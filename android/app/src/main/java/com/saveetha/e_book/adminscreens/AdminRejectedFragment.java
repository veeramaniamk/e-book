package com.saveetha.e_book.adminscreens;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saveetha.e_book.R;
import com.saveetha.e_book.adminscreens.adminadapters.AdminHomeBooksAdapter;
import com.saveetha.e_book.adminscreens.adminmodules.AdminBooksModule;
import com.saveetha.e_book.databinding.FragmentAdminHomeBinding;
import com.saveetha.e_book.databinding.FragmentAdminRejectedBinding;

import java.util.ArrayList;
import java.util.List;

public class AdminRejectedFragment extends Fragment {


    FragmentAdminRejectedBinding binding;
    List<AdminBooksModule> adminBooksModuleList;

    FragmentActivity activity;
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAdminRejectedBinding.inflate(getLayoutInflater());

        try {
            activity = getActivity();
            context = getContext();

        }catch (Exception e){
            e.printStackTrace();
        }

        loadRejectedBooks();

        return binding.getRoot();
    }

    private void loadRejectedBooks() {
        adminBooksModuleList = new ArrayList<>();

        adminBooksModuleList.add(new AdminBooksModule("Anesthesia","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text."));
        adminBooksModuleList.add(new AdminBooksModule("pharmacist","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text."));
        adminBooksModuleList.add(new AdminBooksModule("Pharmaceutics","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text."));
        adminBooksModuleList.add(new AdminBooksModule("Anesthesia","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text."));

        AdminHomeBooksAdapter adminHomeBooksAdapter = new AdminHomeBooksAdapter(adminBooksModuleList,context);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerView.setAdapter(adminHomeBooksAdapter);
    }
}