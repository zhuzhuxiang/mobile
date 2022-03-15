package com.zhuzhu.mobile.presenter;

import com.zhuzhu.mobile.ui.BaseView;

/**
 * Created by Ivan on 2017/1/3.
 */

public class BasePresenter<M, V extends BaseView> {
    protected M mModel;
    protected V mView;

    public BasePresenter(M m, V v) {
        this.mModel = m;
        this.mView = v;
    }
}
