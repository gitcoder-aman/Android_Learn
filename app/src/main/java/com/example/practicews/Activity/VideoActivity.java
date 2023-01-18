package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.practicews.R;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);

        String vPath = "android.resource://"+getPackageName()+"/raw/videoplay";
        String onlineVideoPath = "http://techslides.com/demos/sample-videos/small.webm";

        Uri videoURI = Uri.parse(vPath);
        Uri onlineVideoURI = Uri.parse(onlineVideoPath);

//        videoView.setVideoPath(vPath);
        videoView.setVideoURI(videoURI);
        videoView.start();

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }
}