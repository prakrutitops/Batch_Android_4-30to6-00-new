package com.example.playvideofromserverwithvideoview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity 
{

    String url="http://10.0.2.2/digitalsociety/vid.mp4";
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView=findViewById(R.id.videoView);
        try {
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            Uri video = Uri.parse(url);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(video);
            videoView.start();
        } catch (Exception e) {
            // TODO: handle exception
            Toast.makeText(this, "Error connecting", Toast.LENGTH_SHORT).show();
        }
    }
}
