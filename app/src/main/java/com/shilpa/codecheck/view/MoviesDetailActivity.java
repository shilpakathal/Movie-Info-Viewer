package com.shilpa.codecheck.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.shilpa.codecheck.R;
import com.shilpa.codecheck.common.Constants;
import com.shilpa.codecheck.repository.model.MovieInfo;
import static com.shilpa.codecheck.common.Constants.MOVIE_INFO_PARCELABLE;

class MoviesDetailActivity extends AppCompatActivity {

    private static MovieInfo mMovieInfo;
    private TextView mMovieDesc, mMovieDirector, mMoviewReleaseDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        mMovieDesc = findViewById(R.id.movie_desc);
        mMovieDirector = findViewById(R.id.movie_director);
        mMoviewReleaseDate = findViewById(R.id.movie_releaseDate);

        mMovieInfo = new MovieInfo();

        Intent intent = getIntent();
        if (intent != null) {
            mMovieInfo = intent.getParcelableExtra(MOVIE_INFO_PARCELABLE);
            loadMoviesDetail(mMovieInfo);

        }
    }

    private void loadMoviesDetail(MovieInfo mMovieInfo) {

        if (mMovieInfo != null) {
            mMovieDesc.setText(Constants.MOVIE_DESC + mMovieInfo.getDescription());
            mMovieDirector.setText(Constants.MOVIE_DIRECTOR + mMovieInfo.getDirector());
            mMoviewReleaseDate.setText(Constants.MOVIE_RELEASE_DATE + mMovieInfo.getReleaseDate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
