package com.zhuzhu.mobile;

import android.app.Application;
import android.content.Context;


import com.zhuzhu.mobile.di.component.AppComponent;
import com.zhuzhu.mobile.di.component.DaggerAppComponent;
import com.zhuzhu.mobile.di.module.AppModule;
import com.zhuzhu.mobile.di.module.HttpModule;

public class AppApplication extends Application {
    private AppComponent mAppComponent;

    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {

        return mAppComponent;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build();

    }
}
