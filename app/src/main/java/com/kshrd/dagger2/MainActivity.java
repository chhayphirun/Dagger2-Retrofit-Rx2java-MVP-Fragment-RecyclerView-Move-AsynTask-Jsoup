package com.kshrd.dagger2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonObject;
import com.kshrd.dagger2.api.ArticleApi;
import com.kshrd.dagger2.app.MyApplication;
import com.kshrd.dagger2.app.di.qualifier.ApiKey;
import com.kshrd.dagger2.data.AppPreferenceHelper;
import com.kshrd.dagger2.data.PreferenceHelper;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    String apiUrl;

    @Inject
    @ApiKey
    String apiKey;

    @Inject
    PreferenceHelper appPreferenceHelper;

    @Inject
    ArticleApi articleApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getApplicationComponent().inject(this);

        findViewById(R.id.btnDetail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });


        articleApi.findAll().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.e("ooooo", response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }
}
