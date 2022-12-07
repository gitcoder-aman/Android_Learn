package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.practicews.R;

public class AnimationActivity extends AppCompatActivity {

    TextView textView;
    Button translateBtn,alphaBtn,scaleBtn,rotateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        textView = findViewById(R.id.animText);
        translateBtn = findViewById(R.id.TranslateBtn);
        alphaBtn = findViewById(R.id.AlphaBtn);
        scaleBtn = findViewById(R.id.ScaleBtn);
        rotateBtn = findViewById(R.id.RotateBtn);

        Animation move = AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.move);

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(move);
            }
        });
        alphaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alpha = AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.alpha);
                textView.startAnimation(alpha);
            }
        });
        scaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation scale = AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.scale);
                textView.startAnimation(scale);
            }
        });
        rotateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.rotate);
                textView.startAnimation(rotate);
            }
        });
    }
}