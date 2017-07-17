package com.kshrd.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kshrd.dagger2.app.MyApplication;
import com.kshrd.dagger2.app.di.ApiKey;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Inject
    String apiUrl;

    @Inject
    @ApiKey
    String apiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getApplicationComponent().inject(this);
        Log.e("ooooo", apiUrl);
        Log.e("ooooo", apiKey);

    }
}
