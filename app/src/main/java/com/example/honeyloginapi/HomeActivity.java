package com.example.honeyloginapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.honeyloginapi.adapters.PostsAdapter;
import com.example.honeyloginapi.api.RequestPlaceholder;
import com.example.honeyloginapi.api.RetrofitBuilder;
import com.example.honeyloginapi.pojos.Posts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    public RecyclerView postsRecyclerView;
    public List<Posts> postsList;
    public PostsAdapter postsAdapter;

    private SwipeRefreshLayout swipeRefresh;

    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);

        swipeRefresh = findViewById(R.id.swipeRefresh);

        postsRecyclerView = findViewById(R.id.postsRecyclerView);
        postsList = new ArrayList<>();
        postsAdapter = new PostsAdapter(postsList, this);
        postsRecyclerView.setAdapter(postsAdapter);
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populatePosts();
            }
        });

        populatePosts();
    }

    public void populatePosts(){
        try {
            postsList.clear();
            Call<List<Posts>> postsCall = requestPlaceholder.getAllPost("D9ENxmOp9mxOdOCSQhJBjPwTK46rD9GNguLiGleCqhs8WkKQ6cMWtvIioTEHMQED", "2");

            postsCall.enqueue(new Callback<List<Posts>>() {
                @Override
                public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                    if (response.isSuccessful()) {
                        if (response.code() == 200) {
                            postsList.addAll(response.body());

                            postsAdapter.notifyDataSetChanged();

                            swipeRefresh.setRefreshing(false);
                        } else {
                            Log.e("ERR_GET_POSTS", response.message() + "");
                            Toast.makeText(HomeActivity.this, "Error getting posts!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Log.e("ERR_GET_POSTS", response.message() + "");
                        Toast.makeText(HomeActivity.this, "Error getting posts!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<Posts>> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            Log.e("ERR_GET_POSTS", e.getMessage());
        }
    }
}