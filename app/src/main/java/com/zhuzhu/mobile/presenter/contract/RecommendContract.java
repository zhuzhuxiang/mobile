package com.zhuzhu.mobile.presenter.contract;

import com.zhuzhu.mobile.bean.ListAppBean;
import com.zhuzhu.mobile.ui.BaseView;

import java.util.List;

/**
 * Created by Ivan on 2017/1/3.
 */

public interface RecommendContract {


    interface View extends BaseView{





        void showResult(List<ListAppBean> datas);
        void showNodata();
        void showError(String msg);



    }



}
