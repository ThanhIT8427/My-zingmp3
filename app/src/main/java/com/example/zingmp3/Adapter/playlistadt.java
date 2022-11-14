package com.example.zingmp3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zingmp3.Model.Playlistcurrentday;
import com.example.zingmp3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class playlistadt extends ArrayAdapter<Playlistcurrentday> {
    public playlistadt(@NonNull Context context, int resource, @NonNull List<Playlistcurrentday> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txtplaylistname;
        ImageView imgplaylistbg,imgplaylistimg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            viewHolder=new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.row_playlist,null);
            viewHolder.txtplaylistname=(TextView) convertView.findViewById(R.id.txtplaylistname);
            viewHolder.imgplaylistbg=(ImageView) convertView.findViewById(R.id.playlistbg);
            viewHolder.imgplaylistimg=(ImageView) convertView.findViewById(R.id.playlistimg);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Playlistcurrentday playlistcurrentday=getItem(position);
        Picasso.with(getContext()).load(playlistcurrentday.getPlaylistbg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(viewHolder.imgplaylistbg);
        Picasso.with(getContext()).load(playlistcurrentday.getPlaylistimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(viewHolder.imgplaylistimg);
        viewHolder.txtplaylistname.setText(playlistcurrentday.getPlaylistname());
        return convertView;
    }
}
