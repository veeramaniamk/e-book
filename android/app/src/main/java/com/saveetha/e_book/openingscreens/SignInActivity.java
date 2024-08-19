package com.saveetha.e_book.openingscreens;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.R;
import com.saveetha.e_book.adminscreens.AdminDashboardActivity;
import com.saveetha.e_book.databinding.ActivitySignInBinding;
import com.saveetha.e_book.reviewerscrees.ReviewerDashboardActivity;

public class SignInActivity extends AppCompatActivity {

    ActivitySignInBinding binding;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signInBtn.setOnClickListener(v -> {
            if(validateuser()) {
                startActivity(new Intent(this, AdminDashboardActivity.class));
                finish();
            }
        });

        binding.registerTV.setOnClickListener(v -> {
            startActivity(new Intent(this, SignUpActivity.class));
        });

    }

    private void apiCall(String email, String password) {

    }

    private boolean validateuser() {
        boolean isValid = true;

        email = binding.emailET.getText().toString();
        password = binding.passwordET.getText().toString();

        if(email.isEmpty()){
            binding.emailET.setError("Email is required");
            isValid = false;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailET.setError("Invalid email");
            isValid = false;
        }
        if(password.isEmpty()){
            binding.passwordET.setError("Password is required");
            isValid = false;
        }
        return isValid;
    }
}