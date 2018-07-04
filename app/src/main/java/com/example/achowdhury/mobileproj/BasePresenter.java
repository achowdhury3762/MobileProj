package com.example.achowdhury.mobileproj;

public interface BasePresenter<View> {
    void dropView();

    void setView(View v);
}
