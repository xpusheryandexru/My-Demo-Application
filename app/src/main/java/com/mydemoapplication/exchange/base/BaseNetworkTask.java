package com.mydemoapplication.exchange.base;

import android.content.res.Resources;

import com.google.gson.Gson;
import com.mydemoapplication.exchange.common.ApiException;
import com.mydemoapplication.exchange.common.ObservableTask;
import com.mydemoapplication.exchange.yandex_fotki.YfApi;

import java.io.IOException;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Kras on 03.01.2018.
 */

public abstract class BaseNetworkTask<P, Result> extends ObservableTask<P, Result> {

    private YfApi yfApi;
    private Gson gson = new Gson();
    private Resources resources;

    public BaseNetworkTask( Executor executor, YfApi yfApi, Resources resources) {
        super(executor);
        this.yfApi = yfApi;
        this.resources=resources;
    }

    public YfApi getYfApi() {
        return yfApi;
    }

    protected <Res> Res executeCall(Call<Res> call) {
        try {
            Response<Res> resResponse = call.execute();
            if(resResponse.isSuccessful()) {
                return resResponse.body();
            } else {
                String body = resResponse.errorBody().string();
                throw new ApiException(body, resResponse.code());
            }
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), 0);

        }
    }

}
