package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practicews.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn,aniBtn,lottieBtn,listView,cardViewBtn,recyclerViewBtn,toolbarBtn,toastBtn;
        Button dialogBtn,notifBtn,implicitBtn,fragmentBtn,tabLayoutBtn,bottomNavigationBtn,navigationDrawer;

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


        Intent intent = new Intent(this, DataPassingActivity.class);
        intent.putExtra("title","Home");
        intent.putExtra("student_name","Aman");
        intent.putExtra("Roll no",10);
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
                startActivity(new Intent(MainActivity.this,CardViewActivity.class));
            }
        });
        recyclerViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
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
                startActivity(new Intent(MainActivity.this,CustomToastActivity.class));
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
                startActivity(new Intent(MainActivity.this,NotificationActivity.class));
            }
        });
        implicitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ImplicitIntentActivity.class));
            }
        });
        fragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FragmentActivity.class));
            }
        });
        tabLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TabLayoutActivity.class));
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
                startActivity(new Intent(MainActivity.this,NavigationDrawer.class));
            }
        });


    }
}