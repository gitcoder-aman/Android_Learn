package com.example.practicews.Sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicews.R;

public class ProximitySensorActivity extends AppCompatActivity implements SensorEventListener {

    private TextView txtValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        txtValues = findViewById(R.id.txtValue);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager != null){
            Sensor proxySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if(proxySensor != null){
                sensorManager.registerListener(this,proxySensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent .sensor.getType() == Sensor.TYPE_PROXIMITY){
            txtValues.setText("Values "+sensorEvent.values[0]);

            if(sensorEvent.values[0] > 0){
                Toast.makeText(this, "Object is Far.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Object is Near.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}