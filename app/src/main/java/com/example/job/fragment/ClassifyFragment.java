package com.example.job.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.job.R;
import com.example.job.adapter.MyRecycler;
import com.example.job.adapter.MyVp;
import com.example.job.adapter.MyVp1;
import com.example.job.bean.ListBean;
import com.example.job.model.MyModelmpl;
import com.example.job.prenester.MyPrenestermpl;
import com.example.job.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends Fragment implements MyView {


    @BindView(R.id.tab_shu)
    VerticalTabLayout mTabShu;
    @BindView(R.id.recycler)
    ViewPager mVp;
    private View view;
    private Unbinder unbinder;
    private MyPrenestermpl myPrenestermpl;
    private MyRecycler myRecycler;

    private MyRecycler myRecycler1;
    private ArrayList <Fragment> fragments;
    private List <ListBean.DataBean.CategoryListBean> categoryList;
    private MyVp1 adapters;

    public ClassifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_classify, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initData();

        return inflate;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initData() {
        myPrenestermpl = new MyPrenestermpl(new MyModelmpl(), this);
        myPrenestermpl.initAdd();
    }




    @Override
    public void onSuccess(final ListBean listBean) {
        categoryList = listBean.getData().getCategoryList();

        //垂直tab
        fragments = new ArrayList <>();
        for (int i = 0; i < categoryList.size(); i++) {
            mTabShu.addTab(new QTabView(getContext()));
            VpFragment vpFragment = new VpFragment();
            fragments.add(vpFragment);
        }
        adapters = new MyVp1(getActivity().getSupportFragmentManager(), fragments, categoryList);
        mVp.setAdapter(adapters);

        mTabShu.setupWithViewPager(mVp);


        mTabShu.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return categoryList.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new QTabView.TabTitle.Builder()
                        .setContent(categoryList.get(position).getName())
                        .setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent), ContextCompat.getColor(getContext(), R.color.cardview_dark_background))
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });
        mTabShu.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {

            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });





    }

    @Override
    public void onFail(String msg) {

    }


}
