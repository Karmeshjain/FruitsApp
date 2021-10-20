package com.example.fruitsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Introduction extends AppCompatActivity {

    ImageView bg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        bg = findViewById(R.id.imgbg);
        lottieAnimationView = findViewById(R.id.animation);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

    }
}