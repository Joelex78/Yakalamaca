package com.example.yakalamaca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LevelScreen extends AppCompatActivity {

    ImageButton imageButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_screen);

        imageButton = findViewById(R.id.FirstImage);
    }

    public void firstSelect (View view) {
        int level = 1;
        Intent intent = new Intent(LevelScreen.this,Oyun.class);
        intent.putExtra("seviye",level);
        startActivity(intent);
    }


    public void secondSelect (View view) {
        int level = 2;
        Intent intent = new Intent(LevelScreen.this,Oyun.class);
        intent.putExtra("seviye",level);
        startActivity(intent);
    }


    public void thirdSelect (View view) {
        int level = 3;
        Intent intent = new Intent(LevelScreen.this,Oyun.class);
        intent.putExtra("seviye",level);
        startActivity(intent);
    }


}