package com.example.practicews.sharedPrefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.practicews.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("login",MODE_PRIVATE);
                boolean check = preferences.getBoolean("flag",false);

                Intent iNext;
                if(check){ //for true (user is Logged In)
                    iNext = new Intent(SplashScreenActivity.this,HomeActivity.class);
                }else{ //for false (either first time is user is logged out)
                    iNext = new Intent(SplashScreenActivity.this,LoginActivity.class);
                }
                startActivity(iNext);
            }
        }, 4000);
    }
}