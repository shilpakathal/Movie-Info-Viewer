package com.shilpa.codecheck.repository.network;

import android.arch.lifecycle.LiveData;
import com.shilpa.codecheck.repository.model.MovieInfo;
import java.util.List;

public interface MovieClientInterface {
    LiveData<List<MovieInfo>> getMovies();
}
