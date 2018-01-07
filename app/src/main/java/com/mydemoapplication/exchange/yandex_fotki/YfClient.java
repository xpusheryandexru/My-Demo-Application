package com.mydemoapplication.exchange.yandex_fotki;

import com.mydemoapplication.exchange.base.BaseRetrofitClient;
import com.mydemoapplication.exchange.yandex_fotki.YfApi;
import com.mydemoapplication.exchange.yandex_fotki.YfApiClient;

import javax.inject.Inject;

/**
 * Created by Kras on 03.01.2018.
 */

public class YfClient extends BaseRetrofitClient<YfApi> implements YfApiClient {

    @Inject
    public YfClient() {
        super("http://api-fotki.yandex.ru/");
    }

    @Override
    public Class<YfApi> apiClass() {
        return YfApi.class;
    }
}
