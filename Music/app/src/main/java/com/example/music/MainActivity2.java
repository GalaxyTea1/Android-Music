package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayList<String> ds = listRaw();
        Button btMS1 = (Button) findViewById(R.id.bt1);
        Button btMS2 = (Button) findViewById(R.id.bt2);
        Button btMS3 = (Button) findViewById(R.id.bt3);
        String[] arr = getResources().getStringArray(R.array.name_music);
        btMS1.setText(arr[0]);
        btMS2.setText(arr[1]);
        btMS3.setText(arr[2]);
    }
    public ArrayList<String> listRaw(){
        ArrayList<String> res = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length ; ++i){
            System.out.println(fields[i].getName());
            res.add(fields[i].getName().toString());
        }
        return  res;
    }

    public void doChoose1(View view){

        Intent intent = new Intent();
        intent.putExtra("choose", 1);
        setResult(RESULT_OK, intent);
        finish();
    }
    public void doChoose2(View view){
        Intent intent = new Intent();
        intent.putExtra("choose", 2);
        setResult(RESULT_OK, intent);
        finish();
    }
    public void doChoose3(View view){
        Intent intent = new Intent();
        intent.putExtra("choose", 3);
        setResult(RESULT_OK, intent);
        finish();
    }
}