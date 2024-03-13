package com.software.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView btnplay,btnpause,btnstop;
    boolean playing =false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnplay=findViewById(R.id.btnplay);
        btnpause=findViewById(R.id.btnpause);
        btnstop=findViewById(R.id.btnstop);

        final MediaPlayer mp=MediaPlayer.create(MainActivity.this , R.raw.tone);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!playing){
                    mp.start();
                    playing=true;
                }
            }
        });
        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playing){
                    mp.pause();
                    playing=false;
                }
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playing){
                    mp.stop();
                    playing=false;
                }
            }
        });

    }
}