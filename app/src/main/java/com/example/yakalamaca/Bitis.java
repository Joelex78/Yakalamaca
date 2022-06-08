package com.example.yakalamaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Bitis extends AppCompatActivity {

    TextView sonPuan;
    int puan;
    int enyuksekpuan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitis);

        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        sonPuan = findViewById(R.id.sonPuan);

        Intent intent = getIntent();
        puan = intent.getExtras().getInt("skor");



        sonPuan.setText("Puan: " + puan );


    }


    public void anamenu(View view) {
        Intent intent = new Intent(Bitis.this,MainActivity.class);
        startActivity(intent);
    }

}