package com.mydemoapplication.app.di;

import com.mydemoapplication.app.di.modules.NetworkModule;
import com.mydemoapplication.presentation.services.PhotoProvider;

import dagger.Subcomponent;

/**
 * Created by Kras on 03.01.2018.
 */
@Subcomponent(modules = {NetworkModule.class})
public interface NetworkComponent {
    void inject(PhotoProvider photoProvider);
}
