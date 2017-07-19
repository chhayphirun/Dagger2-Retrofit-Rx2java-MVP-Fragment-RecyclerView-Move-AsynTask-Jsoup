package com.kshrd.dagger2.entity.response;

import com.google.gson.annotations.SerializedName;
import com.kshrd.dagger2.entity.Article;
import com.kshrd.dagger2.entity.Pagination;

import java.util.List;

/**
 * Created by pirang on 7/19/17.
 */

public class ArticleResponse {


    @SerializedName("CODE")
    private String code;
    @SerializedName("MESSAGE")
    private String message;
    @SerializedName("DATA")
    private List<Article> articleList;
    @SerializedName("PAGINATION")
    private Pagination pagination;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
