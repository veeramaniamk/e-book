package com.saveetha.e_book.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.saveetha.e_book.R;
import com.squareup.picasso.Picasso;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    private List<Category> books;
    private Context context;

    public BookListAdapter(Context context, List<Category> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category book = books.get(position);
        holder.bookName.setText(book.getName());
        Picasso.get().load(imageUrl).into(holder.bookImage);
        holder.book.setOnClickListener(v -> {
            Intent intent = new Intent(context, BooksListActivity.class);
            intent.putExtra("CATEGORY_NAME", category.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bookImage;
        TextView bookName;
        ConstraintLayout book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.categoryIV);
            bookName = itemView.findViewById(R.id.categoryTV);
            book = itemView.findViewById(R.id.categoryCL);
        }
    }
}
