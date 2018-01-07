package com.mydemoapplication.presentation.presenters;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

import com.mydemoapplication.app.environment.Constants;
import com.mydemoapplication.data.entity.yandex_fotki.Entry;
import com.mydemoapplication.presentation.base.PresenterImpl;
import com.mydemoapplication.presentation.contract.ListPhotoFragmentPresenter;
import com.mydemoapplication.presentation.contract.ListPhotoFragmentView;
import com.mydemoapplication.presentation.services.PhotoProvider;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Kras on 03.01.2018.
 */

public class ListPhotoFragmentPresenterImpl extends PresenterImpl<ListPhotoFragmentView> implements ListPhotoFragmentPresenter,Constants {

    private Context context;

    @Inject
    public ListPhotoFragmentPresenterImpl(Context context){
        this.context = context;

    }

    @Override
    public void onAttach(ListPhotoFragmentView listPhotoFragmentView) {
        super.onAttach(listPhotoFragmentView);
        view=listPhotoFragmentView;
    }

    @Override
    public void loadPhoto(Bundle arguments) {
            ResultReceiver resultReceiver = new ResultReceiver(new Handler()) {
                @Override
                protected void onReceiveResult(int resultCode, Bundle resultData) {
                    super.onReceiveResult(resultCode, resultData);
                    if (resultCode == RESULT_OK) {
                        view.setItems((List<Entry>) resultData.getSerializable(EXTRA_PARAM1));
                    } else {
                        view.onError(resultData.getString(EXTRA_PARAM1));
                    }
                }
            };
            switch (arguments.getInt(BUNDLE_KEY)) {
                case MAIN_MENU_ITEM_RECENT_PHOTO:
                    PhotoProvider.startAction(context, PhotoProvider.ACTION_LOAD_RECENT_PHOTO, resultReceiver);
                    break;
                case MAIN_MENU_ITEM_TOP_PHOTO:
                    PhotoProvider.startAction(context, PhotoProvider.ACTION_LOAD_TOP_PHOTO, resultReceiver);
                    break;
                case MAIN_MENU_ITEM_PODHISTORY:
                    PhotoProvider.startAction(context, PhotoProvider.ACTION_LOAD_PODHISTORY_PHOTO, resultReceiver);
                    break;

            }
    }


}
