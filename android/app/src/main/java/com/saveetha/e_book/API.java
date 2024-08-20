package com.saveetha.e_book;

import com.saveetha.e_book.request.SignUpRequest;
import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.CommonResponse;
import com.saveetha.e_book.response.SignInResponse;
import com.saveetha.e_book.response.admin.GetBooksResponse;
import com.saveetha.e_book.response.admin.GetSingleBookResponse;
import com.saveetha.e_book.reviewerscrees.reviewerapi.request.AddBook;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {

    @POST("/user/signin")
    Call<SignInResponse> signIn(@Body Signin request);


    @POST("/user/signup")
    Call<CommonResponse> signUp(@Body SignUpRequest request);


    @POST("/admin/get_books")
    Call<GetBooksResponse> getBooksAdminHomePage(@Query("book_approval") String book_approval);

    @POST("/admin/get_single_book")
    Call<GetSingleBookResponse> getSingleBook(@Query("book_id") int book_id);

    @POST("/publisher/add_books")
    Call<CommonResponse> addBook(@Body AddBook request);


}
