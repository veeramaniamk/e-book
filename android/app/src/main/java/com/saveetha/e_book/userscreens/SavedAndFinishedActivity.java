package com.saveetha.e_book.userscreens;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saveetha.e_book.Constant;
import com.saveetha.e_book.RestClient;
import com.saveetha.e_book.SF;
import com.saveetha.e_book.StaticMethods;
import com.saveetha.e_book.databinding.ActivitySavedAndFinishedBinding;
import com.saveetha.e_book.databinding.CategoriesViewLayoutBinding;
import com.saveetha.e_book.response.user.GetSavedBookData;
import com.saveetha.e_book.response.user.GetSavedBooksReponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SavedAndFinishedActivity extends AppCompatActivity {

    private Context context;
    private FragmentActivity activity;
    ActivitySavedAndFinishedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivitySavedAndFinishedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        try {
            context = this;
            activity = this;
            String userId = SF.getSignInSFValue(activity).get(Constant.ID_SI_SF);
            apiCall(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clickListener();
    }
    private void apiCall(String userId) {
        Call<GetSavedBooksReponse> responseCall = RestClient.makeAPI().getSavedBooks(userId);
        responseCall.enqueue(new Callback<GetSavedBooksReponse>() {
            @Override
            public void onResponse(@NonNull Call<GetSavedBooksReponse> call, @NonNull Response<GetSavedBooksReponse> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus() == 200) {
                        if(response.body().getData() == null){
                            Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        List<BookData> list = new ArrayList<>();
                        for (GetSavedBookData data : response.body().getData()) {
                            list.add(new BookData(data.getBook_title(),data.getBook_id(),data.getBook_cover_image(),data.getSaved_id()));
                        }
                        binding.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
                        binding.recyclerView.setAdapter(new SavedAndFinishedAdapter(activity,list));
                    }else {
                        Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetSavedBooksReponse> call, @NonNull Throwable t) {
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getMessage());
            }
        });
    }

    private void clickListener() {
        binding.backCV.setOnClickListener(v -> finish());
    }

    private class BookData {
        private String title;
        private int bookId;
        private String bookCoverImage;
        private int bookSavedId;

        public BookData(String title, int bookId, String bookCoverImage, int bookSavedId) {
            this.title = title;
            this.bookId = bookId;
            this.bookCoverImage = bookCoverImage;
            this.bookSavedId = bookSavedId;

        }

        public int getBookSavedId() {
            return bookSavedId;
        }

        public String getTitle() {
            return title;
        }

        public int getBookId() {
            return bookId;
        }

        public String getBookCoverImage() {
            return bookCoverImage;
        }
    }

    private class SavedAndFinishedAdapter extends RecyclerView.Adapter<SavedAndFinishedAdapter.MyViewHolder> {

        FragmentActivity activity;
        List<BookData> list;

        public SavedAndFinishedAdapter(FragmentActivity activity, List<BookData> list) {
            this.activity = activity;
            this.list     = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            CategoriesViewLayoutBinding binding = CategoriesViewLayoutBinding.inflate(getLayoutInflater(), parent, false);
            return new MyViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            BookData data = list.get(position);
            StaticMethods.setGlide(activity, holder.binding.categoryIV, data.getBookCoverImage());
            holder.binding.categoryTV.setText(data.getTitle());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            CategoriesViewLayoutBinding binding;
            MyViewHolder(CategoriesViewLayoutBinding itemView) {
                super(itemView.getRoot());
                binding = itemView;
            }
        }
    }

}