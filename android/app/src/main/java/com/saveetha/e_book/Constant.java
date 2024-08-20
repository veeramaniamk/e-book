package com.saveetha.e_book;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.SignInResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface Constant {
    String BASE_URL = "https://3a27-180-235-121-242.ngrok-free.app/";

    String SIGN_IN_SF = "SF_SI";
    String NAME_SI_SF = "SF_NAME_SI";
    String ID_SI_SF = "SF_ID_SI";
    String EMAIL_SI_SF = "SF_EMAIL_SI";
    String PHONE_SI_SF = "SF_PHONE_SI";
    String USER_TYPE_SI_SF = "SF_USER_TYPE_SI";
    String GENDER_SI_SF = "SF_GENDER_SI";
    String PROFILE_SI_SF = "SF_PROFILE_SI";

}

class a {
    private void apiCall() {
        final Context context = null;
        Call<SignInResponse> responseCall = RestClient.makeAPI().signIn(new Signin());
        responseCall.enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(@NonNull Call<SignInResponse> call, @NonNull Response<SignInResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus() ==200) {
                        Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, ""+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<SignInResponse> call, @NonNull Throwable t) {
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getMessage());
            }
        });
    }


}
