package com.zhuzhu.mobile.di.module;

import android.app.ProgressDialog;
import android.widget.ProgressBar;

import com.zhuzhu.mobile.data.RecommendModel;
import com.zhuzhu.mobile.data.http.ApiService;
import com.zhuzhu.mobile.presenter.contract.RecommendContract;
import com.zhuzhu.mobile.ui.fragment.RecommendFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendModule {

    private RecommendContract.View mView;


    public RecommendModule(RecommendContract.View view) {
        mView = view;
    }


    @Provides
    public RecommendContract.View provideView(){
        return  mView;
    }

    @Provides
    public RecommendModel provideModel(ApiService apiService){
        return new RecommendModel(apiService);
    }

//   @Provides
//    public ProgressBar provideProgressBar(RecommendContract.View view){
////        return  new ProgressBar(((RecommendFragment) view).getActivity());
//       return  new ProgressBar(((RecommendFragment)view).getActivity());
//    }

    @Provides
    public ProgressDialog provideProgressDialog(RecommendContract.View view){

        return new ProgressDialog(((RecommendFragment)view).getActivity());
    }
}
