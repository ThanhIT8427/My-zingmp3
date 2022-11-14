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

import com.example.zingmp3.Adapter.themeadapter;
import com.example.zingmp3.Model.Category;
import com.example.zingmp3.Model.Theme;
import com.example.zingmp3.Model.Themeandcategory;
import com.example.zingmp3.R;
import com.example.zingmp3.Sevice.APIService;
import com.example.zingmp3.Sevice.Dataservice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_themeandcategory extends Fragment {
    View view;
    RecyclerView rcvtheme;
    TextView txtthemeseemore;
    Themeandcategory themeandcategory;
    ArrayList<Theme> themeArrayList;
    ArrayList<Category> categoryArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_themeandcategory,container,false);
        rcvtheme=(RecyclerView) view.findViewById(R.id.rcvtheme);
        txtthemeseemore=(TextView) view.findViewById(R.id.txtthemeseemore);
        getdata();
        return view;
    }
    private void getdata(){
        Dataservice dataservice= APIService.getservice();
        Call<Themeandcategory> call=dataservice.getthemeandcategory();
        call.enqueue(new Callback<Themeandcategory>() {
            @Override
            public void onResponse(Call<Themeandcategory> call, Response<Themeandcategory> response) {
                themeandcategory=new Themeandcategory();
                themeandcategory=response.body();
                themeArrayList=new ArrayList<>();
                themeArrayList.addAll(themeandcategory.getTheme());
                categoryArrayList=new ArrayList<>();
                categoryArrayList.addAll(themeandcategory.getCategory());
                /*LinearLayout linearLayout=new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams layout=new LinearLayout.LayoutParams(580,250);
                for(int i=0;i<themeArrayList.size();i++){
                    CardView cardView=new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView=new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setPadding(0,0,10,0);
                    if(themeArrayList.get(i).getThemeimg()!=null){
                        Picasso.with(getActivity()).load(themeArrayList.get(i).getThemeimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(imageView);

                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                for(int i=0;i<categoryArrayList.size();i++){
                    CardView cardView=new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView=new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setPadding(0,0,10,0);
                    if(categoryArrayList.get(i).getCategoryimg()!=null){
                        Picasso.with(getActivity()).load(categoryArrayList.get(i).getCategoryimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(imageView);

                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                horizontalScrollView.addView(linearLayout);*/

                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
                rcvtheme.setLayoutManager(linearLayoutManager);

                themeadapter themeadapter=new themeadapter(getActivity());
                themeadapter.setlisttheme(themeArrayList);
                rcvtheme.setAdapter(themeadapter);
                //ViewGroup.LayoutParams layout=rcvtheme.getLayoutParams();
                //layout.height=300;
                //rcvtheme.setLayoutParams(layout);
                //rcvtheme.requestLayout();
            }

            @Override
            public void onFailure(Call<Themeandcategory> call, Throwable t) {


            }
        });

    }

}
