package com.example.zingmp3.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zingmp3.Model.Advertex;
import com.example.zingmp3.Model.Likedsong;
import com.example.zingmp3.Adapter.listsong;
import com.example.zingmp3.Model.Playlistcurrentday;
import com.example.zingmp3.R;
import com.example.zingmp3.Sevice.APIService;
import com.example.zingmp3.Sevice.Dataservice;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListsongadActivity extends AppCompatActivity {
    Advertex advertex;
    ArrayList<Likedsong> listsong;
    CoordinatorLayout coordinatorLayout;
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    ImageView imglistsongad;
    FloatingActionButton floatingActionButton;
    NestedScrollView nestedScrollView;
    RecyclerView recyclerView;
    listsong listsongadt;
    Playlistcurrentday playlistcurrentday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listsongad);
        Getdataad();
        Getdataplaylist();
        anhxa();
        init();
        if(advertex!=null&&!advertex.getAdid().trim().equals("")){
            setvalue(advertex);
            getlistsongad(advertex);
        }
        if(playlistcurrentday!=null&&!playlistcurrentday.getPlaylistname().trim().equals("")){
            setvalueplaylist(playlistcurrentday);
            getlistsongplaylist(playlistcurrentday);
        }
        transmitlistsong();
    }


    private void setvalue(Advertex a) {
        collapsingToolbarLayout.setTitle(a.getSongname());
        try {
            URL url=new URL(a.getAdimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/"));
            Bitmap bitmap= BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable= null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
                bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Picasso.with(this).load(a.getAdimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(imglistsongad);
    }
    private void getlistsongad(Advertex a){
        Dataservice dataservice= APIService.getservice();
        Call<List<Likedsong>> callback=dataservice.getlistadsong(Integer.parseInt(a.getAdid()));
        callback.enqueue(new Callback<List<Likedsong>>() {
            @Override
            public void onResponse(Call<List<Likedsong>> call, Response<List<Likedsong>> response) {
                listsong= (ArrayList<Likedsong>) response.body();
                listsongadt=new listsong(ListsongadActivity.this,listsong);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ListsongadActivity.this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(listsongadt);
            }

            @Override
            public void onFailure(Call<List<Likedsong>> call, Throwable t) {

            }
        });

    }
    private void setvalueplaylist(Playlistcurrentday a){

        collapsingToolbarLayout.setTitle(a.getPlaylistname());
        try {
            URL url=new URL(a.getPlaylistbg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/"));
            Bitmap bitmap=BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable=new BitmapDrawable(getResources(),bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(a.getPlaylistimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(imglistsongad);

    }
    private void getlistsongplaylist(Playlistcurrentday a){
        Dataservice data=APIService.getservice();
        Call<List<Likedsong>> call=data.getlistplaylistsong(Integer.parseInt(a.getPlaylistid()));
        call.enqueue(new Callback<List<Likedsong>>() {
            @Override
            public void onResponse(Call<List<Likedsong>> call, Response<List<Likedsong>> response) {
                listsong= (ArrayList<Likedsong>) response.body();
                listsongadt=new listsong(ListsongadActivity.this,listsong);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ListsongadActivity.this,RecyclerView.VERTICAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(listsongadt);
            }

            @Override
            public void onFailure(Call<List<Likedsong>> call, Throwable t) {

            }
        });
    }
    private void init(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }
    private void Getdataad(){
        Intent intent= getIntent();
        if(intent.hasExtra("advertices")){
            advertex= (Advertex) intent.getSerializableExtra("advertices");
            Log.d("A",advertex.getSongname());
        }
    }
    private void Getdataplaylist(){
        Intent intent=getIntent();
        playlistcurrentday= (Playlistcurrentday) intent.getSerializableExtra("playlist");

    }
    private void anhxa(){
        coordinatorLayout =(CoordinatorLayout) findViewById(R.id.coordinatorLO);
        appBarLayout=(AppBarLayout) findViewById(R.id.appbar);
        toolbar=(Toolbar) findViewById(R.id.toolbarlist);
        imglistsongad=(ImageView) findViewById(R.id.imglistsongad);
        floatingActionButton=(FloatingActionButton) findViewById(R.id.btnfloatingaction);
        nestedScrollView=(NestedScrollView) findViewById(R.id.nestedSV);
        recyclerView=(RecyclerView) findViewById(R.id.rcvlistsongad);
        collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.collapsing);
        floatingActionButton.setEnabled(false);
    }
    private void transmitlistsong(){
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ListsongadActivity.this,PlayMusic.class);
                intent.putExtra("listsong",listsong);
                startActivity(intent);
            }
        });
    }
}