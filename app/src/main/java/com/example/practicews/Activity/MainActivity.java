package com.example.practicews.Activity;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practicews.R;
import com.example.practicews.RetrofitAPI.RetrofitActivity;
import com.example.practicews.Services.GetLocationActivity;
import com.example.practicews.Services.LocationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn, aniBtn, lottieBtn, listView, cardViewBtn, recyclerViewBtn, toolbarBtn, toastBtn;
        Button dialogBtn, notifBtn, implicitBtn, fragmentBtn, tabLayoutBtn, bottomNavigationBtn, navigationDrawer, dataPassFrag, mapBtn;
        Button getApiBtn, postApiBtn, locationWithServiceBtn, locationWithoutServiceBtn,retrofitBtn;
        Button youtubeThumb;

        btn = findViewById(R.id.btn);
        aniBtn = findViewById(R.id.animationBtn);
        lottieBtn = findViewById(R.id.lottieBtn);
        listView = findViewById(R.id.listView);
        cardViewBtn = findViewById(R.id.cardBtn);
        recyclerViewBtn = findViewById(R.id.RecyclerBtn);
        toolbarBtn = findViewById(R.id.toolbarBtn);
        toastBtn = findViewById(R.id.toastBtn);
        dialogBtn = findViewById(R.id.dialogBtn);
        notifBtn = findViewById(R.id.notifBtn);
        implicitBtn = findViewById(R.id.implicitBtn);
        fragmentBtn = findViewById(R.id.fragmentBtn);
        tabLayoutBtn = findViewById(R.id.tabLayoutBtn);
        bottomNavigationBtn = findViewById(R.id.bottomNavigationBtn);
        navigationDrawer = findViewById(R.id.navigation_drawer);
        dataPassFrag = findViewById(R.id.dataPassFrag);
        mapBtn = findViewById(R.id.map_button);
        getApiBtn = findViewById(R.id.api_btn);
        postApiBtn = findViewById(R.id.postApiBtn);
        locationWithServiceBtn = findViewById(R.id.getCurrentLocationBtn);
        locationWithoutServiceBtn = findViewById(R.id.locationActivityBtn);
        retrofitBtn = findViewById(R.id.retrofitBtn);
        youtubeThumb = findViewById(R.id.youtubeThumb);


        Intent intent = new Intent(this, DataPassingActivity.class);
        intent.putExtra("title", "Home");
        intent.putExtra("student_name", "Aman");
        intent.putExtra("Roll no", 10);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        aniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AnimationActivity.class));
            }
        });
        lottieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LottieAnimation.class));
            }
        });
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListViewSpinner.class));
            }
        });
        cardViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CardViewActivity.class));
            }
        });
        recyclerViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });
        toolbarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ToolBarActivity.class));
            }
        });
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CustomToastActivity.class));
            }
        });
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AlertDialogBox.class));
            }
        });
        notifBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
            }
        });
        implicitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ImplicitIntentActivity.class));
            }
        });
        fragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FragmentActivity.class));
            }
        });
        tabLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));
            }
        });
        bottomNavigationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BottomNavigationViewActivity.class));
            }
        });
        navigationDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NavigationDrawer.class));
            }
        });
        dataPassFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, DataPassingInFragActivity.class));
            }
        });
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });
        getApiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ApiActivity.class));
            }
        });
        postApiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PostApiActivity.class));
            }
        });
        locationWithServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GetLocationActivity.class));
            }
        });

        locationWithoutServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LocationActivity.class));
            }
        });
        retrofitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RetrofitActivity.class));
            }
        });
        youtubeThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,youtubeActivity.class));
            }
        });


    }
}