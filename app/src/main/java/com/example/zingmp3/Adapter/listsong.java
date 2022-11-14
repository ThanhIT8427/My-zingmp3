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

import java.util.ArrayList;

public class listsong extends RecyclerView.Adapter<listsong.ViewHolder> {
    Context context;
    ArrayList<Likedsong> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.row_listsong,parent,false);
        return new ViewHolder(view);
    }

    public listsong(Context context, ArrayList<Likedsong> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Likedsong likedsong=list.get(position);
        holder.textlistsinger.setText(likedsong.getSongsinger());
        holder.textlistsongname.setText(likedsong.getSongname());
        holder.textsttlist.setText(position+1+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textsttlist,textlistsongname,textlistsinger;
        ImageView imglisticonlove;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textsttlist=itemView.findViewById(R.id.textsttlist);
            textlistsongname=itemView.findViewById(R.id.textlistsongname);
            textlistsinger=itemView.findViewById(R.id.textlistsinger);
            imglisticonlove=itemView.findViewById(R.id.imglisticonlove);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, PlayMusic.class);
                    intent.putExtra("baihat",list.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
