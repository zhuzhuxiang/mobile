package com.zhuzhu.mobile.di.component;

import com.zhuzhu.mobile.data.http.ApiService;
import com.zhuzhu.mobile.di.module.AppModule;
import com.zhuzhu.mobile.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
      public ApiService getApiService();
}
