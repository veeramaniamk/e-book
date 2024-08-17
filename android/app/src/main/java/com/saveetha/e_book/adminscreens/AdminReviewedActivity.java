package com.saveetha.e_book.adminscreens;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.saveetha.e_book.R;
import com.saveetha.e_book.adminscreens.adminadapters.AdminManageBooksAdapter;
import com.saveetha.e_book.adminscreens.adminmodules.AdminBooksModule;
import com.saveetha.e_book.databinding.ActivityAdminReviewedBinding;

import java.util.ArrayList;

public class AdminReviewedActivity extends AppCompatActivity {

    ActivityAdminReviewedBinding binding;
    ArrayList<AdminBooksModule> adminBooksModuleList;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityAdminReviewedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadReviewedBooks();

    }

    private void loadReviewedBooks() {
        adminBooksModuleList = new ArrayList<>();

        adminBooksModuleList.add(new AdminBooksModule("Anesthesia","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text.","200"));
        adminBooksModuleList.add(new AdminBooksModule("pharmacist","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text.","400"));
        adminBooksModuleList.add(new AdminBooksModule("Pharmaceutics","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text.","600"));
        adminBooksModuleList.add(new AdminBooksModule("Anesthesia","https://imgs.search.brave.com/C9Ux4Cy7nVBYvAG10ljDU-DRtkCdEJP-peea-8KXB3g/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzlkL2Rh/L2M3LzlkZGFjNzRl/MDhkMTU1MWYwNTNi/ZDBjNzI1YjQwNzFj/LmpwZw","This text serves as a placeholder, offering a glimpse of content in design layouts. It helps visualize the arrangement and appearance of text elements within a project. While the words may be generic, the structure and format reflect how actual content will look. Use this sample to fine-tune spacing, alignment, and overall visual impact before finalizing the real text.","4000"));

        AdminManageBooksAdapter adapter = new AdminManageBooksAdapter(adminBooksModuleList,context);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerView.setAdapter(adapter);
    }
}