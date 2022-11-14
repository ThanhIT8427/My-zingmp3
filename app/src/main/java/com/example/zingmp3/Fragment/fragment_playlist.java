package com.example.zingmp3.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zingmp3.Activity.Allplaylist;
import com.example.zingmp3.Activity.ListsongadActivity;
import com.example.zingmp3.Adapter.playlistadt;
import com.example.zingmp3.Model.Playlistcurrentday;
import com.example.zingmp3.R;
import com.example.zingmp3.Sevice.APIService;
import com.example.zingmp3.Sevice.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_playlist extends Fragment {
    View view;
    ListView lvplaylist;
    TextView txtseemore;
    playlistadt playlistadt;
    ArrayList<Playlistcurrentday> playlistcurrentdays;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_playlist,container,false);
        lvplaylist=(ListView) view.findViewById(R.id.lvplaylist);
        txtseemore=(TextView) view.findViewById(R.id.txtseemore);
        getData();
        txtseemore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Allplaylist.class);
                startActivity(intent);
            }
        });
        return view;

    }

    private void getData() {
        Dataservice dataservice= APIService.getservice();
        Call<List<Playlistcurrentday>> call=dataservice.getplaylistcurrentday();
        call.enqueue(new Callback<List<Playlistcurrentday>>() {
            @Override
            public void onResponse(Call<List<Playlistcurrentday>> call, Response<List<Playlistcurrentday>> response) {
                playlistcurrentdays= (ArrayList<Playlistcurrentday>) response.body();
                playlistadt=new playlistadt(getActivity(), android.R.layout.simple_list_item_1,playlistcurrentdays);
                lvplaylist.setAdapter(playlistadt);
                setListViewHeightBasedOnChildren(lvplaylist);
                lvplaylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(getActivity(), ListsongadActivity.class);
                        intent.putExtra("playlist",playlistcurrentdays.get(i));
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Playlistcurrentday>> call, Throwable t) {

            }
        });
    }
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
