package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicews.R;

public class CustomToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);

        Button button,customToastBtn;

        button = findViewById(R.id.button);
        customToastBtn = findViewById(R.id.customToastBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CustomToastActivity.this, "This is Toast!", Toast.LENGTH_LONG).show();
            }
        });
        customToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast = new Toast(getApplicationContext());
                View view1 = getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.viewContainer));
                toast.setView(view1);

                TextView txtMessage;
                txtMessage = view1.findViewById(R.id.txtMessage);
                txtMessage.setText("Message sent Successfully!");

                toast.setDuration(Toast.LENGTH_LONG);

                toast.setGravity(Gravity.TOP|Gravity.RIGHT,0,0);
                toast.show();

            }
        });
    }
}