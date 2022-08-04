package com.calculator.sisecevirmeceoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class splash_screen extends AppCompatActivity {

    private ImageView bottle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /** The bottle */
        bottle = findViewById(R.id.bottle);

        /** Call the function rotateBottle() just before the handler. */
        rotateBottle(bottle);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splash_screen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
            /** It waits for 6 seconds. Rotating tooks 5 seconds. It means that
             * when rotating is done, wait for 1 seconds and go to MainActivity. */
        }, 6*1000);
    }

    /** This method is rotating the given image for 5 seconds with 1799 degrees. */
    public void rotateBottle(ImageView image) {
        image.animate().rotation(1799f).setDuration(5000).start();
    }
}