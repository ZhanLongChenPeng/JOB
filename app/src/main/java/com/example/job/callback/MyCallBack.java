package com.example.job.callback;

import com.example.job.bean.ListBean;

public interface MyCallBack {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}

