package com.kshrd.dagger2.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonObject;
import com.kshrd.dagger2.R;
import com.kshrd.dagger2.api.ArticleApi;
import com.kshrd.dagger2.app.MyApplication;
import com.kshrd.dagger2.data.PreferenceHelper;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    @Inject
    PreferenceHelper preferenceHelper;

    @Inject
    ArticleApi articleApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ((MyApplication) getApplication()).getApplicationComponent().inject(this);

    }
}
