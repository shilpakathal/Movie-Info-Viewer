package com.shilpa.codecheck.viewmodel;

import android.app.Application;
import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.shilpa.codecheck.repository.model.MovieInfo;
import com.shilpa.codecheck.repository.network.MovieClientService;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class MoviesListViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Application mApp;

    private MoviesListViewModel mViewModel;

    @Mock
    private MovieClientService movieClientService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mViewModel = new MoviesListViewModel(mApp, movieClientService);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMovies_whenEmptyResult() {
        MutableLiveData<List<MovieInfo>> movieList = new MutableLiveData<>();
        movieList.setValue(new ArrayList<MovieInfo>());

        when(movieClientService.getMovies()).thenReturn(movieList);

        assertNotNull(mViewModel.getMovies());

        assertNotNull(mViewModel.getMovies().getValue());
    }

    @Test
    public void getMovies_whenValidResult()
    {
        MutableLiveData<List<MovieInfo>> movieList = new MutableLiveData<>();
        List<MovieInfo> movieInfoList = new ArrayList<>();
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setTitle("Made in Heaven");
        movieInfo.setDescription("Family movie with good humour");
        movieInfo.setDirector("Thomas Pearson");
        movieInfo.setRtScore("10");
        movieInfo.setReleaseDate("2018");
        movieInfoList.add(movieInfo);

        movieList.setValue(movieInfoList);
        when(movieClientService.getMovies()).thenReturn(movieList);

        assertNotNull(movieClientService.getMovies());

        List<MovieInfo> resultList = mViewModel.getMovies().getValue();

        assertNotNull(resultList);
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.size() == 1);

        MovieInfo movieInfo1 = resultList.get(0);

        assertTrue(movieInfo1.getTitle().equals(movieInfo.getTitle()));
        assertTrue(movieInfo1.getDescription().equals(movieInfo.getDescription()));
        assertTrue(movieInfo1.getDirector().equals(movieInfo.getDirector()));
        assertTrue(movieInfo1.getReleaseDate().equals(movieInfo.getReleaseDate()));
        assertTrue(movieInfo1.getRtScore().equals(movieInfo.getRtScore()));

    }
}