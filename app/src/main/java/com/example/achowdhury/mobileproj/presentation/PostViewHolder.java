package com.example.achowdhury.mobileproj.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.achowdhury.mobileproj.R;
import com.example.achowdhury.mobileproj.model.Post;

class PostViewHolder extends RecyclerView.ViewHolder {
    private TextView titleTextView;
    private TextView bodyTextView;

    public PostViewHolder(View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.title_textView);
        bodyTextView = itemView.findViewById(R.id.body_textView);
    }

    public void bind(Post post) {
        titleTextView.setText(post.getTitle());

        bodyTextView.setText(post.getBody());
    }
}
