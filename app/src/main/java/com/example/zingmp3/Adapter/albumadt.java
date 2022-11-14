package com.example.zingmp3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zingmp3.Model.Album;
import com.example.zingmp3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class albumadt extends RecyclerView.Adapter<albumadt.ViewHolder> {
    List<Album> listalbum;
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_album,parent,false);

        return new ViewHolder(view);
    }

    public albumadt(Context context) {
        this.context = context;
    }
    public void setlist(List<Album> list){
        this.listalbum=list;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album a=listalbum.get(position);
        Picasso.with(context).load(a.getAlbumimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(holder.imgalbum);
        holder.txtalbumtitle.setText(a.getAlbumname());
        holder.txtalbumsinger.setText(a.getAlbumsingername());
    }

    @Override
    public int getItemCount() {
        return listalbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtalbumtitle,txtalbumsinger;

        private ImageView imgalbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtalbumtitle=itemView.findViewById(R.id.txtalbumtitle);
            txtalbumsinger=itemView.findViewById(R.id.txtalbumsinger);
            imgalbum=itemView.findViewById(R.id.imgalbum);

        }
    }
}
