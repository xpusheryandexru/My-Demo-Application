package com.mydemoapplication.app.di.modules;

import android.content.Context;
import android.content.res.Resources;


import dagger.Module;
import dagger.Provides;

/**
 * Created by Kras on 31.12.2017.
 */
@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context){
        this.context=context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    Resources provideResources() {
        return context.getResources();
    }





}
