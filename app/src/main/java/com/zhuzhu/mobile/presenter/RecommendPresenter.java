package com.zhuzhu.mobile.presenter;

import android.util.Log;

import com.zhuzhu.mobile.bean.DataBean;
import com.zhuzhu.mobile.bean.ListAppBean;
import com.zhuzhu.mobile.bean.ListBean;
import com.zhuzhu.mobile.bean.PageBean;
import com.zhuzhu.mobile.data.RecommendModel;
import com.zhuzhu.mobile.presenter.contract.RecommendContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Ivan on 2017/1/3.
 */

public class RecommendPresenter extends BasePresenter<RecommendModel, RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel mModel, RecommendContract.View mView) {
        super(mModel, mView);
    }

    public void requestDatas() {

        mView.showLoading();
        mModel.getApps(new Callback<PageBean<DataBean>>() {
            @Override
            public void onResponse(Call<PageBean<DataBean>> call, Response<PageBean<DataBean>> response) {
                if (response != null) {
                    Log.e("TAG", "onResponse1: ======" + response.body().toString());
                    Log.e("TAG", "onResponse2: ======" + response.body().getData());
                    Log.e("TAG", "onResponse3: ======" + response.body().getData().getFeatured());
                    Log.e("TAG", "onResponse4: ======" + response.body().getData().getFeatured().getList().get(1).toString());
                    Log.e("TAG", "onResponse5: ======" + response.body().getData().getFeatured().getList().get(1).getData().getListApp());
                    int size = response.body().getData().getFeatured().getList().size();
                    List<ListBean> listApp = response.body().getData().getFeatured().getList();
                    List<ListAppBean> listAppBean;
                    List listAppBeans = new ArrayList<>();
                    for (int i = 1; i < size; i++) {
                        listAppBean = listApp.get(i).getData().getListApp();
                        if (listAppBean != null) {   //不进行该判断会报空指针
                            listAppBeans.addAll(listAppBean);
                        }
                    }
//                    mView.showResult(response.body().getData().getFeatured().getList().get(1).getData().getListApp());
                    mView.showResult(listAppBeans);
                } else {
                    mView.showNodata();
                }

                mView.dimissLoading();
            }

            @Override
            public void onFailure(Call<PageBean<DataBean>> call, Throwable t) {
                mView.dimissLoading();
                mView.showError(t.getMessage());

            }
        });

    }
}
