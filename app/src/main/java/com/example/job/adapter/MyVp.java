package com.example.job.adapter;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.job.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

public class MyVp extends FragmentStatePagerAdapter {
    private ArrayList <Fragment> fragments;

    public MyVp(FragmentManager fm, ArrayList <Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
