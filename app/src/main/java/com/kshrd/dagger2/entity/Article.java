package com.kshrd.dagger2.entity;

import com.google.gson.annotations.SerializedName;

public class Article {
    @SerializedName("ID")
    private int id;
    @SerializedName("TITLE")
    private String title;
    @SerializedName("DESCRIPTION")
    private String description;
    @SerializedName("CREATED_DATE")
    private String createdDate;
    @SerializedName("AUTHOR")
    private Author author;
    @SerializedName("STATUS")
    private String status;
    @SerializedName("CATEGORY")
    private Category category;
    @SerializedName("IMAGE")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
