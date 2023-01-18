package com.example.practicews.RetrofitAPI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.practicews.Model.TrendingMovieModel;
import com.example.practicews.Model.TrendingMovieResultModel;
import com.example.practicews.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    //   /photos
//    public static String api = "https://jsonplaceholder.typicode.com";
    public static String api = "http://api.themoviedb.org/3/";
    List<UserModelOfAPI> allUsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        RetrofitInstance.getInstance().apiInterface.getUser().enqueue(new Callback<List<UserModelOfAPI>>() {
//            @Override
//            public void onResponse(Call<List<UserModelOfAPI>> call, Response<List<UserModelOfAPI>> response) {
//
//                allUsersList = response.body();
//
//                recyclerView.setAdapter(new UserAdapter(RetrofitActivity.this,allUsersList));
////                for (int i = 0; i < allUsersList.size(); i++){
////                    Log.e("api", "onResponse "+allUsersList.get(i).getTitle());
////                }
//            }
//
//            @Override
//            public void onFailure(Call<List<UserModelOfAPI>> call, Throwable t) {
//                Log.e("api", t.getLocalizedMessage());
//            }
//        });
        RetrofitInstance.getInstance().apiInterface.getTrendingMovie("ac28a3498de90c46b11f31bda02b8b97").enqueue(new Callback<TrendingMovieModel>() {
            @Override
            public void onResponse(@NonNull Call<TrendingMovieModel> call, @NonNull Response<TrendingMovieModel> response) {

                Log.d("debug", "Response success");
                TrendingMovieModel upcomingResponse = response.body();

                if (upcomingResponse != null) {

                    List<TrendingMovieResultModel> upcomingList = upcomingResponse.getResults();

                    if(upcomingList != null){

                        Log.d("debug", upcomingList.get(0).getOriginal_title());
                    }else{
                        Log.d("debug","List is empty");
                    }

                }else{
                    Log.d("debug", "null");
                }
            }

            @Override
            public void onFailure(@NonNull Call<TrendingMovieModel> call, @NonNull Throwable t) {
                Log.d("debug", "Fail Response");
            }
        });


    }
}