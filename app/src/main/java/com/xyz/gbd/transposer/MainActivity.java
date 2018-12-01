package com.xyz.gbd.transposer;
import java.lang.Object;
import android.os.Parcelable.Creator;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
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
    }
    public interface Parcelable {
        public class MyParcelable implements Parcelable {
            private int mData;

            public int describeContents() {
                return 0;
            }
            public void writeToParcel(Parcel out, int flags) {
                out.writeInt(mData);
            }
            public static final Parcelable.Creator<MyParcelable> CREATOR
                    = new Parcelable.Creator<MyParcelable>() {
                public MyParcelable createFromParcel(Parcel in) {
                    return MyParcelable(in);
                }
                public MyParcelable[] newArray(int size) {
                    return MyParcelable[size];
                }
            } ;
            private MyParcelable(Parcel in) {
                mData = in.readInt();
            }
        }
    }
    /*
    For reference
    "https://developer.android.com/reference/android/view/DragEvent"
     */
    public class  DragEvent extends Object implements Parcelable {
        public static final int ACTION_DRAG_STARTED;
        public static final int ACTION_DRAG_DROP;
        public static final int ACTION_DRAG_ENDED;
        public static final int ACTION_DRAG_ENTERED;
        public static final int ACTION_DRAG_EXITED;
        public static final int ACTION_DRAG_LOCATION;
        public int describeContents() {
            return
        }
        public int getAction() {
            return
        }
        public float getY() {
            return
        }
        
    }
}

