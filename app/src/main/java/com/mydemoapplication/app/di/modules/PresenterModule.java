package com.mydemoapplication.app.di.modules;

import com.mydemoapplication.presentation.contract.ListPhotoFragmentPresenter;
import com.mydemoapplication.presentation.contract.MainActivityPresenter;
import com.mydemoapplication.presentation.contract.MainNavigatorPresenter;
import com.mydemoapplication.presentation.presenters.ListPhotoFragmentPresenterImpl;
import com.mydemoapplication.presentation.presenters.MainActivityPresenterImpl;
import com.mydemoapplication.presentation.presenters.MainNavigatorPresenterImpl;



import dagger.Module;
import dagger.Provides;

/**
 * Created by Kras on 31.12.2017.
 */
@Module
public class PresenterModule {

    @Provides
    public MainActivityPresenter provideMainActivityPresenter(MainActivityPresenterImpl presenter) {
        return presenter;
    }
    @Provides
    public MainNavigatorPresenter provideNavigatorPresenter(MainNavigatorPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    public ListPhotoFragmentPresenter provideListPhotoFragmentPresenter(ListPhotoFragmentPresenterImpl presenter) {
        return presenter;
    }

}
