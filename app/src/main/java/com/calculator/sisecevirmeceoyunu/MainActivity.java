package com.calculator.sisecevirmeceoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnOyunaBaşla;
    private Button btnSorusuzOyunaBaşla;
    private Button btnSoruEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /** View'ların bağlama işlemleri */
        btnOyunaBaşla = findViewById(R.id.btnOyunEkranınaGeç);
        btnSorusuzOyunaBaşla = findViewById(R.id.btnSorusuzOyunaBaşla);
        btnSoruEkle = findViewById(R.id.btnSoruEkle);


        btnSorusuzOyunaBaşla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, sorusuz_oyun_ekrani.class);
                startActivity(intent);
            }
        });

        btnOyunaBaşla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, normalGameScreen.class);
                startActivity(intent);
            }
        });

        btnSoruEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, soru_ekleme.class);
                startActivity(intent);
            }
        });

    }
}
