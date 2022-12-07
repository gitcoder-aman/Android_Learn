package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.practicews.R;

public class DataPassingActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        intent = getIntent();

        String title = intent.getStringExtra("title");
        String name = intent.getStringExtra("student_name");
        int roll_no = intent.getIntExtra("Roll no",0);

        TextView Tname,Ttitle,Troll_no;

        Tname = findViewById(R.id.name);
        Troll_no = findViewById(R.id.roll_no);

        Tname.setText(name);
        Troll_no.setText(String.valueOf(roll_no));

        getSupportActionBar().setTitle(title);
    }
}