package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.practicews.R;

public class PostApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_api);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

    }
}