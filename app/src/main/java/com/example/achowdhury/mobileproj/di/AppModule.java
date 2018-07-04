package com.example.achowdhury.mobileproj.di;

import android.app.Application;
import android.content.Context;

import com.example.achowdhury.mobileproj.model.api.PostApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class AppModule {

    @Provides
    Context bindsContext(Application application) {
        return application;
    }

    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";

    @Singleton
    @Provides
    Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    @Singleton
    @Provides
    PostApi providesPostsService(Retrofit retrofit) {
        return retrofit.create(PostApi.class);
    }
}
