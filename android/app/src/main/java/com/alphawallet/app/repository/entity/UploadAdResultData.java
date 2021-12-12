package com.alphawallet.app.repository.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UploadAdResultData implements Serializable {

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("ad_id")
    @Expose
    private String adId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public UploadAdResultData(String url) {
        this.url = url;
    }
}
