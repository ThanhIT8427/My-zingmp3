package com.example.zingmp3.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> arrayfragment=new ArrayList<>();
    private ArrayList<String> arraytitle=new ArrayList<>();

    public MainViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ArrayList<Fragment> getArrayfragment() {
        return arrayfragment;
    }

    public void setArrayfragment(ArrayList<Fragment> arrayfragment) {
        this.arrayfragment = arrayfragment;
    }

    public ArrayList<String> getArraytitle() {
        return arraytitle;
    }

    public void setArraytitle(ArrayList<String> arraytitle) {
        this.arraytitle = arraytitle;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arrayfragment.get(position);
    }

    @Override
    public int getItemCount() {
        return arrayfragment.size();
    }
    public void addfargment(Fragment fragment,String title){
        arrayfragment.add(fragment);
        arraytitle.add(title);

    }


}
