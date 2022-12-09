package com.example.practicews.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.practicews.Fragment.AFragment;
import com.example.practicews.Fragment.BFragment;
import com.example.practicews.Fragment.CFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new AFragment();
        }else if(position == 1){
            return new BFragment();
        }else
            return new CFragment();
    }

    @Override
    public int getCount() {
        return 3;  //No of tabs
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "A Frag";
        }else if(position == 1){
            return  "B Frag";
        }else return "C Frag";
    }
}
