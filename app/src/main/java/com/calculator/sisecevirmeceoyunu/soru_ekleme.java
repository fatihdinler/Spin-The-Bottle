package com.calculator.sisecevirmeceoyunu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class soru_ekleme extends AppCompatActivity {

    private Button btnSoruEkle;
    private EditText editTextDoğrulukSorusuEkle, editTextCesaretlikSorusuEkle;
    private View rectangle;

    normalGameScreen normalGameScreenObjesi = new normalGameScreen();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru_ekleme);

        /** Viewların bağlama işlemleri */
        btnSoruEkle = findViewById(R.id.btnSoruyuKaydet);
        editTextDoğrulukSorusuEkle = findViewById(R.id.editTextDoğrulukSorusuEkle);
        editTextCesaretlikSorusuEkle = findViewById(R.id.editTextTextCesaretlikSorusuEkle);
        rectangle = findViewById(R.id.rectangle);

        /** setAlpha ile question editText arkasındaki rectangle'ın saydamlığını arttırdım. */
        rectangle.setAlpha(0.7f);

        /** Snackbar kullanabilmek için current layout rootView gerekir. */
        View rootView = getWindow().getDecorView().getRootView();

        /** Bu activity her çalıştığında aşağıda bir snackbar göreceğim. */
        Snackbar snackbar = Snackbar.make(rootView, "Lütfen sadece bir soru yazın.", Snackbar.LENGTH_LONG);
        snackbar.show();

        btnSoruEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!editTextDoğrulukSorusuEkle.getText().toString().matches("") && editTextCesaretlikSorusuEkle.getText().toString().matches("")) {
                    String gelenDoğrulukSorusu = editTextDoğrulukSorusuEkle.getText().toString();
                    normalGameScreenObjesi.diğerSınıftanGelenDoğrulukSorularınıEkle(gelenDoğrulukSorusu);
                    editTextDoğrulukSorusuEkle.setText("");
                    Toast.makeText(getApplicationContext(), "Sorunuz Kaydedildi !", Toast.LENGTH_SHORT).show();
                }

                else if(editTextDoğrulukSorusuEkle.getText().toString().matches("") && !editTextCesaretlikSorusuEkle.getText().toString().matches("")) {
                    String gelenCesaretlikSorusu = editTextCesaretlikSorusuEkle.getText().toString();
                    normalGameScreenObjesi.diğerSınıftanGelenCesaretlikSorularınıEkle(gelenCesaretlikSorusu);
                    editTextCesaretlikSorusuEkle.setText("");
                    Toast.makeText(getApplicationContext(), "Sorunuz Kaydedildi !", Toast.LENGTH_SHORT).show();
                }

                else if (editTextDoğrulukSorusuEkle.getText().toString().matches("") && editTextCesaretlikSorusuEkle.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Lütfen herhangi bir soru yazın !", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(getApplicationContext(), "Lütfen soruları birer birer yazın !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}