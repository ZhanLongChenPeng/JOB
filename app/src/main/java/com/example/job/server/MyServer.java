package com.example.job.server;

import com.example.job.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    public String url = "https://cdwan.cn/api/catalog/";
        @GET("index")
        Observable <ListBean> getData();
}
