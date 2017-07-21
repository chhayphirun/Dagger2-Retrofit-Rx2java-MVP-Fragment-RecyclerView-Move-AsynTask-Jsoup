package com.kshrd.dagger2.app.di.module;

import com.kshrd.dagger2.ui.movie.mvp.MovieContract;
import com.kshrd.dagger2.ui.movie.mvp.MoviePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pirang on 7/20/17.
 */

@Module
public class ActivityModule {

    @Provides
    public MovieContract.Presenter provideMoviePresenter(MoviePresenter moviePresenter) {
        return moviePresenter;
    }

}
