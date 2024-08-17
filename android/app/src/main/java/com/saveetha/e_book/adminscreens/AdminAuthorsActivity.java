package com.saveetha.e_book.adminscreens;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.saveetha.e_book.R;
import com.saveetha.e_book.adminscreens.adminadapters.AdminAuthorsAdapter;
import com.saveetha.e_book.adminscreens.adminmodules.AdminAuthorsModule;
import com.saveetha.e_book.databinding.ActivityAdminAuthorsBinding;

import java.util.ArrayList;

public class AdminAuthorsActivity extends AppCompatActivity {

    ActivityAdminAuthorsBinding binding;
    ArrayList<AdminAuthorsModule> authors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityAdminAuthorsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        loadAuthors();

    }

    private void loadAuthors() {

        authors.add(new AdminAuthorsModule("Author 1","v@gmail.com","1234567890","https://imgs.search.brave.com/iWnCT3lR5iw046Q5mH0h4GoxTmSX4Zv0Bz7zgKuALfk/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly90NC5m/dGNkbi5uZXQvanBn/LzA4LzI4LzU2LzA1/LzM2MF9GXzgyODU2/MDU1Nl9oZmdqczE2/VURONFZGSmNSVERq/S1N4cnNxSHQzQVdz/My5qcGc"));
        authors.add(new AdminAuthorsModule("Author 2","v@gmail.com","1234567890","https://imgs.search.brave.com/iWnCT3lR5iw046Q5mH0h4GoxTmSX4Zv0Bz7zgKuALfk/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly90NC5m/dGNkbi5uZXQvanBn/LzA4LzI4LzU2LzA1/LzM2MF9GXzgyODU2/MDU1Nl9oZmdqczE2/VURONFZGSmNSVERq/S1N4cnNxSHQzQVdz/My5qcGc"));
        authors.add(new AdminAuthorsModule("Author 3","v@gmail.com","1234567890","https://imgs.search.brave.com/iWnCT3lR5iw046Q5mH0h4GoxTmSX4Zv0Bz7zgKuALfk/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly90NC5m/dGNkbi5uZXQvanBn/LzA4LzI4LzU2LzA1/LzM2MF9GXzgyODU2/MDU1Nl9oZmdqczE2/VURONFZGSmNSVERq/S1N4cnNxSHQzQVdz/My5qcGc"));
        authors.add(new AdminAuthorsModule("Author 4","v@gmail.com","1234567890","https://imgs.search.brave.com/iWnCT3lR5iw046Q5mH0h4GoxTmSX4Zv0Bz7zgKuALfk/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly90NC5m/dGNkbi5uZXQvanBn/LzA4LzI4LzU2LzA1/LzM2MF9GXzgyODU2/MDU1Nl9oZmdqczE2/VURONFZGSmNSVERq/S1N4cnNxSHQzQVdz/My5qcGc"));

        AdminAuthorsAdapter adapter = new AdminAuthorsAdapter(authors,this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }
}