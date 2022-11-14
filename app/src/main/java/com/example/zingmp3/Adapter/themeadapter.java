package com.example.zingmp3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zingmp3.Model.Theme;
import com.example.zingmp3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class themeadapter extends RecyclerView.Adapter<themeadapter.themeViewholder> {
    private List<Theme>  listtheme;

    private Context context;

    public themeadapter(Context context) {
        this.context = context;
    }
    public void setlisttheme(List<Theme> list){
        this.listtheme=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public themeViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_theme,parent,false);
        return new themeViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull themeViewholder holder, int position) {
        Theme theme=listtheme.get(position);
        if(theme!=null){
            Picasso.with(context).load(theme.getThemeimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(holder.imgtheme);
            holder.txtthemetitle.setText(theme.getThemename());
        }else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        if(listtheme!=null){
            return listtheme.size();
        }
        return 0;
    }

    public class themeViewholder extends RecyclerView.ViewHolder{
        private ImageView imgtheme;
        private TextView txtthemetitle;
        public themeViewholder(@NonNull View itemView) {
            super(itemView);
            imgtheme=itemView.findViewById(R.id.imgtheme);
            txtthemetitle=itemView.findViewById(R.id.txtthemetitle);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull themeViewholder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }
}
