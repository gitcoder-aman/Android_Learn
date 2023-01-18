package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.practicews.Fragment.DataPassFragment;
import com.example.practicews.R;

public class DataPassingInFragActivity extends AppCompatActivity {

    Button dataPassBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_passing_in_frag);

        dataPassBtn = findViewById(R.id.dataPassBtn);

        dataPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Data Passing through 2nd way
                loadFragment(DataPassFragment.getInstance("Raman",11));
//                loadFragment(new DataPassFragment());  //1st way
            }
        });
    }
    public void loadFragment(Fragment fragment){

        //Data passing in  1st way
//                Bundle bundle = new Bundle();
//                bundle.putString("Arg1","Aman");
//                bundle.putInt("Arg2",7);
//
//                fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content,fragment);
        fragmentTransaction.commit();

    }
    public void callFromFragment(){
        Log.d("inAct","fromFragment");
        Toast.makeText(this, "Calling From Fragment", Toast.LENGTH_SHORT).show();
    }
}