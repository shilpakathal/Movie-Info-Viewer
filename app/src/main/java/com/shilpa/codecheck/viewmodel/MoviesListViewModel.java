package com.shilpa.codecheck.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.shilpa.codecheck.repository.model.MovieInfo;
import com.shilpa.codecheck.repository.network.MovieClientService;

import java.util.List;

public class MoviesListViewModel extends AndroidViewModel {
    private MovieClientService movieClientService;

    public MoviesListViewModel(@NonNull Application application, MovieClientService clientService) {
        super(application);
        this.movieClientService = clientService;
    }

    public LiveData<List<MovieInfo>> getMovies() {
        return movieClientService.getMovies();
    }
}
