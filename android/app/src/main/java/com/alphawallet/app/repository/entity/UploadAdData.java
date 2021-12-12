package com.alphawallet.app.repository.entity;

import com.google.gson.annotations.SerializedName;

public class UploadAdData {

    @SerializedName("poster_address")
    private String posterAddress;

    @SerializedName("max_token_budget")
    private int maxTokenBudget;

    @SerializedName("redirect_url")
    private String redirectUrl;

    @SerializedName("tag_lines")
    private String tagLines;

    public UploadAdData(String posterAddress, int maxTokenBudget, String redirectUrl, String tagLines) {
        this.posterAddress = posterAddress;
        this.maxTokenBudget = maxTokenBudget;
        this.redirectUrl = redirectUrl;
        this.tagLines = tagLines;
    }
}
