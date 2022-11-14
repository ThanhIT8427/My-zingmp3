package com.example.zingmp3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.zingmp3.Model.Playlistcurrentday;
import com.example.zingmp3.R;
import com.example.zingmp3.Adapter.allplaylistadt;
import com.example.zingmp3.Sevice.APIService;
import com.example.zingmp3.Sevice.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Allplaylist extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    allplaylistadt allplaylistadt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allplaylist);
        recyclerView=(RecyclerView) findViewById(R.id.rcvallplaylist);
        toolbar=(Toolbar) findViewById(R.id.toolbarallplaylist);
        setlayoutallplaylist();
        getdataallplaylist();
    }
    private void setlayoutallplaylist(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play list");
        toolbar.setTitleTextColor(getResources().getColor(R.color.purple));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void getdataallplaylist(){
        Dataservice dataservice= APIService.getservice();
        Call<List<Playlistcurrentday>> call=dataservice.getallplaylist();
        call.enqueue(new Callback<List<Playlistcurrentday>>() {
            @Override
            public void onResponse(Call<List<Playlistcurrentday>> call, Response<List<Playlistcurrentday>> response) {
                ArrayList<Playlistcurrentday> listallplaylist= (ArrayList<Playlistcurrentday>) response.body();
                allplaylistadt=new allplaylistadt(Allplaylist.this,listallplaylist);
                recyclerView.setLayoutManager(new GridLayoutManager(Allplaylist.this,2));
                recyclerView.setAdapter(allplaylistadt);
            }

            @Override
            public void onFailure(Call<List<Playlistcurrentday>> call, Throwable t) {

            }
        });
    }
}