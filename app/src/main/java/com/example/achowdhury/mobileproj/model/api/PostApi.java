package com.example.achowdhury.mobileproj.model.api;

import com.example.achowdhury.mobileproj.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostApi {
    @GET("posts")
    Observable<List<Post>> getPosts();
}
