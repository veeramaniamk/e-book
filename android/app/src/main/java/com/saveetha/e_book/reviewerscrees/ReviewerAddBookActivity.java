package com.saveetha.e_book.reviewerscrees;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.saveetha.e_book.Constant;
import com.saveetha.e_book.RestClient;
import com.saveetha.e_book.SF;
import com.saveetha.e_book.databinding.ActivityReviewerAddBookBinding;
import com.saveetha.e_book.response.CommonResponse;
import com.saveetha.e_book.response.GetCategoryResponse;
import com.saveetha.e_book.utils.UriToFile;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewerAddBookActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    ActivityReviewerAddBookBinding binding;

    private String uploadImageET, titleET, uploadPDFET, authorET, publisherET, yearET, category, priceET;
    private String publisher_id, publisher_name, description;

    private RequestBody publisher_id_req, title_req, upload_pdf_req, author_req, publisher_name_req, year_req, category_req, price_req, description_req;
    private MultipartBody.Part image_req, pdf_req, demo_req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityReviewerAddBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sf = SF.getSignInSF(this);
        publisher_id = sf.getString(Constant.ID_SI_SF, null);
        publisher_name = sf.getString(Constant.NAME_SI_SF, null);
        onClick();
        loadSpinner();

    }

    private void loadSpinner() {
        Call<GetCategoryResponse> res = RestClient.makeAPI().getAllCategory();

        res.enqueue(new Callback<GetCategoryResponse>() {
            @Override
            public void onResponse(Call<GetCategoryResponse> call, Response<GetCategoryResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("200")) {
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            GetCategoryResponse.data item = response.body().getData().get(i);
                            String str[] = new String[response.body().getData().size()];
                            str[i] = item.getCategory_name();
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(ReviewerAddBookActivity.this, android.R.layout.simple_spinner_dropdown_item, str);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            binding.category.setAdapter(adapter);
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<GetCategoryResponse> call, Throwable t) {

                Toast.makeText(ReviewerAddBookActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onClick() {

        binding.addBookBtn.setOnClickListener(v -> {
            if (validateData()) {

                if (changetexttoparts()) {
                    Call<CommonResponse> res = RestClient.makeAPI().addBook(publisher_id_req, publisher_name_req, title_req
                            , description_req, author_req, year_req, category_req, price_req, image_req, pdf_req, demo_req);

                    res.enqueue(new Callback<CommonResponse>() {
                        @Override
                        public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getStatus() == 200) {

                                    Toast.makeText(ReviewerAddBookActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            } else if (response.errorBody() != null) {

                                try {
                                    Toast.makeText(ReviewerAddBookActivity.this, "" + response.errorBody().string(), Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<CommonResponse> call, Throwable t) {

                            Toast.makeText(ReviewerAddBookActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }
        });

        binding.uploadImageET.setOnClickListener(v -> {

            Intent intent = new Intent();
            intent.setType("*/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
           pickImageLauncher.launch(Intent.createChooser(intent, "Select Picture"));

        });



        binding.uploadPDFET.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(intent.CATEGORY_OPENABLE);
            intent.setAction(Intent.ACTION_GET_CONTENT);
            pickPDFLauncher.launch(Intent.createChooser(intent, "Select Picture"));

        });

        binding.uploadDemoPDF.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(intent.CATEGORY_OPENABLE);
            intent.setAction(Intent.ACTION_GET_CONTENT);
            pickDemoPDFLauncher.launch(Intent.createChooser(intent, "Select Picture"));
        });


    }

    private boolean changetexttoparts() {

        publisher_id_req = RequestBody.create(MultipartBody.FORM, publisher_id);
        publisher_name_req = RequestBody.create(MultipartBody.FORM, publisher_name);
        title_req = RequestBody.create(MultipartBody.FORM, titleET);
        description_req = RequestBody.create(MultipartBody.FORM, description);
        author_req = RequestBody.create(MultipartBody.FORM, authorET);
        year_req = RequestBody.create(MultipartBody.FORM, yearET);
        category_req = RequestBody.create(MultipartBody.FORM, category);
        price_req = RequestBody.create(MultipartBody.FORM, priceET);

        return true;
    }


    private boolean validateData() {

        boolean isValid = true;

        titleET = binding.titleET.getText().toString();
        authorET = binding.authorET.getText().toString();
        publisherET = binding.publisherET.getText().toString();
        yearET = binding.yearET.getText().toString();
        category = binding.category.getSelectedItem().toString();
        priceET = binding.priceET.getText().toString();
        uploadImageET = binding.uploadImageET.getText().toString();
        uploadPDFET = binding.uploadPDFET.getText().toString();


        if (uploadImageET.isEmpty()) {
            binding.uploadImageET.setError("Image is required");
            isValid = false;
        }

        if (uploadPDFET.isEmpty()) {
            binding.uploadPDFET.setError("PDF is required");
            isValid = false;
        }


        if (titleET.isEmpty()) {
            binding.titleET.setError("Title is required");
            isValid = false;
        }

        if (authorET.isEmpty()) {
            binding.authorET.setError("Author is required");
            isValid = false;
        }

        if (publisherET.isEmpty()) {
            binding.publisherET.setError("Publisher is required");
            isValid = false;
        }

        if (yearET.isEmpty()) {
            binding.yearET.setError("Year is required");
            isValid = false;
        }


        if (priceET.isEmpty()) {
            binding.priceET.setError("Price is required");
            isValid = false;
        }

        if (category.isEmpty()) {

            isValid = false;
        }


        return isValid;
    }

    private ActivityResultLauncher<Intent> pickImageLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Uri imageUri = result.getData().getData();
                    try {
                        File file = UriToFile.uriToFile(imageUri, this);
                        binding.uploadImageET.setText(file.getName());
                        RequestBody requestFile = RequestBody.create(MediaType.parse("*/*"), file);
                        image_req = MultipartBody.Part.createFormData("cover_image", file.getName(), requestFile);
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                        binding.imageView.setImageBitmap(bitmap);
                        // Use the bitmap or upload it
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    );

    private ActivityResultLauncher<Intent> pickPDFLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Uri PDFUri = result.getData().getData();

                    try {
                        File file = UriToFile.uriToFile(PDFUri, this);
                        binding.uploadPDFET.setText(file.getName());
                        RequestBody requestFile = RequestBody.create(MediaType.parse("*/*"), file);
                        pdf_req = MultipartBody.Part.createFormData("book", file.getName(), requestFile);

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
    );

    private ActivityResultLauncher<Intent> pickDemoPDFLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Uri demoPDFUri = result.getData().getData();

                    try {
                        File file = UriToFile.uriToFile(demoPDFUri, this);
                        binding.uploadDemoPDF.setText(file.getName());
                        RequestBody requestFile = RequestBody.create(MediaType.parse("*/*"), file);
                        demo_req = MultipartBody.Part.createFormData("demo_file", file.getName(), requestFile);

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
    );


}