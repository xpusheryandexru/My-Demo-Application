package com.mydemoapplication.presentation.contract;

import android.os.Bundle;

import com.mydemoapplication.presentation.base.Presenter;

/**
 * Created by Kras on 03.01.2018.
 */

public interface ListPhotoFragmentPresenter extends Presenter<ListPhotoFragmentView> {
    void loadPhoto(Bundle arguments);

}
