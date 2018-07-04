package com.example.achowdhury.mobileproj.di;

import com.example.achowdhury.mobileproj.presentation.ListActivity;
import com.example.achowdhury.mobileproj.presentation.ListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class BindersModule {
    @PerActivity
    @ContributesAndroidInjector(modules = ListModule.class)
    abstract ListActivity spotifyAuthenticationActivity();
}
