package com.example.music;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;
    int index = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        index = 1;
        TextView textView = (TextView) findViewById(R.id.nameMusic);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        textView.startAnimation(animation);
    }

    public void doOpenList(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        if (mediaPlayer != null) mediaPlayer.stop();
        startActivityForResult(intent, 1);
    }

    public void doNext(View view) {
        String[] arr = getResources().getStringArray(R.array.name_music);
        if (mediaPlayer != null) mediaPlayer.stop();
        if (index < 3) {
            index++;
            if (index == 2) {
                getWindow().setBackgroundDrawableResource(R.drawable.bgmot);
                mediaPlayer = MediaPlayer.create(this, R.raw.music2);
                TextView textView = (TextView) findViewById(R.id.nameMusic);
                textView.setText(arr[1]);
                mediaPlayer.start();
            } else if (index == 3) {
                getWindow().setBackgroundDrawableResource(R.drawable.bghai);
                mediaPlayer = MediaPlayer.create(this, R.raw.music1);
                TextView textView = (TextView) findViewById(R.id.nameMusic);
                textView.setText(arr[2]);
                mediaPlayer.start();
            }
        } else {
        }
    }

    public void doPrev(View view) {
        String[] arr = getResources().getStringArray(R.array.name_music);
        if (mediaPlayer != null) mediaPlayer.stop();
        if (index > 1) {
            index--;
            if (index == 2) {
                getWindow().setBackgroundDrawableResource(R.drawable.bgmot);
                mediaPlayer = MediaPlayer.create(this, R.raw.music2);
                TextView textView = (TextView) findViewById(R.id.nameMusic);
                textView.setText(arr[1]);
                mediaPlayer.start();
            } else if (index == 1) {
                getWindow().setBackgroundDrawableResource(R.drawable.bg);
                mediaPlayer = MediaPlayer.create(this, R.raw.music1);
                TextView textView = (TextView) findViewById(R.id.nameMusic);
                textView.setText(arr[0]);
                mediaPlayer.start();
            }
        }
    }


    public void doThoat(View view) {
        finish();
    }

    public void doPlay(View v) {
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public void doPause(View v) {
       if(mediaPlayer != null) mediaPlayer.pause();
    }

    public void doStop(View v) {
        if(mediaPlayer != null) mediaPlayer.stop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String[] arr = getResources().getStringArray(R.array.name_music);
        if (resultCode == RESULT_OK && requestCode == 1) {
            int choose = data.getIntExtra("choose", 0);
            if (choose == 1) {
                index = 1;
                mediaPlayer = MediaPlayer.create(this, R.raw.music1);
                TextView textView = (TextView) findViewById(R.id.nameMusic);
                textView.setText(arr[0]);
                getWindow().setBackgroundDrawableResource(R.drawable.bg);
                mediaPlayer.start();
            } else if (choose == 2) {
                index = 2;
                mediaPlayer = MediaPlayer.create(this, R.raw.music2);
                TextView textView = (TextView) findViewById(R.id.nameMusic);
                textView.setText(arr[1]);
                getWindow().setBackgroundDrawableResource(R.drawable.bgmot);
                mediaPlayer.start();
            } else {
                index = 3;
                mediaPlayer = MediaPlayer.create(this, R.raw.music1);
                TextView textView = (TextView) findViewById(R.id.nameMusic);
                textView.setText(arr[2]);
                getWindow().setBackgroundDrawableResource(R.drawable.bghai);
                mediaPlayer.start();
            }
        } else {

        }
    }
}