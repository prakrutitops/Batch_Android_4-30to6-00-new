package com.example.playvideofromserverwithmediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    String url="http://10.0.2.2/digitalsociety/vid.mp4";
    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder holder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView=findViewById(R.id.surfaceView);
        mediaPlayer=new MediaPlayer();
        holder = surfaceView.getHolder();
        holder.setFixedSize(800, 480);
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mediaPlayer.setDisplay(holder);
        play();
    }

    private void play() {
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
