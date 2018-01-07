package com.mydemoapplication.presentation.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;

import com.mydemoapplication.app.environment.Constants;
import com.mydemoapplication.app.environment.MyDemoApplication;
import com.mydemoapplication.data.entity.yandex_fotki.Entry;
import com.mydemoapplication.exchange.yandex_fotki.tasks.LoadPodHistoryTask;
import com.mydemoapplication.exchange.yandex_fotki.tasks.LoadRecentTask;
import com.mydemoapplication.exchange.yandex_fotki.tasks.LoadTopTask;
import com.mydemoapplication.other.SimpleSubscriber;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class PhotoProvider extends IntentService implements Constants{
    //********************Actions
    public static final String ACTION_LOAD_RECENT_PHOTO = "ACTION_LOAD_RECENT_PHOTO";
    public static final String ACTION_LOAD_TOP_PHOTO = "ACTION_LOAD_TOP_PHOTO";
    public static final String ACTION_LOAD_PODHISTORY_PHOTO = "ACTION_LOAD_PODHISTORY_PHOTO";
    //********************Key params
    private static final String RESULT_RECEIVER = "RESULT_RECEIVER";
    //*******************
    public static void startAction(Context context, @NonNull String action,@NonNull ResultReceiver resultReceiver, Object... param) {
        Intent intent = new Intent(context, PhotoProvider.class);
        intent.setAction(action);
        intent.putExtra(RESULT_RECEIVER , resultReceiver);
        context.startService(intent);
    }
    //******************

    @Inject  LoadRecentTask loadRecentTask;
    @Inject  LoadTopTask loadTopTask;
    @Inject LoadPodHistoryTask loadPodHistoryTask;

    public PhotoProvider() {
        super("PhotoProvider");
        MyDemoApplication.getAppComponent().networkComponent().inject(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            switch (action){
                case ACTION_LOAD_RECENT_PHOTO:
                    requestRecentPhoto(intent);
                    break;
                case ACTION_LOAD_TOP_PHOTO:
                    requestTopPhoto(intent);
                    break;
                case ACTION_LOAD_PODHISTORY_PHOTO:
                    requestPodHistoryPhoto(intent);
                    break;
            }
        }
    }

    private void requestPodHistoryPhoto(Intent intent) {
        final ResultReceiver resultReceiver= intent.getParcelableExtra(RESULT_RECEIVER);
        final Bundle bundle=new Bundle();
        loadPodHistoryTask.execute(null, new SimpleSubscriber<List<Entry>>() {
            @Override
            public void onNext(List<Entry> list) {
                super.onNext(list);
                bundle.putSerializable(EXTRA_PARAM1,new ArrayList<>(list));
                resultReceiver.send(RESULT_OK, bundle);
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                bundle.putString(EXTRA_PARAM1,t.getMessage());
                resultReceiver.send(RESULT_ERROR, bundle);
            }
        });
    }

    //***********************************
    private void requestRecentPhoto(Intent intent) {
        final ResultReceiver resultReceiver= intent.getParcelableExtra(RESULT_RECEIVER);
        final Bundle bundle=new Bundle();
        loadRecentTask.execute(null, new SimpleSubscriber<List<Entry>>() {
            @Override
            public void onNext(List<Entry> list) {
                super.onNext(list);
                bundle.putSerializable(EXTRA_PARAM1,new ArrayList<>(list));
                resultReceiver.send(RESULT_OK, bundle);
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                bundle.putString(EXTRA_PARAM1,t.getMessage());
                resultReceiver.send(RESULT_ERROR, bundle);
            }
        });
    }
    private void requestTopPhoto(Intent intent) {
        final ResultReceiver resultReceiver= intent.getParcelableExtra(RESULT_RECEIVER);
        final Bundle bundle=new Bundle();
        loadTopTask.execute(null, new SimpleSubscriber<List<Entry>>() {
            @Override
            public void onNext(List<Entry> list) {
                super.onNext(list);
                bundle.putSerializable(EXTRA_PARAM1,new ArrayList<>(list));
                resultReceiver.send(RESULT_OK, bundle);
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                bundle.putString(EXTRA_PARAM1,t.getMessage());
                resultReceiver.send(RESULT_ERROR, bundle);
            }
        });

    }

}
