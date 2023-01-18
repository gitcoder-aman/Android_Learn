package com.example.practicews.RetrofitAPI;

import com.example.practicews.Model.TrendingMovieModel;
import com.example.practicews.Model.TrendingMovieResultModel;
import com.example.practicews.Model.Upcoming;
import com.example.practicews.RetrofitAPI.UserModelOfAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/photos")
    Call< List<UserModelOfAPI>> getUser();

    @GET("trending/all/day")
    Call<TrendingMovieModel>getTrendingMovie(@Query("api_key") String api_key);

    @GET("movie/upcoming")
    Call<Upcoming>getUpcoming(@Query("api_key") String api_key);
}
