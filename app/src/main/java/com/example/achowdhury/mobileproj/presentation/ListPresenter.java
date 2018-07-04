package com.example.achowdhury.mobileproj.presentation;

import com.example.achowdhury.mobileproj.model.Post;
import com.example.achowdhury.mobileproj.network.ListService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class ListPresenter implements ListMVP.Presenter {

    public static boolean viewState = false;
    private CompositeDisposable disposables;
    private ListMVP.View view;

    @Inject
    ListService service;

    @Inject
    public ListPresenter(ListService service) {
        disposables = new CompositeDisposable();
    }

    @Override
    public void setView(ListMVP.View view) {
        this.view = view;
    }

    @Override
    public void onShowListPressed() {
        view.showLoad();

        Disposable d = service.getPostList(new ListService.ListResponseCallback() {
            @Override
            public void onListSuccess(List<Post> postList) {
                view.showList(postList);

                viewState = true;
            }

            @Override
            public void onListFailure() {
                view.showFail();
            }
        });

        disposables.add(d);
    }

    @Override
    public void dropView() {
        view = null;
    }

}
