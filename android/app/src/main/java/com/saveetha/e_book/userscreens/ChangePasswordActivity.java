package com.saveetha.e_book.userscreens;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

<<<<<<<< HEAD:android/app/src/main/java/com/saveetha/e_book/ChangePasswordActivity.java
import com.saveetha.e_book.databinding.ActivityChangePasswordBinding;

public class ChangePasswordActivity extends AppCompatActivity {
========
import com.saveetha.e_book.R;

public class AdminBookDetailsActivity extends AppCompatActivity {
>>>>>>>> 3a18e90e676b91d53666b34132c6e0bd871a7f5a:android/app/src/main/java/com/saveetha/e_book/adminscreens/AdminBookDetailsActivity.java

    ActivityChangePasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<<< HEAD:android/app/src/main/java/com/saveetha/e_book/ChangePasswordActivity.java
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
========
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_book_details);

>>>>>>>> 3a18e90e676b91d53666b34132c6e0bd871a7f5a:android/app/src/main/java/com/saveetha/e_book/adminscreens/AdminBookDetailsActivity.java
    }
}