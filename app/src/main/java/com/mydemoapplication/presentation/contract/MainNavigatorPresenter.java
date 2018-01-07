package com.mydemoapplication.presentation.contract;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mydemoapplication.presentation.base.Presenter;
import com.mydemoapplication.presentation.views.activity.MainActivity;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;

/**
 * Created by Kras on 03.01.2018.
 */

public interface MainNavigatorPresenter extends Presenter<MainActivityView> {
    void setDrawer(MainActivity mainActivity, DuoDrawerLayout duoDrawerLayout, Toolbar toolbar, RecyclerView recyclerView, View header);

    Fragment createFragment();

    void setFragmentAbout();

}

