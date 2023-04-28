package com.example.practicews.RetrofitAPI;

import static com.example.practicews.RetrofitAPI.RetrofitActivity.api;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.practicews.Model.InstagramItemDetailModel;
import com.example.practicews.Model.InstagramVideoModel;
import com.example.practicews.Model.TrendingMovieModel;
import com.example.practicews.R;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import javax.xml.transform.ErrorListener;

import retrofit2.Call;
import retrofit2.Callback;

public class InstagramActivity extends AppCompatActivity {
//    private String api = "https://www.instagram.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

//        String url = "Cp-kXNRI5O0";
//        String apiKey = "/?__a=1&__d=dis";

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.instagram.com/reel/Co7SaXQAvg3/?__a=1&__d=dis";
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("@@@@","v "+response.toString());
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response.toString());
                    JSONObject objectGraphql = jsonObject.getJSONObject("graphql");
                    JSONObject objectMedia = objectGraphql.getJSONObject("shortcode_media");
                    boolean isVideo = objectMedia.getBoolean("is_video");
                    String singleLink = null;

                    if (isVideo) {
                        singleLink = objectMedia.getString("video_url");
                    } else {
                        singleLink = objectMedia.getString("display_url");
                    }
                    Log.d("@@@@",singleLink);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                Log.d("@@@@","jsonObject "+jsonObject);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("@@@@", "v "+error.getMessage());
            }
        });

        queue.add(stringRequest);

    }
}
