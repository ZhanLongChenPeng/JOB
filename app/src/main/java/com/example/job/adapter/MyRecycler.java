package com.example.job.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.job.R;
import com.example.job.bean.ListBean;
import com.example.job.fragment.VpFragment;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

public class MyRecycler extends RecyclerView.Adapter<MyRecycler.ViewHolder> {
    private ArrayList <ListBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;
    private Context context;


    public MyRecycler(Context context, ArrayList <ListBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList <ListBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_main, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ListBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBeanX = list.get(position);
        Glide.with(context).load(subCategoryListBeanX.getWap_banner_url()).into(holder.im);
        holder.tee.setText(subCategoryListBeanX.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView im;
        private final TextView tee;

        public ViewHolder(View view) {
            super(view);
            im = view.findViewById(R.id.im);
            tee = view.findViewById(R.id.tee);
        }
    }
    private OnLongClick onLongClick;

    public void setOnLongClick(OnLongClick onLongClick) {
        this.onLongClick = onLongClick;
    }
    public interface OnLongClick{
        void OnClick(int position, ListBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBeanX);
    }
}

