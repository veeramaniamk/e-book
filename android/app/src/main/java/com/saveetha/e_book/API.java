package com.saveetha.e_book;

import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.CommonResponse;
import com.saveetha.e_book.response.SignInResponse;
import com.saveetha.e_book.reviewerscrees.reviewerapi.request.AddBook;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

    @POST("/user/signin")
    Call<SignInResponse> signIn(@Body Signin request);

    @POST("/publisher/add_books")
    Call<CommonResponse> addBook(@Body AddBook request);


}
