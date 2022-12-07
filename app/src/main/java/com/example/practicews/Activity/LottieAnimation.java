package com.example.practicews.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.practicews.R;

public class LottieAnimation extends AppCompatActivity {

    LottieAnimationView laView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_animation);

//        laView.setAnimation(R.raw.lottie_animation);
//        laView.playAnimation();
//        laView.loop(true);
    }
}
