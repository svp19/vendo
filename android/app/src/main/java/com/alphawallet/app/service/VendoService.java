package com.alphawallet.app.service;

import com.alphawallet.app.repository.entity.UploadAdResultData;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface VendoService {

    @Multipart
    @POST("api/upload")
    Call<UploadAdResultData> uploadAd(@Part MultipartBody.Part file,
                                      @Part("poster_address") RequestBody posterAddress,
                                      @Part("max_token_budget") RequestBody maxTokenBudget,
                                      @Part("redirect_url") RequestBody redirectUrl,
                                      @Part("tag_lines") RequestBody tagLines);
}
