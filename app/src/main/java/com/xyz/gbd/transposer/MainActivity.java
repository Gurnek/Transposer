package com.xyz.gbd.transposer;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView wholeNote;
    ImageView staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner begin = findViewById(R.id.original_key);
        Spinner end = findViewById(R.id.transpose_key);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.key_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        begin.setAdapter(adapter);
        end.setAdapter(adapter);

        wholeNote = findViewById(R.id.wholenote);
        wholeNote.setOnTouchListener(this);
        staff = findViewById(R.id.staff);
    }

    private float snapY() {
        int staffHeight = staff.getHeight();
        float staffY = staff.getY();
        float wholeNoteY = wholeNote.getY();
        float percentDown = (wholeNoteY - staffY) / staffHeight;
        if (Math.ceil(percentDown / 0.07) - (percentDown / 0.07) > Math.floor(percentDown / 0.07) - (percentDown / 0.07)) {
            return (float) (staffHeight * Math.ceil(percentDown / 0.07) / 100 + staffY);
        } else {
            return (float) (staffHeight * Math.floor(percentDown / 0.07) / 100 + staffY);
        }
    }

    private boolean moving = false;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moving = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (moving) {
                    double y = event.getRawY() - wholeNote.getHeight() * 3 / 2;
                    wholeNote.setY((float) y);
                }
                break;
            case MotionEvent.ACTION_UP:
                moving = false;
                wholeNote.setY(snapY());
                Log.d("Fucking bitchwad", Float.toString(wholeNote.getY()));
                break;
        }
        return true;
    }
}

