package com.example.zingmp3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.zingmp3.Model.Likedsong;
import com.example.zingmp3.R;

import java.util.ArrayList;

public class PlayMusic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Intent intent=getIntent();
        if(intent.hasExtra("listsong")){
            ArrayList<Likedsong> listsong=intent.getParcelableArrayListExtra("listsong");
            for(int i=0;i<listsong.size();i++){
                Log.d("List",listsong.get(i).getSongname());
            }
        }
        if(intent.hasExtra("baihat")){
            Likedsong a=new Likedsong();
            a=intent.getParcelableExtra("baihat");
            Log.d("Baihat",a.getSongname());
        }
    }
}