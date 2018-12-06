package com.xyz.gbd.transposer;

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
    }

    private float snapY(float rawY) {
        return 0;
    }

    private void setKey(String currentKey) {
        String key = currentKey;
        switch (key) {
            case "C" :
                changeFlats(0);
                changeSharps(0);
                break;
            case "F" :
                changeFlats(1);
                changeSharps(0);
                break;
            case "Bb" :
                changeFlats(2);
                changeSharps(0);
                break;
            case "Eb" :
                changeFlats(3);
                changeSharps(0);
                break;
            case "Ab" :
                changeFlats(4);
                changeSharps(0);
                break;
            case "Db" :
                changeFlats(5);
                changeSharps(0);
                break;
            case "Gb" :
                changeFlats(6);
                changeSharps(0);
                break;
            case "Cb" :
                changeFlats(7);
                changeSharps(0);
                break;
            case "G" :
                changeFlats(0);
                changeSharps(1);
                break;
            case "D" :
                changeFlats(0);
                changeSharps(2);
                break;
            case "A" :
                changeFlats(0);
                changeSharps(3);
                break;
            case "E" :
                changeFlats(0);
                changeSharps(4);
                break;
            case "B" :
                changeFlats(0);
                changeSharps(5);
                break;
            case "F#" :
                changeFlats(0);
                changeSharps(6);
                break;
            case "C#" :
                changeFlats(0);
                changeSharps(7);
                break;
        }

    }

    private void changeFlats(int numFlats) {
        String[] flats = new String[]{"b", "e", "a", "d", "g", "c", "f"};
        for (int i = 0; i < numFlats; i++) {
            String id = "@+id/" + flats[i] + "flat";
            int currentFlat = getResources().getIdentifier(id, "layout", null);
            ImageView thisFlat = findViewById(currentFlat);
            thisFlat.setVisibility(View.VISIBLE);
        }
        for (int i = numFlats; i < 7; i++) {
            String id = "@+id/" + flats[i] + "flat";
            int currentFlat = getResources().getIdentifier(id, "layout", null);
            ImageView thisFlat = findViewById(currentFlat);
            thisFlat.setVisibility(View.GONE);
        }
    }

    private void changeSharps(int numSharps) {
        String[] sharps = new String[] {"f", "c", "g", "d", "e", "a", "b"};
        for (int i = 0; i < numSharps; i++) {
            String id = "@+id/" + sharps[i] + "sharp";
            int currentSharp = getResources().getIdentifier(id, "layout", null);
            ImageView thisSharp = findViewById(currentSharp);
            thisSharp.setVisibility(View.VISIBLE);
        }
        for (int i = numSharps; i < 7; i++) {
            String id = "@+id/" + sharps[i] + "sharp";
            int currentSharp = getResources().getIdentifier(id, "layout", null);
            ImageView thisSharp = findViewById(currentSharp);
            thisSharp.setVisibility(View.GONE);
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
                    //First: store note's initial position as a float
                    //float notePos = wholeNote.getY();
                    //Second: constantly update a float with the cursor's position
                    float y = event.getRawY() - wholeNote.getHeight() * 3 / 2;
                    //Third: Constantly check if the cursor's pos is 20 or more different than note
                    /**
                     if (Math.abs(notePos - y) >= 20) {
                     //Fourth: if it is, move the note and set the new position as step 1
                     if (y > notePos) {
                     wholeNote.setY(notePos + 20);
                     notePos += 20;
                     } else {
                     wholeNote.setY(notePos - 20);
                     notePos -= 20;
                     }
                     }
                     */
                    wholeNote.setY(y);
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.e("noteCheck", "Raw y: " + event.getRawY());
                Log.e("posCheck", "Modified height: " + (wholeNote.getHeight() * 3 / 2));
                Log.e("endCheck", "Combined ending pos = : " + (event.getRawY() - wholeNote.getHeight() * 3 / 2));
                moving = false;
                break;
        }
        return true;
    }
}

