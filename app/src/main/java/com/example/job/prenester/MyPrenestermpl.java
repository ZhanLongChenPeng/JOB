package com.example.job.prenester;

import com.example.job.bean.ListBean;
import com.example.job.callback.MyCallBack;
import com.example.job.model.MyModelmpl;
import com.example.job.view.MyView;

public class MyPrenestermpl implements MyPrenester, MyCallBack {

    private MyModelmpl myModel;
    private MyView myView;

    public MyPrenestermpl(MyModelmpl myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void initAdd() {
        if (myModel != null) {
            myModel.initData(this);
        }
    }

    @Override
    public void onSuccess(ListBean listBean) {
        if (myView != null) {
            myView.onSuccess(listBean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (myView != null) {
            myView.onFail(msg);
        }
    }
}
