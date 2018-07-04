package com.example.achowdhury.mobileproj.presentation;

import com.example.achowdhury.mobileproj.BasePresenter;
import com.example.achowdhury.mobileproj.model.Post;

import java.util.List;

class ListMVP {
    interface View {
        void showList(List<Post> postList);

        void showLoad();

        void showFail();
    }

    interface Presenter extends BasePresenter<View> {
        void onShowListPressed();
    }
}
