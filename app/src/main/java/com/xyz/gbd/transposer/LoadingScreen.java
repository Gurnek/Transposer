package com.xyz.gbd.transposer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoadingScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        //Animation to fade in sum stuff
        final Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(3000);

        TextView logo = findViewById(R.id.logo);
        logo.startAnimation(fadeIn);

        TextView instructions = findViewById(R.id.instructions);
        instructions.startAnimation(fadeIn);
    }

    public void switchScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
