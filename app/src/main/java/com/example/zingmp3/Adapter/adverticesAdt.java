package com.example.zingmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.zingmp3.Activity.ListsongadActivity;
import com.example.zingmp3.Model.Advertex;
import com.example.zingmp3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adverticesAdt extends PagerAdapter {
    Context context;
    List<Advertex> advertexList;

    public adverticesAdt(Context context, List<Advertex> advertexList) {
        this.context = context;
        this.advertexList = advertexList;
    }

    @Override
    public int getCount() {
        return advertexList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.row_ad,null);
        ImageView imgbg=view.findViewById(R.id.imgbackground);
        ImageView imgad=view.findViewById(R.id.imgad);
        TextView txttitle=view.findViewById(R.id.txttitle);
        TextView txtcontentad=view.findViewById(R.id.txtcontentad);
        Advertex a=advertexList.get(position);
        Picasso.with(context).load(a.getSongimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(imgad);
        Picasso.with(context).load(a.getAdimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(imgbg);
        txtcontentad.setText(a.getAdcontent());
        txttitle.setText(a.getSongname());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ListsongadActivity.class);
                intent.putExtra("advertices",advertexList.get(position));
                context.startActivity(intent);
            }
        });
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
