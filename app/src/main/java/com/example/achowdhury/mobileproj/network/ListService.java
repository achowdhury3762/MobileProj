package com.example.achowdhury.mobileproj.network;

import com.example.achowdhury.mobileproj.model.Post;
import com.example.achowdhury.mobileproj.model.api.PostApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ListService {

    private PostApi postService;

    @Inject
    public ListService(PostApi postService) {
        this.postService = postService;
    }

    public Disposable getPostList(final ListResponseCallback callback) {
        return postService.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Post>>() {
                    @Override
                    public void onNext(List<Post> posts) {
                        callback.onListSuccess(posts);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onListFailure();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface ListResponseCallback {
        void onListSuccess(List<Post> postList);

        void onListFailure();
    }
}
