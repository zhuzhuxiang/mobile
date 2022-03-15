package com.zhuzhu.mobile.ui.fragment;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.zhuzhu.mobile.R;
import com.zhuzhu.mobile.bean.ListAppBean;
import com.zhuzhu.mobile.di.component.AppComponent;
import com.zhuzhu.mobile.di.component.DaggerRecommendComponent;
import com.zhuzhu.mobile.di.module.RecommendModule;
import com.zhuzhu.mobile.presenter.RecommendPresenter;
import com.zhuzhu.mobile.presenter.contract.RecommendContract;
import com.zhuzhu.mobile.ui.adapter.RecomendAppAdatper;
import com.zhuzhu.mobile.ui.decoration.DividerItemDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * Created by Ivan on 16/9/26.
 */

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {

    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;

    private RecomendAppAdatper mAdatper;


//    @Inject
//    ProgressBar mProgressBar;


    @Inject
    ProgressDialog mProgressDialog;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

        DaggerRecommendComponent.builder()
                .appComponent(appComponent)
                .recommendModule(new RecommendModule(this)).build().inject(this);

    }

    @Override
    public int setLayout() {
        return R.layout.fragment_recomend;
    }

    @Override
    public void init() {
        mPresenter.requestDatas();
    }



    private void initRecycleView(List<ListAppBean> datas){


        //为RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        //为RecyclerView设置分割线(这个可以对DividerItemDecoration进行修改，自定义)
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));

        //动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        mAdatper = new RecomendAppAdatper(getActivity(),datas);

        mRecyclerView.setAdapter(mAdatper);



    }


    @Override
    public void showResult(List<ListAppBean> datas) {
        initRecycleView(datas);
    }

    @Override
    public void showNodata() {

        Toast.makeText(getActivity(),"暂时无数据，请吃完饭再来",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(),"服务器开小差了："+msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        Log.e("TAG", "开启加载框");
//        mProgressBar.setVisibility(View.VISIBLE);

        mProgressDialog.show();

    }

    @Override
    public void dimissLoading() {
        Log.e("TAG", "关闭加载框");
//        if(mProgressBar.getVisibility()==View.VISIBLE){
//            mProgressBar.setVisibility(View.GONE);
//        }
        if(mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }

    }
}
