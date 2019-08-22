package com.example.job.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.job.R;
import com.example.job.adapter.MyRecycler;
import com.example.job.bean.ListBean;
import com.example.job.model.MyModelmpl;
import com.example.job.prenester.MyPrenestermpl;
import com.example.job.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class VpFragment extends Fragment implements MyView {

    @BindView(R.id.recycler_jie)
    RecyclerView mRecyclerJie;
    private int parent_id;
    private MyPrenestermpl myPrenestermpl;
    private View view;
    private Unbinder unbinder;
    private ArrayList <ListBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;
    private MyRecycler myRecycler;

    @SuppressLint("ValidFragment")
    public VpFragment() {
        // Required empty public constructor
        this.parent_id = parent_id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_vp, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initData();
        initAdd();
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

    private void initAdd(){
        list = new ArrayList <>();

        mRecyclerJie.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        myRecycler = new MyRecycler(getActivity(), list);
        mRecyclerJie.setAdapter(myRecycler);
    }

    @Override
    public void onSuccess(ListBean listBean) {
        List <ListBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = listBean.getData().getCurrentCategory().getSubCategoryList();
        list.addAll(subCategoryList);
        myRecycler.setList(list);
        myRecycler.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }
}
