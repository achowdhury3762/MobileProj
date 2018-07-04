package com.example.achowdhury.mobileproj.presentation;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ListModule {
    @Binds
    abstract ListMVP.Presenter presenter(ListPresenter presenter);
}
