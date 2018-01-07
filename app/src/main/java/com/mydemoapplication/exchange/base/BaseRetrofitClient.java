package com.mydemoapplication.exchange.base;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Kras on 03.01.2018.
 */

public abstract class BaseRetrofitClient<T> {
    private T api;

    public BaseRetrofitClient(String baseUrl){
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(10, TimeUnit.SECONDS);
        clientBuilder.readTimeout(10, TimeUnit.SECONDS);
        clientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                try {
                    return chain.proceed(chain.request());
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                    return new Response.Builder()
                            .message("sss")
                            .protocol(Protocol.HTTP_1_1)
                            .code(404)
                            .body(ResponseBody.create(MediaType.parse("application/json"), exception.getMessage()))
                            //.body(ResponseBody.create(MediaType.parse("application/json"), "{\"key\":[\"somestuff\"]}"))
                            .request(chain.request())
                            .build();
                }

            }
        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(clientBuilder.build())
                //.addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .build();

        this.api=retrofit.create(apiClass());

    }

    public abstract Class<T> apiClass();

    public T getYandexFotkiApi() {
        return api;
    }
}
