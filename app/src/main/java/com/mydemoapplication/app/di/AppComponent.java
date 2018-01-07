package com.mydemoapplication.app.di;

import com.mydemoapplication.app.di.modules.AppModule;
import com.mydemoapplication.app.di.modules.NetworkModule;
import com.mydemoapplication.presentation.services.PhotoProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Kras on 31.12.2017.
 */

@Component(modules = {AppModule.class,NetworkModule.class})
@Singleton
public interface AppComponent {

    PresenterComponent presenterComponent();
    NetworkComponent networkComponent();

}


