package com.zhuzhu.mobile.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import com.zhuzhu.mobile.AppApplication;
import com.zhuzhu.mobile.di.component.AppComponent;
import com.zhuzhu.mobile.presenter.BasePresenter;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    private Unbinder unbinder;
    private AppApplication mApplication;
    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //添加字体库配置
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        unbinder = ButterKnife.bind(this);
        this.mApplication = (AppApplication) getApplication();
        //给Activity设置Component配置
        setupActivityComponent(mApplication.getAppComponent());
        init();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }
    }

    public abstract void setupActivityComponent(AppComponent appComponent);

    public abstract int setLayout();

    public abstract void init();
}
