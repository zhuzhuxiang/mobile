package com.zhuzhu.mobile.di.module;

import com.zhuzhu.mobile.AppApplication;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private AppApplication appApplication;

    public AppModule(AppApplication appApplication) {
        this.appApplication = appApplication;
    }

    @Provides
    @Singleton
    public AppApplication provideApplication(){
        return appApplication;
    }

    @Provides
    @Singleton
    public Gson provideGson(){
        return new Gson();
    }
}
