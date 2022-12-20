package com.example.practicews.RetrofitAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/photos")
    Call< List<UserModelOfAPI>> getUser();
}
