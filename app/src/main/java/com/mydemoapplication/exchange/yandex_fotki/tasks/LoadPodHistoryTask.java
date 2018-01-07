package com.mydemoapplication.exchange.yandex_fotki.tasks;

import android.content.res.Resources;

import com.mydemoapplication.data.entity.yandex_fotki.Entry;
import com.mydemoapplication.data.entity.yandex_fotki.Feed;
import com.mydemoapplication.exchange.base.BaseNetworkTask;
import com.mydemoapplication.exchange.yandex_fotki.YfApi;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Kras on 04.01.2018.
 */

public class LoadPodHistoryTask extends BaseNetworkTask<Void,List<Entry>> {

    @Inject
    public LoadPodHistoryTask(Executor executor, YfApi yfApi, Resources resources) {
        super( executor, yfApi, resources);
    }

    @Override
    protected Observable<List<Entry>> prepareObservable(Void aVoid) {
        return Observable.create(new ObservableOnSubscribe<List<Entry>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Entry>> subscriber) throws Exception {

                    try {
                        Feed feed= executeCall(getYfApi().podhistory());
                        subscriber.onNext(feed.getEntry());
                        subscriber.onComplete();
                    } catch (Exception e) {
                        subscriber.onError(e);
                    }
            }
        });
    }
}
