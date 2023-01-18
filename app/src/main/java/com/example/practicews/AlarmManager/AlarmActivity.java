package com.example.practicews.AlarmManager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.practicews.R;

public class AlarmActivity extends AppCompatActivity {

    private EditText edtTime;
    private Button btnSet;

    private static final int ALARM_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        edtTime = findViewById(R.id.edtTime);
        btnSet = findViewById(R.id.btnSet);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int time = Integer.parseInt(edtTime.getText().toString());
                long triggerTime = System.currentTimeMillis()+(time* 1000L);

                Intent iBroadCast = new Intent(AlarmActivity.this,AlarmReceiver.class);

                PendingIntent pi = PendingIntent.getBroadcast(AlarmActivity.this,ALARM_REQ_CODE,iBroadCast,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);
            }
        });
    }
}