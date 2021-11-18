package com.example.honeyloginapi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.honeyloginapi.R;
import com.example.honeyloginapi.pojos.Posts;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    public List<Posts> postsList;
    public Context context;

    public PostsAdapter(List<Posts> postsList, Context context) {
        this.postsList = postsList;
        this.context = context;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.posts_recyclerview_layout, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
        Posts post = postsList.get(position);

        holder.name.setText(post.getName());
        holder.title.setText(post.getTitle());
        holder.description.setText(post.getDescription());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, title, description;
        private MaterialButton like;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.userName);
            title = itemView.findViewById(R.id.movieTitle);
            description = itemView.findViewById(R.id.movieDescription);
            like = itemView.findViewById(R.id.likeButton);
        }
    }
}
