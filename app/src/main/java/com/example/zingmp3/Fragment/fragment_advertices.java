package com.example.zingmp3.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.zingmp3.Adapter.adverticesAdt;
import com.example.zingmp3.Model.Advertex;
import com.example.zingmp3.R;
import com.example.zingmp3.Sevice.APIService;
import com.example.zingmp3.Sevice.Dataservice;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_advertices extends Fragment {
    Handler handler;
    Runnable runnable;
    ViewPager viewFlipper;
    CircleIndicator circleIndicator;
    adverticesAdt adverticesAdt;
    int currentitem;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_advertices,container,false);
        viewFlipper=(ViewPager) view.findViewById(R.id.viewpaper);
        circleIndicator=(CircleIndicator) view.findViewById(R.id.indicatordefault);

        getdata();
        return view;
    }

    private void getdata() {
        Dataservice dataservice= APIService.getservice();
        Call<List<Advertex>> callback=dataservice.getdataad();
        callback.enqueue(new Callback<List<Advertex>>() {
            @Override
            public void onResponse(Call<List<Advertex>> call, Response<List<Advertex>> response) {
                ArrayList<Advertex> advertices= (ArrayList<Advertex>) response.body();
                adverticesAdt=new adverticesAdt(getActivity(),advertices);
                viewFlipper.setAdapter(adverticesAdt);
                circleIndicator.setViewPager(viewFlipper);
                handler=new Handler();
                runnable=new Runnable() {
                    @Override
                    public void run() {
                        currentitem=viewFlipper.getCurrentItem();
                        currentitem++;

                        if(currentitem>=viewFlipper.getAdapter().getCount()){
                            currentitem=0;
                        }
                        viewFlipper.setCurrentItem(currentitem,true);
                        handler.postDelayed(runnable,4500);
                    }
                };
                handler.postDelayed(runnable,4500);

            }

            @Override
            public void onFailure(Call<List<Advertex>> call, Throwable t) {

            }
        });


    }
}
