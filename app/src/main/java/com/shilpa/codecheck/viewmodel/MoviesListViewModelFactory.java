package com.shilpa.codecheck.viewmodel;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.shilpa.codecheck.repository.network.MovieClientService;

public class MoviesListViewModelFactory implements ViewModelProvider.Factory {
    Application mApp;
    MovieClientService mApi;

    public MoviesListViewModelFactory(Application mApp, MovieClientService movieClientService) {
        this.mApp = mApp;
         mApi = movieClientService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MoviesListViewModel.class)) {
            return (T) new MoviesListViewModel(mApp,mApi);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
