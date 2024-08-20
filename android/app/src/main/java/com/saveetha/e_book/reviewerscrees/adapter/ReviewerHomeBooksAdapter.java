package com.saveetha.e_book.reviewerscrees.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.saveetha.e_book.R;
import com.saveetha.e_book.adminscreens.AdminBookDetailsActivity;
import com.saveetha.e_book.adminscreens.adminmodules.AdminBooksModule;
import com.saveetha.e_book.reviewerscrees.modules.ReviewerBooksModule;

import java.util.List;

public class ReviewerHomeBooksAdapter extends RecyclerView.Adapter<ReviewerHomeBooksAdapter.MyViewHolder> {

    List<ReviewerBooksModule> list;
    Context context;

    public ReviewerHomeBooksAdapter(List<ReviewerBooksModule> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewerHomeBooksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_new_books_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewerHomeBooksAdapter.MyViewHolder holder, int position) {

        ReviewerBooksModule item = list.get(position);

        Glide.with(context)
                .load(item.getCoverImage())
                .placeholder(R.drawable.book_icon)
                .error(R.drawable.book_icon)
                .into(holder.imageUrl);

        holder.bookName.setText(item.getBookName());
        holder.descrption.setText(item.getDescription());

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                context.startActivity(new Intent(context, AdminBookDetailsActivity.class));
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bookName, descrption;
        ShapeableImageView imageUrl;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageUrl = itemView.findViewById(R.id.imageBook);
            bookName = itemView.findViewById(R.id.title);
            descrption = itemView.findViewById(R.id.descriptionText);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
