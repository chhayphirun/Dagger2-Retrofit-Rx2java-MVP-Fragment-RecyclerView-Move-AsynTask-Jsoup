package com.kshrd.dagger2.ui.main.mvp;

import com.kshrd.dagger2.base.BaseMvpPresenter;
import com.kshrd.dagger2.base.BaseMvpView;
import com.kshrd.dagger2.entity.Article;
import com.kshrd.dagger2.listener.CallbackWithList;

import java.util.List;

import retrofit2.Call;

/**
 * Created by pirang on 7/19/17.
 */

public interface MainContract {

    interface View extends BaseMvpView {
        void updateRecyclerView(List<Article> articleList);
    }

    interface Presenter extends BaseMvpPresenter<MainContract.View> {
        void findAllArticle();
    }

    interface Interactor {
        void findAllArticle(CallbackWithList<Article> callback);
    }

}
