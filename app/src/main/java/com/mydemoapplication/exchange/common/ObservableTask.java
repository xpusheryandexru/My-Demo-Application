package com.mydemoapplication.exchange.common;

import org.reactivestreams.Subscriber;

import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Kras on 03.01.2018.
 */

public abstract class ObservableTask<Params, Result> {
    private Executor executor;
    private Disposable disposable;

    public ObservableTask( Executor executor) {
        this.executor = executor;
    }

    protected abstract Observable<Result> prepareObservable(Params params);

    public void cancel() {
        if(disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }
    }

    public void execute(Params params, final Subscriber<Result> subscriber) {
        createObservable(params).subscribe(new Observer<Result>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(@NonNull Result result) {
                subscriber.onNext(result);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                subscriber.onError(e);
            }

            @Override
            public void onComplete() {
                subscriber.onComplete();
            }
        });
    }

    private Observable<Result> createObservable(Params params){
        cancel();
        return prepareObservable(params)
                .subscribeOn(getExecutionScheduler())
                .materialize()
                .observeOn(getExecutionScheduler())
                .dematerialize();
    }

    public void execute(Params params) {
        disposable = createObservable(params).subscribe();
    }

    protected Scheduler getExecutionScheduler() {
        return Schedulers.from(executor);
    }

}
