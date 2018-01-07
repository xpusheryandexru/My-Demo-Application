package com.mydemoapplication.presentation.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.mydemoapplication.app.di.AppComponent;
import com.mydemoapplication.app.environment.MyDemoApplication;

import butterknife.ButterKnife;

/**
 * Created by Kras on 01.01.2018.
 */

public abstract class BaseActivity extends AppCompatActivity {



    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        inject(MyDemoApplication.getAppComponent());
        ButterKnife.bind(this);
        attachPresenter();
        prepareView();
        initView();
    }


    //*************************************************
    protected abstract void inject(AppComponent appComponent);
    protected abstract void initView();
    protected abstract void attachPresenter();
    protected abstract int getActivityLayout();


    private void prepareView() {

        Toolbar toolbar = findActionBar();
        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setElevation(0);
        }
    }
    protected Toolbar findActionBar() {
        return null;
    }

    protected void showMessage(String string) {
        if(string == null) return;
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();

    }

}
