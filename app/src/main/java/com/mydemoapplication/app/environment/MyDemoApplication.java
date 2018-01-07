package com.mydemoapplication.app.environment;

import android.app.Application;

import com.mydemoapplication.app.di.AppComponent;
import com.mydemoapplication.app.di.modules.AppModule;
import com.mydemoapplication.app.di.DaggerAppComponent;

/**
 * Created by Kras on 31.12.2017.
 */

public class MyDemoApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }
    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
