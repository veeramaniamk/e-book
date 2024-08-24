package com.saveetha.e_book;

import com.saveetha.e_book.request.ApproveBookRequest;
import com.saveetha.e_book.request.ApproveBookRequest;
import com.saveetha.e_book.request.Request;
import com.saveetha.e_book.request.SignUpRequest;
import com.saveetha.e_book.request.Signin;
import com.saveetha.e_book.response.CommonResponse;
import com.saveetha.e_book.response.GetCategoryResponse;
import com.saveetha.e_book.response.SignInResponse;
import com.saveetha.e_book.response.admin.GetAllReviewResponse;
import com.saveetha.e_book.response.admin.GetBooksResponse;
import com.saveetha.e_book.response.admin.GetPublisherResponse;
import com.saveetha.e_book.response.admin.GetPurchesedBooksResponse;
import com.saveetha.e_book.response.admin.GetPublisherBookResponse;
import com.saveetha.e_book.response.admin.GetPublisherResponse;
import com.saveetha.e_book.response.admin.GetPurchesedBooksResponse;
import com.saveetha.e_book.response.admin.GetSingleBookResponse;
import com.saveetha.e_book.reviewerscrees.reviewerapi.request.AddBook;
import com.saveetha.e_book.reviewerscrees.reviewerapi.request.RequestGetBook;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @POST("/publisher/get_book")
    Call<GetPublisherBookResponse> getPublisherBook(@Body Request.GetPublisherBook request);

    @Multipart
    @POST("/publisher/add_books")
    Call<CommonResponse> addBook(@Part("publisher_id") RequestBody publisher_id,
                                 @Part("publisher_name") RequestBody publisher_name, @Part("book_titile") RequestBody book_titile, @Part("book_description") RequestBody book_description, @Part("auther_name") RequestBody auther_name,
                                 @Part("year_of_the_book") RequestBody year_of_the_book, @Part("category_name") RequestBody category_name, @Part("book_price") RequestBody book_price,
                                 @Part MultipartBody.Part cover_image, @Part MultipartBody.Part book, @Part MultipartBody.Part demo_file);


    @POST("/publisher/get_category")
    Call<GetCategoryResponse> getAllCategory();

    @Multipart
    @POST("/publisher/add_category")
    Call<CommonResponse> addCategory(@Part("category_name") RequestBody category_name, @Part MultipartBody.Part category_image);

    @POST("/publisher/get_book")
    Call<GetBooksResponse> getReviewerBooks(@Body RequestGetBook request);

    @POST("/publisher/get_category")
    Call<GetCategoryResponse> getCategories();

    @POST("/user/get_books")
    Call<GetBooksResponse> getBooksByCategories(@Query("category_name") String category_name);

    @POST("user/update_user_info")
    Call<CommonResponse> updateUserInfo(@Body Request.UpdateProfile request);

    @POST("user/change_password")
    Call<CommonResponse> changePassword(@Body Request.ChangePassword request);

    @Multipart
    @POST("user/update_profile_image")
    Call<CommonResponse> updateUserProfile(@Part("user_id") String userId, @Part MultipartBody.Part profile);





}
