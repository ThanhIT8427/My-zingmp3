package com.example.zingmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zingmp3.Activity.PlayMusic;
import com.example.zingmp3.Model.Likedsong;
import com.example.zingmp3.R;
import com.example.zingmp3.Sevice.APIService;
import com.example.zingmp3.Sevice.Dataservice;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class likedsongadt extends RecyclerView.Adapter<likedsongadt.ViewHolder> {
    List<Likedsong> listlikedsong;
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_likedsong,parent,false);
        return new ViewHolder(view);
    }

    public likedsongadt(Context context) {
        this.context = context;
    }
    public void setlistlikedsong(List<Likedsong> list){
        this.listlikedsong=list;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Likedsong a=listlikedsong.get(position);
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        long longNumber = Integer.parseInt(a.getSonglike());
        String str1 = en.format(longNumber);

        Picasso.with(context).load(a.getSongimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(holder.imglikedsong);
        holder.txtsongsinger.setText(a.getSongsinger());
        holder.txtnamesong.setText(a.getSongname());
        holder.txtcountlike.setText(str1);

    }

    @Override
    public int getItemCount() {
        return listlikedsong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imglikedsong,imglovesong;
        TextView txtnamesong,txtsongsinger,txtcountlike;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imglikedsong=itemView.findViewById(R.id.imglikedsong);
            imglovesong=itemView.findViewById(R.id.imglike);
            txtnamesong=itemView.findViewById(R.id.txtsongname);
            txtsongsinger=itemView.findViewById(R.id.txtlikedsongsinger);
            txtcountlike=itemView.findViewById(R.id.txtcoutlike);
            imglovesong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dataservice data= APIService.getservice();
                    Call<List<Likedsong>> call=data.updatelikedsong(Integer.parseInt(listlikedsong.get(getPosition()).getSongid()));

                    call.enqueue(new Callback<List<Likedsong>>() {
                        @Override
                        public void onResponse(Call<List<Likedsong>> call, Response<List<Likedsong>> response) {
                            listlikedsong=response.body();
                            imglovesong.setImageResource(R.drawable.iconloved);
                            notifyDataSetChanged();

                        }

                        @Override
                        public void onFailure(Call<List<Likedsong>> call, Throwable t) {

                        }
                    });

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, PlayMusic.class);
                    intent.putExtra("baihat",listlikedsong.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
