package com.xyz.gbd.transposer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    ImageView iv = (ImageView) findViewById(R.id.staff);
}
