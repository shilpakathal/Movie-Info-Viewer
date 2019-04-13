package com.shilpa.codecheck.repository.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.shilpa.codecheck.repository.model.MovieInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieClientService implements MovieClientInterface {
    private MutableLiveData<List<MovieInfo>> moviesData;

    public MovieClientService() {
        this.moviesData = new MutableLiveData<>();
    }

    @Override
    public LiveData<List<MovieInfo>> getMovies() {

        ApiInterface apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);

        if (apiInterface != null) {
            apiInterface.getMovies().enqueue(new Callback<List<MovieInfo>>() {
                @Override
                public void onResponse(Call<List<MovieInfo>> call, Response<List<MovieInfo>> response) {
                    if (isResponseValid(response)) {
                        moviesData.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<MovieInfo>> call, Throwable t) {
                    Log.e("MoviewClientService", "Retrofit response failed!");
                }
            });
        }
        return moviesData;
    }

    private boolean isResponseValid(Response<List<MovieInfo>> response) {
        if (response.isSuccessful()) {
            if (response.body() != null)
                return true;
        }
        return false;
    }
}
