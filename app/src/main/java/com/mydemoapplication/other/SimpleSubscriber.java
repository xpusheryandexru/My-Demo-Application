package com.mydemoapplication.other;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Kras on 05.01.2018.
 */

public class SimpleSubscriber<T> implements Subscriber<T> {
    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
