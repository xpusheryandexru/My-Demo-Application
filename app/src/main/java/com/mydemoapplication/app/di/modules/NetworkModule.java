package com.mydemoapplication.app.di.modules;


import com.mydemoapplication.exchange.yandex_fotki.YfApiClient;
import com.mydemoapplication.exchange.yandex_fotki.YfApi;
import com.mydemoapplication.exchange.yandex_fotki.YfClient;

import com.mydemoapplication.exchange.common.ThreadExecutor;


import java.util.concurrent.Executor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kras on 31.12.2017.
 */


@Module
public class NetworkModule {

    public NetworkModule(){

    }

    @Provides
    public YfApi provideApi(YfApiClient yfApiClient) {
        return yfApiClient.getYandexFotkiApi();
    }

    @Provides
    public YfApiClient provideApiClient(YfClient client) {
        return client;
    }


    @Provides
    public Executor provideExecutor(ThreadExecutor executor) {
        return executor;
    }

}
