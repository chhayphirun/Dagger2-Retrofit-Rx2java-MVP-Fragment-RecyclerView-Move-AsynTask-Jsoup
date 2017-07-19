package com.kshrd.dagger2.api;

import com.google.gson.JsonObject;
import com.kshrd.dagger2.entity.response.ArticleResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by pirang on 7/18/17.
 */

public interface ArticleApi {

    @GET("articles")
    Single<Response<ArticleResponse>> findAll();

}
