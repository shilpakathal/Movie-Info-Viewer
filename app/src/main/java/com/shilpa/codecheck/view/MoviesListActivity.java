package com.shilpa.codecheck.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shilpa.codecheck.R;
import com.shilpa.codecheck.repository.model.MovieInfo;
import com.shilpa.codecheck.repository.network.MovieClientService;
import com.shilpa.codecheck.viewmodel.MoviesListViewModel;
import com.shilpa.codecheck.viewmodel.MoviesListViewModelFactory;

import java.util.List;

import static com.shilpa.codecheck.common.constants.MOVIE_INFO_PARCELABLE;

public class MoviesListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MoviesListViewModel moviesListViewModel;
    private MoviesListViewModelFactory moviesListViewModelFactory;
    private MoviesListAdapter moviesListAdapter;
    private MovieClientService movieClientService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        mRecyclerView = findViewById(R.id.movies_list_recyler_view);

        movieClientService = new MovieClientService();
        moviesListViewModelFactory = new MoviesListViewModelFactory(getApplication(),movieClientService);
        moviesListViewModel = ViewModelProviders.of(MoviesListActivity.this, moviesListViewModelFactory).get(MoviesListViewModel.class);

        moviesListViewModel.getMovies().observe(MoviesListActivity.this, new Observer<List<MovieInfo>>() {
            @Override
            public void onChanged(@Nullable List<MovieInfo> movieInfosList) {
                if (movieInfosList.size() > 0)
                    loadMoviesList(movieInfosList);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void loadMoviesList(List<MovieInfo> movieInfosList) {

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        moviesListAdapter = new MoviesListAdapter(this, movieInfosList);
        mRecyclerView.setAdapter(moviesListAdapter);
    }

    public void handleItemClick(MovieInfo movieInfo) {
        Intent intent = new Intent(this, MoviesDetailActivity.class);
        intent.putExtra(MOVIE_INFO_PARCELABLE, movieInfo);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
