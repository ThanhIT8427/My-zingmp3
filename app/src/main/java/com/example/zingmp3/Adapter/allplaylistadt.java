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

import com.example.zingmp3.Activity.ListsongadActivity;
import com.example.zingmp3.Model.Playlistcurrentday;
import com.example.zingmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class allplaylistadt extends RecyclerView.Adapter<allplaylistadt.ViewHolder> {
    Context context;
    ArrayList<Playlistcurrentday> list;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_allplaylist,parent,false);

        return new ViewHolder(view);
    }

    public allplaylistadt(Context context, ArrayList<Playlistcurrentday> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlistcurrentday playlistcurrentday=list.get(position);
        Picasso.with(context).load(playlistcurrentday.getPlaylistimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(holder.imgallplaylist);
        holder.textallplaylist.setText(playlistcurrentday.getPlaylistname());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgallplaylist;
        TextView textallplaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgallplaylist=itemView.findViewById(R.id.imgallplaylist);
            textallplaylist=itemView.findViewById(R.id.textallplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, ListsongadActivity.class);
                    intent.putExtra("playlist",list.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
