package com.saveetha.e_book.reviewerscrees;

import android.os.Bundle;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.saveetha.e_book.databinding.FragmentReviewerHomeBinding;
import com.saveetha.e_book.reviewerscrees.revieweradapter.ReviewerHomeBooksAdapter;
import com.saveetha.e_book.reviewerscrees.reviewermodules.ReviewerBooksModule;

import java.util.ArrayList;


public class ReviewerHomeFragment extends Fragment {

    FragmentReviewerHomeBinding binding;
    private ArrayList<ReviewerBooksModule> list;
    FragmentActivity activity;
    Context context;
    private String chipText;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentReviewerHomeBinding.inflate(inflater, container, false);

        try {
            activity = getActivity();
            context = getContext();
        }catch (Exception e){
            e.printStackTrace();
        }

        onChipListener();

        loadReviewerHome();

        return binding.getRoot();

    }

    private void onChipListener() {

        binding.chipGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId != -1) {
                Chip selectedChip = binding.chipGroup.findViewById(checkedId);
                chipText = selectedChip.getText().toString();
                Toast.makeText(context, "Selected Chip: " + chipText, Toast.LENGTH_SHORT).show();
            } else {
                chipText = "ALL";
                // No chip is selected
                // but i checked All default
            }


        });

    }


    private void loadReviewerHome() {

        list = new ArrayList<>();

        list.add(new ReviewerBooksModule("Anesthesia","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text."));
        list.add(new ReviewerBooksModule("pharmacist","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text."));
        list.add(new ReviewerBooksModule("Pharmaceutics","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text."));
        list.add(new ReviewerBooksModule("Anesthesia","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text."));

        ReviewerHomeBooksAdapter adapter = new ReviewerHomeBooksAdapter(list,context);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerView.setAdapter(adapter);

    }
}