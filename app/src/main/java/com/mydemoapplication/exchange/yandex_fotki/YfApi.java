package com.mydemoapplication.exchange.yandex_fotki;

import com.mydemoapplication.data.entity.yandex_fotki.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kras on 03.01.2018.
 */

public interface YfApi {

    @GET("api/recent/")
    Call<Feed> recent();

    @GET("api/top/")
    Call<Feed> top();

    @GET("api/podhistory/")
    Call<Feed> podhistory();

}
