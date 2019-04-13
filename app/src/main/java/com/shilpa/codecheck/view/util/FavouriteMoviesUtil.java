package com.shilpa.codecheck.view.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

public class FavouriteMoviesUtil {
    private static final String LOG_TAG = FavouriteMoviesUtil.class.getCanonicalName();
    private static final String FAVOURITES_SP_FILE = "Favourites";
    private static final String FAVOURITE_MOVIES_SP = "Favourite_movies";
    private Context context;
    private SharedPreferences sharedpreferences;
    private Set<String> favouriteMovieIds = new HashSet<String>();

    public FavouriteMoviesUtil(Context context) {
        this.context = context;
    }

    public void saveFavouriteMoviesToSp(String movieId) {

        sharedpreferences = context.getSharedPreferences(FAVOURITES_SP_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        if (favouriteMovieIds == null) {
            favouriteMovieIds = new HashSet<String>();
        }
        Log.d("##Writing to SP", movieId);
        favouriteMovieIds.add(movieId);
        editor.putStringSet(FAVOURITE_MOVIES_SP, favouriteMovieIds);

        editor.commit();
    }

    public boolean CheckFavouriteMoviesFromSp(String movieId) {

        sharedpreferences = context.getSharedPreferences(FAVOURITES_SP_FILE, Context.MODE_PRIVATE);

        favouriteMovieIds = sharedpreferences.getStringSet(FAVOURITE_MOVIES_SP, null);
        if (favouriteMovieIds != null) {
            if (favouriteMovieIds.contains(movieId)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void RemoveFavouriteMoviesFromSP(String movieID) {

        sharedpreferences = context.getSharedPreferences(FAVOURITES_SP_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        favouriteMovieIds = sharedpreferences.getStringSet(FAVOURITE_MOVIES_SP, null);

        if (favouriteMovieIds != null) {
            if (favouriteMovieIds.contains(movieID)) {
                favouriteMovieIds.remove(movieID);
                editor.putStringSet(FAVOURITE_MOVIES_SP, favouriteMovieIds);
                editor.commit();
            }
        }

    }
}