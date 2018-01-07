package com.mydemoapplication.app.di;

import com.mydemoapplication.app.di.modules.PresenterModule;
import com.mydemoapplication.presentation.views.activity.MainActivity;
import com.mydemoapplication.presentation.views.fragment.ListPhotoFragment;

import dagger.Subcomponent;

/**
 * Created by Kras on 03.01.2018.
 */
@Subcomponent(modules = {PresenterModule.class})
public interface PresenterComponent {
    void inject(MainActivity mainActivity);
    void inject(ListPhotoFragment listPhotoFragment);
}
