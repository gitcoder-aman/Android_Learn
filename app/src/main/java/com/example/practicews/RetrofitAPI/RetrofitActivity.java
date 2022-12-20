package com.example.practicews.RetrofitAPI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.practicews.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    //   /photos
    public static String api = "https://jsonplaceholder.typicode.com";
    List<UserModelOfAPI>allUsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInstance.getInstance().apiInterface.getUser().enqueue(new Callback<List<UserModelOfAPI>>() {
            @Override
            public void onResponse(Call<List<UserModelOfAPI>> call, Response<List<UserModelOfAPI>> response) {

                allUsersList = response.body();

                recyclerView.setAdapter(new UserAdapter(RetrofitActivity.this,allUsersList));
//                for (int i = 0; i < allUsersList.size(); i++){
//                    Log.e("api", "onResponse "+allUsersList.get(i).getTitle());
//                }
            }

            @Override
            public void onFailure(Call<List<UserModelOfAPI>> call, Throwable t) {
                Log.e("api", t.getLocalizedMessage());
            }
        });
    }
}