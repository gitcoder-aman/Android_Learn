package com.example.practicews.Activity;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;

import com.example.practicews.R;


public class ToolBarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);


        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Example");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setBackgroundColor(Color.RED);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}