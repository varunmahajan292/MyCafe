package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
    ImageView imageView;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=(ImageView)findViewById(R.id.imageView1);
        Animation an2= AnimationUtils.loadAnimation(this,R.anim.move);
        imageView.startAnimation(an2);
        MediaPlayer ring= MediaPlayer.create(splash.this,R.raw.sound2);
        ring.start();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent=new Intent(splash.this,StartingActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }

}
