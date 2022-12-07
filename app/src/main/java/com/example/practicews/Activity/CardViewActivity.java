package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

import com.example.practicews.R;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        CardView cardView;
        cardView = findViewById(R.id.cardView);

//        cardView.setRadius(5.0f);
//        cardView.setCardElevation(11.0f);
//        cardView.setUseCompatPadding(true);
    }
}