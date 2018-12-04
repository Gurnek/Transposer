package com.xyz.gbd.transposer;
import java.io.File;
import java.lang.Object;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable.Creator;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {
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
        /**
        File noteImage = new File("/Users/danielgleason/StudioProjects/Transposer/app/src/main/res/drawable/wholenote.png");
        Bitmap noteBitmap = BitmapFactory.decodeFile(noteImage.getAbsolutePath());
        ImageView noteImageView = findViewById(R.id.wholenote);
        noteImageView.setImageBitmap(noteBitmap);
         */
    }
}