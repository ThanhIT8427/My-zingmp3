package com.example.zingmp3.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zingmp3.Adapter.albumadt;
import com.example.zingmp3.Model.Album;
import com.example.zingmp3.R;
import com.example.zingmp3.Sevice.APIService;
import com.example.zingmp3.Sevice.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_album extends Fragment {
    View view;
    TextView txtseemore;
    RecyclerView rcvalbum;
    ArrayList<Album> listalbum;
    albumadt albumadapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_album,container,false);
        txtseemore=(TextView) view.findViewById(R.id.txtalbumtitle);
        rcvalbum=(RecyclerView) view.findViewById(R.id.rcvalbum);
        listalbum=new ArrayList<>();
        getdataalbum();
        return view;
    }
    private void getdataalbum(){
        Dataservice dataservice= APIService.getservice();
        Call<List<Album>> call=dataservice.getalbum();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                listalbum= (ArrayList<Album>) response.body();
                albumadapter=new albumadt(getActivity());
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
                rcvalbum.setLayoutManager(linearLayoutManager);
                albumadapter.setlist(listalbum);
                rcvalbum.setAdapter(albumadapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
