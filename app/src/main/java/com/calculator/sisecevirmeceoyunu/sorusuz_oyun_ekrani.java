package com.calculator.sisecevirmeceoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class sorusuz_oyun_ekrani extends AppCompatActivity {

    private ImageView bottle;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorusuz_oyun_ekrani);

        bottle = findViewById(R.id.bottleSorusuzEkran);

        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateTheBottle(bottle);
            }
        });
    }
    public void rotateTheBottle(ImageView view) {
        int randomNumber = random.nextInt(1800);
        Log.e("rotated" , String.valueOf(1800 - randomNumber));
        view.animate().rotation(1800 - randomNumber).setDuration(3000).start();
    }
}