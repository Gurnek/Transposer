package com.xyz.gbd.transposer;
import jm.JMC;
import jm.music.data.Note;
import jm.util.Play;

import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import jm.JMC.*;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView sans1;
    ImageView sans2;
    ImageView wholeNote;
    ImageView noteFlat;
    ImageView noteSharp;
    ImageView staff;
    Spinner end;
    Spinner begin;
    public float stepSize;
    private long startTime = 0;
    private int distFromCenter = 0;
    protected final int MAX_STEPS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        begin = findViewById(R.id.original_key);
        end = findViewById(R.id.transpose_key);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.key_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        begin.setAdapter(adapter);
        end.setAdapter(adapter);

        wholeNote = findViewById(R.id.wholenote);
        wholeNote.setOnTouchListener(this);
        noteFlat = findViewById(R.id.noteflat);
        noteSharp = findViewById(R.id.notesharp);
        staff = findViewById(R.id.staff);

        wholeNote.setOnTouchListener(this);
        wholeNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateAccidental();
            }
        });

        begin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setKey(begin.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        setKey("C");
        staff = findViewById(R.id.staff);
        sans1 = findViewById(R.id.sans1);
        sans2 = findViewById(R.id.sans2);
        sans1.setAlpha(0.0f);
        sans2.setAlpha(0.0f);
    }

    public static void playnotes(String[] noteSounds) {
        Note note = new Note();
        note.setPitch(JMC.PITCH);
        note.setDynamic(JMC.FF);
        note.setDuration(JMC.HALF_NOTE);
        Play.midi(note);
    }

    public void onTransposeClicked(View view) {
        setKey(end.getSelectedItem().toString());
        int stepsToMove = Transposer.transposeNote(Transposer.getSteps(begin.getSelectedItem().toString(), end.getSelectedItem().toString()), distFromCenter);
        setNoteComponentY(wholeNote.getY() + stepSize * stepsToMove);
    }

    private void snapY() {
        stepSize = Math.abs(sans1.getY() - sans2.getY()) / 2;
        float centerStaffY = sans1.getY() +;
        float dist = wholeNote.getY() - centerStaffY;
        int stepsAway = Math.round(dist / stepSize);
        distFromCenter = -1 * stepsAway;
        setNoteComponentY(centerStaffY + stepsAway * stepSize);
    }

    private String getNote() {
        return "";
    }

    private void setKey(String currentKey) {
        switch (currentKey) {
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
            String id = flats[i] + "flat";
            int currentFlat = getResources().getIdentifier(id, "id", "com.xyz.gbd.transposer");
            ImageView thisFlat = findViewById(currentFlat);
            thisFlat.setVisibility(View.VISIBLE);
        }
        for (int i = numFlats; i < 7; i++) {
            String id = flats[i] + "flat";
            int currentFlat = getResources().getIdentifier(id, "id", "com.xyz.gbd.transposer");
            ImageView thisFlat = findViewById(currentFlat);
            thisFlat.setVisibility(View.GONE);
        }
    }

    private void changeSharps(int numSharps) {
        String[] sharps = new String[] {"f", "c", "g", "d", "a", "e", "b"};
        for (int i = 0; i < numSharps; i++) {
            String id = sharps[i] + "sharp";
            int currentSharp = getResources().getIdentifier(id, "id", "com.xyz.gbd.transposer");
            ImageView thisSharp = findViewById(currentSharp);
            thisSharp.setVisibility(View.VISIBLE);
        }
        for (int i = numSharps; i < 7; i++) {
            String id = sharps[i] + "sharp";
            int currentSharp = getResources().getIdentifier(id, "id", "com.xyz.gbd.transposer");
            ImageView thisSharp = findViewById(currentSharp);
            thisSharp.setVisibility(View.GONE);
        }
    }

    private void rotateAccidental() {
        if (noteSharp.getVisibility() == View.INVISIBLE && noteFlat.getVisibility() == View.INVISIBLE) {
            noteSharp.setVisibility(View.VISIBLE);
        } else if (noteSharp.getVisibility() == View.VISIBLE && noteFlat.getVisibility() == View.INVISIBLE) {
            noteSharp.setVisibility(View.INVISIBLE);
            noteFlat.setVisibility(View.VISIBLE);
        } else if (noteSharp.getVisibility() == View.INVISIBLE && noteFlat.getVisibility() == View.VISIBLE) {
            noteSharp.setVisibility(View.INVISIBLE);
            noteFlat.setVisibility(View.INVISIBLE);
        } else {
            Log.e("Accidental problem: ", "Accidental combo not expected!");
        }
    }

    private void setNoteComponentY(float y) {
        wholeNote.setY(y);
        noteSharp.setY(y);
        noteFlat.setY(y);
    }

    private boolean moving = false;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int maxTime = 200;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moving = true;
                startTime = Calendar.getInstance().getTimeInMillis();
                break;
            case MotionEvent.ACTION_MOVE:
                if (moving) {
                    float y = event.getRawY() - wholeNote.getHeight() * 3 / 2;
                    setNoteComponentY(y);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Calendar.getInstance().getTimeInMillis() - startTime < maxTime) {
                    rotateAccidental();
                }
                snapY();
                Log.e("Distfromcenter: ", Integer.toString(distFromCenter));
                moving = false;
                break;
        }
        return true;
    }
}

