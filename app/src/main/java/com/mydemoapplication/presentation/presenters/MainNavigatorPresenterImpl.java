package com.mydemoapplication.presentation.presenters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mydemoapplication.R;
import com.mydemoapplication.app.environment.Constants;
import com.mydemoapplication.data.entity.MainMenuItem;
import com.mydemoapplication.presentation.base.BaseFragment;
import com.mydemoapplication.presentation.base.PresenterImpl;
import com.mydemoapplication.presentation.contract.MainActivityView;
import com.mydemoapplication.presentation.contract.MainNavigatorPresenter;
import com.mydemoapplication.presentation.views.activity.MainActivity;
import com.mydemoapplication.presentation.views.fragment.AboutFragment;
import com.mydemoapplication.presentation.views.fragment.ListPhotoFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.CustomDrawerArrowDrawable;
import nl.psdcompany.duonavigationdrawer.widgets.CustomDuoDrawerToggle;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

/**
 * Created by Kras on 03.01.2018.
 */

public class MainNavigatorPresenterImpl extends PresenterImpl<MainActivityView> implements MainNavigatorPresenter,Constants{

    private Resources resources;
    private FlexibleAdapter adapter;
    private int selectedMainMenuItemId;
    private List<MainMenuItem> list;


    @Inject
    public MainNavigatorPresenterImpl(Resources resources){
        this.resources=resources;

    }

    @Override
    public void setDrawer(MainActivity mainActivity, DuoDrawerLayout duoDrawerLayout, Toolbar toolbar, RecyclerView recyclerView, View header) {
        Bitmap bitmap= BitmapFactory.decodeResource(resources, R.drawable.ic_dehaze_white_24dp);
        final DuoDrawerToggle duoDrawerToggle=new CustomDuoDrawerToggle(
                mainActivity,
                toolbar,
                duoDrawerLayout,
                new CustomDrawerArrowDrawable(resources, bitmap),
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close,
                new CustomDuoDrawerToggle.Listener() {
                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerOpen() {

                    }
                }
        );
        duoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();
        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
        list=new ArrayList<>();
        list.add(new MainMenuItem(MAIN_MENU_ITEM_PODHISTORY,R.mipmap.ic_launcher,resources.getString(R.string.photo_of_the_day)));
        list.add(new MainMenuItem(MAIN_MENU_ITEM_RECENT_PHOTO,R.mipmap.ic_launcher,resources.getString(R.string.new_photo)));
        list.add(new MainMenuItem(MAIN_MENU_ITEM_TOP_PHOTO,R.mipmap.ic_launcher,resources.getString(R.string.interesting_photos)));
        adapter = new FlexibleAdapter<>(list, new FlexibleAdapter.OnItemClickListener() {
            @Override
            public boolean onItemClick(int position) {
                unSelectedMenu();
                MainMenuItem mainMenuItem=list.get(position);
                selectedMainMenuItemId=mainMenuItem.getId();
                view.showFragment();
                return true;
            }
        });
        recyclerView.setAdapter(adapter);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragmentAbout();
            }
        });

    }

    @Override
    public Fragment createFragment() {
        BaseFragment currentFragment;
        switch (selectedMainMenuItemId){
            case MAIN_MENU_ITEM_RECENT_PHOTO:
            case MAIN_MENU_ITEM_TOP_PHOTO:
            case MAIN_MENU_ITEM_PODHISTORY:
                currentFragment=new ListPhotoFragment();
                break;
            default:
                currentFragment=new AboutFragment();
        }

        Bundle bundle=new Bundle();
        bundle.putInt(BUNDLE_KEY,selectedMainMenuItemId);
        bundle.putCharSequence(BUNDLE_KEY2,getTitle());
        currentFragment.setArguments(bundle);

        return currentFragment;


    }

    @Override
    public void setFragmentAbout() {
        unSelectedMenu();
        selectedMainMenuItemId=MAIN_MENU_HEADER;
        view.showFragment();
    }


    //************************************************
    private void unSelectedMenu() {
        for (int i=0;i<list.size();i++)
            list.get(i).setSelected(false);
        adapter.notifyDataSetChanged();
    }
    public CharSequence getTitle() {
        switch (selectedMainMenuItemId){
            case MAIN_MENU_ITEM_RECENT_PHOTO:
            case MAIN_MENU_ITEM_TOP_PHOTO:
            case MAIN_MENU_ITEM_PODHISTORY:
                return list.get(selectedMainMenuItemId).getTitle();
            default:
                return resources.getString(R.string.app_name);
        }

    }

}
