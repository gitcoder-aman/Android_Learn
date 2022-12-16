package com.example.practicews.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.practicews.R;
import com.example.practicews.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private int PERMISSION_CODE = 1;
    private LocationManager locationManager;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //problem = https://stackoverflow.com/questions/32290045/error-invoke-virtual-method-double-android-location-location-getlatitude-on
        //Get Current Location

//        if (location != null) {
//            cityName = getCityName(location.getLongitude(), location.getLatitude());
//            Toast.makeText(this, cityName, Toast.LENGTH_SHORT).show();
//        }

    }

//    private String getCityName(double longitude, double latitude) {
//        String cityName = "Not found";
//        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
//
//        try {
//            List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 10);
//
//            for (Address address : addressList) {
//                if (address != null) {
//                    String city = address.getLocality();
//                    if (city != null && !city.equals("")) {
//                        cityName = city;
//                    } else {
//                        Log.e("TAG", "CITY NOT FOUND");
//                        Toast.makeText(this, "User City Not Found..", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return cityName;
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted..", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please provides the permissions", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {


        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng delhi = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(delhi).title("Marker in Delhi");
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));

        //Google Map Overlays
        //Circle
        mMap.addCircle(new CircleOptions()
                .center(delhi)
                .radius(1000)
                .fillColor(R.color.teal_200)
                .strokeColor(R.color.dark_Grey));

        //Polygon
        mMap.addPolygon(new PolygonOptions().add(new LatLng(28.642045974861404, 77.21826110310344),
                new LatLng(28.642045974861404, 78.21826110310344),
                new LatLng(29.642045974861404, 78.21826110310344),
                new LatLng(29.642045974861404, 77.21826110310344),
                new LatLng(28.642045974861404, 77.21826110310344)).fillColor(Color.YELLOW).strokeColor(Color.BLUE));

        //Ground OverLay
        //Image
        mMap.addGroundOverlay(new GroundOverlayOptions()
                .position(delhi, 500f, 500f)
                .image(BitmapDescriptorFactory.fromResource(R.drawable.animal))
                .clickable(true));


        //GeoCoder //Specific name of location
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {

                //remove previous marker
                mMap.clear();

                Geocoder geocoder = new Geocoder(MapsActivity.this);
                try {
                    ArrayList<Address> arrAdr = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

                    if (arrAdr.isEmpty()) { // when user click in empty area like sea, desert
                        return;
                    } else {
                        Log.d("Address", arrAdr.get(0).getAddressLine(0));
                        mMap.addMarker(new MarkerOptions().position(latLng).title(arrAdr.get(0).getAddressLine(0)));  //marker set where user click on map
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.map_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;

            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;

            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;

            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;

            case R.id.none_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}