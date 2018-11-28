package com.xyz.gbd.transposer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playSong(View view) {
        if (mp == null) {
            mp = MediaPlayer.create(this, R.raw.undertale);
        } else if (mp.isPlaying()) {
            mp.release();
            mp = MediaPlayer.create(this, R.raw.undertale);
        }
        mp.start();
    }
}
