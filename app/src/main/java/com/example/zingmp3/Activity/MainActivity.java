package com.example.zingmp3.Activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.zingmp3.Adapter.MainViewPagerAdapter;
import com.example.zingmp3.Fragment.Fragment_mainpage;
import com.example.zingmp3.Fragment.Fragment_search;
import com.example.zingmp3.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();

    }
    private void anhxa(){
        tabLayout=(TabLayout) findViewById(R.id.mytablayout);
        viewPager2=(ViewPager2) findViewById(R.id.myviewpaper);


    }
    private void init(){
        MainViewPagerAdapter mainViewPagerAdapter=new MainViewPagerAdapter(this);
        mainViewPagerAdapter.addfargment(new Fragment_mainpage(),"Trang chu");
        mainViewPagerAdapter.addfargment(new Fragment_search(),"Tim kiem");
        viewPager2.setAdapter(mainViewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:

                        tab.setIcon(R.drawable.icon_home);
                        tab.setText("Trang chu");
                        break;
                    case 1:
                        tab.setIcon(R.drawable.iconsearch);
                        tab.setText("Tim kiem");
                        break;
                }
            }
        }).attach();
    }
}