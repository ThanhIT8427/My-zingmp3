package com.example.zingmp3.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.zingmp3.Model.Category;
import com.example.zingmp3.Model.Themeandcategory;
import com.example.zingmp3.R;
import com.example.zingmp3.Sevice.APIService;
import com.example.zingmp3.Sevice.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_category extends Fragment {
    TextView txtcategoryseemore;
    HorizontalScrollView ho;
    View view;
    ArrayList<Category> listct;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.row_category,container,false);
        txtcategoryseemore=(TextView) view.findViewById(R.id.txtcategoryseemore);
        ho=(HorizontalScrollView) view.findViewById(R.id.horozontalview);
        listct=new ArrayList<>();
        getdata();
        return view;
    }
    private void getdata(){
        Dataservice dataservice= APIService.getservice();
        Call<Themeandcategory> call=dataservice.getthemeandcategory();
        call.enqueue(new Callback<Themeandcategory>() {
            @Override
            public void onResponse(Call<Themeandcategory> call, Response<Themeandcategory> response) {
                Themeandcategory themeandcategory= new Themeandcategory();
                themeandcategory=response.body();
                listct.addAll(themeandcategory.getCategory());
                LinearLayout linearLayout=new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams layout=new LinearLayout.LayoutParams(580,250);
                for(int i=0;i<listct.size();i++){
                    CardView cardView=new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView=new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setPadding(0,0,10,0);
                    if(listct.get(i).getCategoryimg()!=null){
                        Picasso.with(getActivity()).load(listct.get(i).getCategoryimg().replace("https://srv622.hstgr.io:7443/files/public_html","https://thanhnguyen.store/")).into(imageView);

                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                ho.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<Themeandcategory> call, Throwable t) {

            }
        });

    }
}
