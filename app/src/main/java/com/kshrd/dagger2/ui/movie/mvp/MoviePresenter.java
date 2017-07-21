package com.kshrd.dagger2.ui.movie.mvp;

import com.kshrd.dagger2.base.BasePresenter;
import com.kshrd.dagger2.entity.Movie;
import com.kshrd.dagger2.listener.CallbackWithList;
import com.kshrd.dagger2.ui.main.mvp.MainContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pirang on 7/21/17.
 */

public class MoviePresenter extends BasePresenter<MovieContract.View> implements MovieContract.Presenter {

    private MovieContract.Interactor interactor;

    @Inject
    public MoviePresenter(MovieInteractor movieInteractor){
        this.interactor = movieInteractor;
    }

    @Override
    public void findMovie() {
        interactor.findMovie(new CallbackWithList<Movie>() {
            @Override
            public void onSuccess(List<Movie> list) {
                getMvpView().updateRecyclerView(list);
            }

            @Override
            public void onFailed() {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete() {

            }
        });
    }

}
