package com.saveetha.e_book;

import com.saveetha.e_book.request.ApproveBookRequest;
import com.saveetha.e_book.request.SignUpRequest;
import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.CommonResponse;
import com.saveetha.e_book.response.SignInResponse;
import com.saveetha.e_book.response.admin.GetAllReviewResponse;
import com.saveetha.e_book.response.admin.GetBooksResponse;
import com.saveetha.e_book.response.admin.GetPublisherResponse;
import com.saveetha.e_book.response.admin.GetPurchesedBooksResponse;
import com.saveetha.e_book.response.admin.GetSingleBookResponse;

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

    @POST("/admin/approve_book")
    Call<CommonResponse> approveBook(@Body ApproveBookRequest request);

    @POST("/admin/cancel_book")
    Call<CommonResponse> rejectBook(@Body ApproveBookRequest.RejectBookRequest request);

    @POST("/admin/get_all_review")
    Call<GetAllReviewResponse> getAllReview();

    @POST("/admin/get_all_purchesed_books")
    Call<GetPurchesedBooksResponse> getPurchasedBooks();

    @POST("/admin/get_publisher")
    Call<GetPublisherResponse> getPublisher();


}
