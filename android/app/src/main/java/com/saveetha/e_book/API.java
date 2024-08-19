package com.saveetha.e_book;

import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.SignInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

    @POST("/user/signin")
    Call<SignInResponse> signIn(@Body Signin request);


}
