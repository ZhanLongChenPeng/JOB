package com.example.job.view;

import com.example.job.bean.ListBean;

public interface MyView {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}

