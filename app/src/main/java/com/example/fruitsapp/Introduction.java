package com.example.fruitsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

import com.airbnb.lottie.LottieAnimationView;

public class Introduction extends AppCompatActivity {
    Timer timer;

    ImageView bg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Introduction.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

        bg = findViewById(R.id.imgbg);
        lottieAnimationView = findViewById(R.id.animation);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

    }
}