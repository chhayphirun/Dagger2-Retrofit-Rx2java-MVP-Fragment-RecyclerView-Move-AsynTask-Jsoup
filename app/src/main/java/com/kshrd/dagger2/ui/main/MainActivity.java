package com.kshrd.dagger2.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.kshrd.dagger2.R;
import com.kshrd.dagger2.api.ArticleApi;
import com.kshrd.dagger2.app.MyApplication;
import com.kshrd.dagger2.app.di.qualifier.ApiKey;
import com.kshrd.dagger2.base.BaseActivity;
import com.kshrd.dagger2.data.PreferenceHelper;
import com.kshrd.dagger2.entity.Article;
import com.kshrd.dagger2.entity.response.ArticleResponse;
import com.kshrd.dagger2.ui.detail.DetailActivity;
import com.kshrd.dagger2.ui.main.mvp.MainContract;
import com.kshrd.dagger2.ui.main.mvp.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    String apiUrl;

    @Inject
    @ApiKey
    String apiKey;

    @Inject
    PreferenceHelper appPreferenceHelper;

    @Inject
    ArticleApi articleApi;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getApplicationComponent().inject(this);

        presenter.onAttach(this);
        presenter.findAllArticle();

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void updateRecyclerView(List<Article> articleList) {
        Toast.makeText(this, articleList.size() + "", Toast.LENGTH_SHORT).show();
    }
}
