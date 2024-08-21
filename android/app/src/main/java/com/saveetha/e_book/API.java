package com.saveetha.e_book;

import com.saveetha.e_book.request.SignUpRequest;
import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.CommonResponse;
import com.saveetha.e_book.response.GetCategoryResponse;
import com.saveetha.e_book.response.SignInResponse;
import com.saveetha.e_book.response.admin.GetBooksResponse;
import com.saveetha.e_book.response.admin.GetSingleBookResponse;
import com.saveetha.e_book.reviewerscrees.reviewerapi.request.AddBook;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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


    @Multipart
    @POST("/publisher/add_books")
    Call<CommonResponse> addBook(@Part("publisher_id") RequestBody publisher_id,
                                 @Part("publisher_name") RequestBody publisher_name, @Part("book_titile") RequestBody book_titile, @Part("book_description") RequestBody book_description, @Part("auther_name") RequestBody auther_name,
                                 @Part("year_of_the_book") RequestBody year_of_the_book, @Part("category_name") RequestBody category_name, @Part("book_price") RequestBody book_price,
                                 @Part MultipartBody.Part cover_image, @Part MultipartBody.Part book, @Part MultipartBody.Part demo_file);


    @POST("/publisher/get_category")
    Call<GetCategoryResponse> getAllCategory();




}
