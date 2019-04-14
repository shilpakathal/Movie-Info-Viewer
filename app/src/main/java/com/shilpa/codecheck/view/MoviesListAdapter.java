package com.shilpa.codecheck.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.shilpa.codecheck.R;
import com.shilpa.codecheck.repository.model.MovieInfo;
import com.shilpa.codecheck.view.util.FavouriteMoviesUtil;

import java.util.List;

import static com.shilpa.codecheck.common.Constants.MOVIE_RATING;
import static com.shilpa.codecheck.common.Constants.MOVIE_RELEASE_DATE;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesListViewholder> {

    private final List<MovieInfo> moviesList;
    private Context mContext;
    private FavouriteMoviesUtil mFavouriteMoviesUtil;
    private final MoviesListActivity mParentActivity;

    public MoviesListAdapter(MoviesListActivity activity, List<MovieInfo> moviesLists) {
        this.mContext = activity.getApplicationContext();
        this.moviesList = moviesLists;
        mParentActivity = activity;
        mFavouriteMoviesUtil = new FavouriteMoviesUtil(mContext);
    }

    private final View.OnClickListener mOnItemClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mParentActivity.handleItemClick((MovieInfo) v.getTag());
        }
    };

    @NonNull
    @Override
    public MoviesListViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movies_list_row_item, viewGroup, false);
        return new MoviesListViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesListViewholder moviesListView, int i) {
        MovieInfo movieInfo = moviesList.get(i);

        if (movieInfo != null) {

            moviesListView.movieTitle.setText(movieInfo.getTitle());
            moviesListView.releaseDate.setText(MOVIE_RELEASE_DATE + movieInfo.getReleaseDate());
            moviesListView.rating.setText(MOVIE_RATING + movieInfo.getRtScore());

            if (isFavouriteMovie(movieInfo.getId())) {
                //Red heart
                moviesListView.favouriteBtn.setTag("red");
                moviesListView.favouriteBtn.setImageDrawable(mContext.getDrawable(R.drawable.ic_favorite));

            } else {
                // grey heart
                moviesListView.favouriteBtn.setTag("grey");
                moviesListView.favouriteBtn.setImageDrawable(mContext.getDrawable(R.drawable.ic_favorite_grey));

            }
            moviesListView.itemView.setTag(movieInfo);
            moviesListView.itemView.setOnClickListener(mOnItemClickListner);
        }
    }

    private boolean isFavouriteMovie(String movieId) {

        if (mFavouriteMoviesUtil.CheckFavouriteMoviesFromSp(movieId))
            return true;
        else
            return false;
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MoviesListViewholder extends RecyclerView.ViewHolder {
        private TextView movieTitle;
        private TextView releaseDate;
        private TextView rating;
        private ImageButton favouriteBtn;

        public MoviesListViewholder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
            releaseDate = itemView.findViewById(R.id.release_date);
            rating = itemView.findViewById(R.id.rating);
            favouriteBtn = itemView.findViewById(R.id.favourites);

            favouriteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (favouriteBtn.getTag().equals("grey")) {
                        favouriteBtn.setTag("red");
                        favouriteBtn.setImageDrawable(mContext.getDrawable(R.drawable.ic_favorite));
                        //save in Shared preference
                        mFavouriteMoviesUtil.saveFavouriteMoviesToSp(MoviesListAdapter.this.moviesList.get(getAdapterPosition()).getId());

                    } else if (favouriteBtn.getTag().equals("red")) {
                        favouriteBtn.setTag("grey");
                        favouriteBtn.setImageDrawable(mContext.getDrawable(R.drawable.ic_favorite_grey));
                        //remove from Shared preference
                        mFavouriteMoviesUtil.RemoveFavouriteMoviesFromSP(MoviesListAdapter.this.moviesList.get(getAdapterPosition()).getId());
                    }
                }
            });

        }
    }
}
