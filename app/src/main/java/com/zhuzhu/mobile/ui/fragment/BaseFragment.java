package com.zhuzhu.mobile.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zhuzhu.mobile.AppApplication;
import com.zhuzhu.mobile.di.component.AppComponent;
import com.zhuzhu.mobile.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    private Unbinder unbinder;
    private AppApplication mApplication;
    private View mRootView;

    @Inject
    T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(setLayout(), container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        return mRootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mApplication = (AppApplication) getActivity().getApplication();
        setupActivityComponent(mApplication.getAppComponent());
        init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(unbinder!=Unbinder.EMPTY){
            unbinder.unbind();
        }
    }

    public abstract void setupActivityComponent(AppComponent appComponent);

    public abstract int setLayout();

    public abstract void init();


}
