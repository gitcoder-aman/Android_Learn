package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.practicews.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiActivity extends AppCompatActivity {
//Get API
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        String url = "https://jsonplaceholder.typicode.com/todos/1/users"; //GET

        ListView listView = findViewById(R.id.api_listView);
        ArrayList<String>arrNames = new ArrayList<>();

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {

                        Log.d("API", "The response is " + response.getString(i));

                        //Json Parsing

                        JSONObject objectResult = response.getJSONObject(i);
                        String name = objectResult.getString("name");

                        arrNames.add(name);

                        ArrayAdapter<String>adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrNames);
                        listView.setAdapter(adapter);
                        Log.d("API", name);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Json Parsing
                try {
                    JSONObject objectResult = response.getJSONObject(0);
                    String name = objectResult.getString("name");
                    Log.d("API", name);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("API", "Something went wrong");
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}