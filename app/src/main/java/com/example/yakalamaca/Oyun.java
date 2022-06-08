package com.example.yakalamaca;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Oyun extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    int puan;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;

    Handler handler;
    Runnable runnable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);


        timeText = (TextView) findViewById(R.id.timeText);
        scoreText = (TextView) findViewById(R.id.scoreText);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[] {imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};


        hideImages();

        puan = 0;

        new CountDownTimer(10000,1000) {

            @Override
            public void onTick(long l) {
                timeText.setText("Time: " + l/1000);
            }

            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);

                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }

                Intent intent = new Intent(Oyun.this,Bitis.class);
                intent.putExtra("skor",puan);
                finish();
                startActivity(intent);
            }
        }.start();
    }

    public void puanArttir (View view) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.hit_hurt);
        mediaPlayer.start();
        puan++;
        scoreText.setText("Puan: " + puan);

    }



    public void hideImages() {

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = getIntent();
                int seviye = intent.getExtras().getInt("seviye");

                ConstraintLayout constraintLayout = findViewById(R.id.constraintlayout);

                if (seviye == 1) {
                    constraintLayout.setBackgroundResource(R.drawable.southparkbackground);
                    for (ImageView image : imageArray) {
                        image.setImageResource(R.drawable.kenny);
                        image.setVisibility(View.INVISIBLE);
                    }
                }

                else if (seviye == 2) {
                    constraintLayout.setBackgroundResource(R.drawable.ram);
                    for (ImageView image : imageArray) {
                        image.setImageResource(R.drawable.morty);
                        image.setVisibility(View.INVISIBLE);
                    }
                }

                else if (seviye == 3) {
                    constraintLayout.setBackgroundResource(R.drawable.frozen);
                    for (ImageView image : imageArray) {
                        image.setImageResource(R.drawable.elsa);
                        image.setVisibility(View.INVISIBLE);
                    }
                }


                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);
            }
        };

        handler.post(runnable);

    }


}