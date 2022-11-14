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

import com.example.zingmp3.Adapter.likedsongadt;
import com.example.zingmp3.Model.Likedsong;
import com.example.zingmp3.R;
import com.example.zingmp3.Sevice.APIService;
import com.example.zingmp3.Sevice.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_likedsong extends Fragment {
    View view;
    ArrayList<Likedsong> listlikedsong;
    RecyclerView rcvlikedsong;
    TextView txtlikedsongseemore;
    likedsongadt likedsongadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.fragment_likedsong,container,false);
       rcvlikedsong=(RecyclerView) view.findViewById(R.id.rcvlikedsong);
       txtlikedsongseemore=(TextView) view.findViewById(R.id.txtlikedsongseemore);
       listlikedsong=new ArrayList<>();
       getdatalikedsong();
       return view;
    }
    private void getdatalikedsong(){
        Dataservice dataservice= APIService.getservice();
        Call<List<Likedsong>> call=dataservice.getlikedsong();
        call.enqueue(new Callback<List<Likedsong>>() {
            @Override
            public void onResponse(Call<List<Likedsong>> call, Response<List<Likedsong>> response) {
                listlikedsong= (ArrayList<Likedsong>) response.body();
                likedsongadapter=new likedsongadt(getActivity());
                likedsongadapter.setlistlikedsong(listlikedsong);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
                rcvlikedsong.setLayoutManager(linearLayoutManager);
                rcvlikedsong.setAdapter(likedsongadapter);
            }

            @Override
            public void onFailure(Call<List<Likedsong>> call, Throwable t) {

            }
        });
    }
}
