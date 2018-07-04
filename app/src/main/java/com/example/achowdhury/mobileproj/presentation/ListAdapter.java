package com.example.achowdhury.mobileproj.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achowdhury.mobileproj.R;
import com.example.achowdhury.mobileproj.model.Post;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private List<Post> postList;

    public ListAdapter() {
        postList = new ArrayList<>();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.post_row, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setList(List<Post> postList) {
        this.postList = postList;
    }
}
