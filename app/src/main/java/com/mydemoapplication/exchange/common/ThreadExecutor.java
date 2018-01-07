package com.mydemoapplication.exchange.common;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

/**
 * Created by Kras on 03.01.2018.
 */

public class ThreadExecutor  implements Executor {

    private static final int MAX_THREAD_POOL_COUNT = 8;
    final ExecutorService threadPoolExecutor;

    @Inject
    public ThreadExecutor() {
        this.threadPoolExecutor = Executors.newFixedThreadPool(MAX_THREAD_POOL_COUNT);
    }

    @Override
    public void execute(@NonNull Runnable command) {
        threadPoolExecutor.execute(command);
    }

}
