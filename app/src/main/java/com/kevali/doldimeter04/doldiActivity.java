package com.kevali.doldimeter04;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by defaultuser0 on 09/08/2016.
 */
public class doldiActivity extends AppCompatActivity{

    MediaPlayer grosserBruder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doldi);
        grosserBruder = MediaPlayer.create(this, R.raw.grosserbruder);
        grosserBruder.start();
    }
}
