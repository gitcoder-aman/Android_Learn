package com.example.practicews.RetrofitAPI;

import static com.example.practicews.RetrofitAPI.RetrofitActivity.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static RetrofitInstance instance;
    ApiInterface apiInterface;

    public RetrofitInstance() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetrofitInstance getInstance(){
        if(instance == null){
            instance = new RetrofitInstance();
        }
        return instance;
    }



}
