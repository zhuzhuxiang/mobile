package com.zhuzhu.mobile.data;

import com.zhuzhu.mobile.bean.DataBean;
import com.zhuzhu.mobile.bean.PageBean;
import com.zhuzhu.mobile.data.http.ApiService;

import retrofit2.Callback;

/**
 * Created by Ivan on 2017/1/3.
 */

public class RecommendModel {

    private ApiService apiService;

    public RecommendModel(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getApps(Callback<PageBean<DataBean>> callback) {


//        HttpManager manager = new HttpManager();
//
//        ApiService apiService =manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);


        apiService.getApps("{\"publicParams\":{}}").enqueue(callback);
    }


}
