package com.mydemoapplication.presentation.views.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mydemoapplication.R;
import com.mydemoapplication.app.di.AppComponent;
import com.mydemoapplication.app.environment.Constants;
import com.mydemoapplication.presentation.base.BaseFragment;
import com.mydemoapplication.presentation.contract.MainActivityPresenter;
import com.mydemoapplication.presentation.contract.MainActivityView;
import com.mydemoapplication.presentation.contract.MainNavigatorPresenter;
import com.mydemoapplication.presentation.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;

public class MainActivity extends BaseActivity implements MainActivityView,BaseFragment.OnFragmentInteractionListener,Constants {
    @BindView(R.id.activity_main_duo_drawer_layout)    DuoDrawerLayout duoDrawerLayout;
    @BindView(R.id.activity_main_header)    View header;
    @BindView(R.id.common_toolbar)    Toolbar toolbar;
    @BindView(R.id.common_toolbar_container) LinearLayout container;
    @BindView(R.id.common_toolbar_title)    TextView title;
    @BindView(R.id.activity_main_menu) RecyclerView recyclerView;


    @Inject
    MainActivityPresenter presenter;
    @Inject
    MainNavigatorPresenter navigatorPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        if(savedInstanceState==null)
            navigatorPresenter.setFragmentAbout();
    }


    @Override
    protected void inject(AppComponent appComponent) {
        appComponent.presenterComponent().inject(this);
    }

    @Override
    protected void initView() {
        navigatorPresenter.setDrawer(this,duoDrawerLayout,toolbar,recyclerView,header);
    }

    @Override
    protected void attachPresenter() {
        presenter.onAttach(this);
        navigatorPresenter.onAttach(this);
    }

    @Override
    protected Toolbar findActionBar() {
        return toolbar;
    }

    @Override
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        title.setText(getTitle());
        duoDrawerLayout.closeDrawer();
    }

    @Override
    public void onError(String... strings) {
        showMessage(strings[0]);
        navigatorPresenter.setFragmentAbout();
    }


    @Override
    public int getActivityLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(
                        R.id.activity_main_container,
                        navigatorPresenter.createFragment()
                ).commitNow();
    }

}
