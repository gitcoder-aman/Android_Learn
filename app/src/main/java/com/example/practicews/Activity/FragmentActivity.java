package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practicews.Fragment.AFragment;
import com.example.practicews.Fragment.BFragment;
import com.example.practicews.Fragment.CFragment;
import com.example.practicews.R;

public class FragmentActivity extends AppCompatActivity {

    Button btnFragA, btnFragB, btnFragC;
    String ROOT_FRAGMENT_TAG = "root_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);

        loadFragment(new AFragment(), true); //first loaded fragment in frameLayout

        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AFragment(), true);
            }
        });
        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new BFragment(), false);
            }
        });
        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new CFragment(), false);
            }
        });
    }

    public void loadFragment(Fragment fragment, boolean flag) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag) {
            ft.replace(R.id.container, fragment);

            fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);

        } else {
            ft.replace(R.id.container, fragment);
            //Managing Fragment back stack
            ft.addToBackStack(null);
        }

        ft.commit();
    }
}