package com.example.practicews.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.practicews.Fragment.AFragment;
import com.example.practicews.Fragment.BFragment;
import com.example.practicews.Fragment.CFragment;
import com.example.practicews.Fragment.DFragment;
import com.example.practicews.Fragment.EFragment;
import com.example.practicews.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationViewActivity extends AppCompatActivity {

    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);

        bnView = findViewById(R.id.bottomNavigationView);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container2,new AFragment());
        fragmentTransaction.commit();

        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.nav_home){

                    loadFragment(new AFragment());

                }else if(id == R.id.nav_search){

                    loadFragment(new BFragment());

                }else if(id == R.id.nav_utilities){

                   loadFragment(new CFragment());

                }else if(id == R.id.nav_contact){

                    loadFragment(new DFragment());

                }else{  // For Profile

                    loadFragment(new EFragment());
                }
                return true;
            }
        });
        bnView.setSelectedItemId(R.id.nav_profile);
    }
    public void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container2,fragment);
        fragmentTransaction.commit();
    }
}