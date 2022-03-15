package com.zhuzhu.mobile.di.component;
import com.zhuzhu.mobile.di.FragmentScope;
import com.zhuzhu.mobile.di.module.RecommendModule;
import com.zhuzhu.mobile.ui.fragment.RecommendFragment;

import dagger.Component;

@FragmentScope
//这个注解用来关联Module    Component相当于是中转站,需要同时关联Module和Container   dependencies 相当于是子类要依赖父类公共模块
@Component(modules = RecommendModule.class,dependencies = AppComponent.class)
public interface RecommendComponent {
    //这个方法用来关联container  RecommendFragment
    void inject(RecommendFragment recommendFragment);
}
