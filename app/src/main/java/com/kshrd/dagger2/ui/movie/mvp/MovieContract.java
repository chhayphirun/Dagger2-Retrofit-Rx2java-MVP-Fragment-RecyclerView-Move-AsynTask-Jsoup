package com.kshrd.dagger2.ui.movie.mvp;

import com.kshrd.dagger2.base.BaseMvpPresenter;
import com.kshrd.dagger2.base.BaseMvpView;
import com.kshrd.dagger2.entity.Movie;
import com.kshrd.dagger2.listener.CallbackWithList;

import java.util.List;

/**
 * Created by pirang on 7/21/17.
 */

public interface MovieContract {

    interface View extends BaseMvpView {
        void updateRecyclerView(List<Movie> movieList);
    }

    interface Presenter extends BaseMvpPresenter<MovieContract.View> {
        void findMovie();
    }

    interface Interactor {
        void findMovie(CallbackWithList<Movie> callback);
    }

}
