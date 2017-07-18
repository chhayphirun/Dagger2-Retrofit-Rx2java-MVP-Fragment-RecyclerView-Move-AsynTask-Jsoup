package com.kshrd.dagger2.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pirang on 7/18/17.
 */

public interface ArticleApi {

    @GET("articles")
    Call<JsonObject> findAll();

}
