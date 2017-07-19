package com.kshrd.dagger2.entity;

import com.google.gson.annotations.SerializedName;

public class Author {
    @SerializedName("ID")
    private int id;
    @SerializedName("NAME")
    private String name;
    @SerializedName("EMAIL")
    private String email;
    @SerializedName("GENDER")
    private String gender;
    @SerializedName("TELEPHONE")
    private String telephone;
    @SerializedName("STATUS")
    private String status;
    @SerializedName("FACEBOOK_ID")
    private String facebookId;
    @SerializedName("IMAGE_URL")
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
