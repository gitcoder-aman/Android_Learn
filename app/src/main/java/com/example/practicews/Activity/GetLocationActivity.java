package com.example.practicews.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicews.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GetLocationActivity extends AppCompatActivity {

    //GetCurrent Location

    FusedLocationProviderClient fusedLocationProviderClient;
    TextView country,city,address,longitude,latitude;
    Button getLocationBtn;
    private int   PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);

        country = findViewById(R.id.country);
        city = findViewById(R.id.city);
        address = findViewById(R.id.address);
        longitude = findViewById(R.id.longitude);
        latitude = findViewById(R.id.latitude);
        getLocationBtn = findViewById(R.id.getLocationBtn);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        getLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLastLocation();
            }
        });

    }

    private void getLastLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)  == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null){
                        Geocoder geocoder = new Geocoder(GetLocationActivity.this, Locale.getDefault());
                        List<Address> addressList = null;
                        try {
                            addressList = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),10  );

                            latitude.setText("Latitude: "+ addressList.get(0).getLatitude());
                            longitude.setText("Longitude: "+ addressList.get(0).getLongitude());
                            address.setText("Address: "+addressList.get(0).getAddressLine(0));
                            city.setText("City: "+addressList.get(0).getLocality());
                            country.setText("Country: "+addressList.get(0).getCountryName());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
        }else{
            //if user have not  access the location then ask Location permission
            askPermission();
        }
    }

    private void askPermission() {

        ActivityCompat.requestPermissions(GetLocationActivity.this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                getLastLocation();
            }else{
                Toast.makeText(this, "Required Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }
}