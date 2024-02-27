package com.example.aec_04_wallpaer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startBtn,stopBtn;
    ImageView imgImage;
    TextView imgText,clickstatbutton;
    Random rand;
    Runnable runnable;
    Handler handler;
    boolean IMAGE_FLAG = true;

    int[] IMAGES = {
            R.drawable.carone, R.drawable.cartwo, R.drawable.carthree,
            R.drawable.penone, R.drawable.pentwo, R.drawable.penthree,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
        handleBTNStart();
        handleBTNStop();
    }

    public void initializer(){
        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);
        imgImage = findViewById(R.id.imgImage);
        imgText = findViewById(R.id.imgText);
        clickstatbutton = findViewById(R.id.clickstatbutton);
        rand = new Random();
        handler = new Handler();


    }
    public void handleBTNStart(){
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wallpaper Started", Toast.LENGTH_SHORT).show();
//                int randIndex = rand.nextInt(6);
                imgText.setVisibility(View.GONE);
                clickstatbutton.setVisibility(View.GONE);
                imgImage.setVisibility(View.VISIBLE);
                startBtn.setVisibility(View.GONE);
                stopBtn.setVisibility(View.VISIBLE);
                oneSecondRunner();
//                imgImage.setImageResource(IMAGES[randIndex]);

            }
        });
    }
    public void handleBTNStop(){
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wallpaper ENDS", Toast.LENGTH_SHORT).show();
                stopBtn.setVisibility(View.GONE);
                startBtn.setVisibility(View.VISIBLE);
                handler.removeCallbacks(runnable);
            }
        });
    }
    public void oneSecondRunner(){

            runnable = new Runnable() {
            @Override
            public void run() {
                int randIndex = rand.nextInt(6);
                imgImage.setImageResource(IMAGES[randIndex]);
                handler.postDelayed(this,3000);

            }
        };
        handler.postDelayed(runnable,3000);
    }
}