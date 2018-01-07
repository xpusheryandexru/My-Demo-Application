package com.mydemoapplication.presentation.presenters;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

import com.mydemoapplication.app.environment.Constants;
import com.mydemoapplication.data.entity.yandex_fotki.Feed;
import com.mydemoapplication.presentation.base.PresenterImpl;
import com.mydemoapplication.presentation.contract.MainActivityPresenter;
import com.mydemoapplication.presentation.contract.MainActivityView;
import com.mydemoapplication.presentation.services.PhotoProvider;

import javax.inject.Inject;


/**
 * Created by Kras on 31.12.2017.
 */

public class MainActivityPresenterImpl extends PresenterImpl<MainActivityView> implements MainActivityPresenter,Constants {



    @Inject
    public MainActivityPresenterImpl(Context context){

    }

    @Override
    public void onAttach(MainActivityView mainActivityView) {
        super.onAttach(mainActivityView);

    }
}
