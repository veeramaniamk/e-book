package com.saveetha.e_book.openingscreens;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.R;
import com.saveetha.e_book.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    String name, email, password, confirmPassword, phoneNumber, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.signInBtn.setOnClickListener(v -> {
            finish();
            signup();
        });





    }

    private void signup() {
        if(validatesignup()){
//            signUpUser();
        }
    }

    private boolean validatesignup() {
        boolean isValid = true;

        name = binding.nameET.getText().toString();
        email = binding.emailET.getText().toString();
        password = binding.passwordET.getText().toString();
        confirmPassword = binding.confirmPasswordET.getText().toString();
        phoneNumber = binding.phoneET.getText().toString();
        gender = binding.genderET.getText().toString();

        if(name.isEmpty()){
            binding.nameET.setError("Please enter your name");
            isValid = false;
        }

        if(email.isEmpty()){
            binding.emailET.setError("Please enter your email");
            isValid = false;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailET.setError("Invalid email");
            isValid = false;
        }
        if(password.isEmpty()){
            binding.passwordET.setError("Please enter your password");
            isValid = false;
        }

        if(confirmPassword.isEmpty()){
            binding.confirmPasswordET.setError("Please enter confirm your password");
            isValid = false;
        }

        if(phoneNumber.isEmpty()){
            binding.phoneET.setError("Please enter your phone number");
            isValid = false;
        }

        if(gender.isEmpty()){
            binding.genderET.setError("Please enter your gender");
            isValid = false;
        }

        if(!password.equals(confirmPassword)){
            binding.confirmPasswordET.setError("Password does not match");
            isValid = false;
        }

        return isValid;
    }
}