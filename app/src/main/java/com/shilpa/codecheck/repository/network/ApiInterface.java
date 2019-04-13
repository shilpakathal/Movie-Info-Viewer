package com.shilpa.codecheck.repository.network;

import com.shilpa.codecheck.repository.model.MovieInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.shilpa.codecheck.common.constants.QUERY_MOVIES;

public interface ApiInterface {
@GET(QUERY_MOVIES)
Call<List<MovieInfo>> getMovies();
}
