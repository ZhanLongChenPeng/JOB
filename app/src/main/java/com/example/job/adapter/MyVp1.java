package com.example.job.adapter;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.job.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

public class MyVp1 extends FragmentStatePagerAdapter {
    private ArrayList <Fragment> fragments;
    private List <ListBean.DataBean.CategoryListBean> categoryList;

    public MyVp1(FragmentManager fm, ArrayList <Fragment> fragments, List <ListBean.DataBean.CategoryListBean> categoryList) {
        super(fm);
        this.fragments = fragments;
        this.categoryList = categoryList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categoryList.get(position).getName();
    }
}
