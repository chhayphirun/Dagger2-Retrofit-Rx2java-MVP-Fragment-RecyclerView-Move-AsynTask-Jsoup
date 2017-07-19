package com.kshrd.dagger2.app.di.module;

import com.kshrd.dagger2.api.ArticleApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pirang on 7/18/17.
 */

@Module(includes = NetworkModule.class)
public class RestfulModule {

    private final String BASE_URL = "http://110.74.194.125:1301/v1/api/";

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    public CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    @Singleton
    public ArticleApi provideArticleApi(OkHttpClient okHttpClient) {
        return provideRetrofit(okHttpClient).create(ArticleApi.class);
    }

}
