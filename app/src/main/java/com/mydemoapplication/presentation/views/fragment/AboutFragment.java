package com.mydemoapplication.presentation.views.fragment;

import com.mydemoapplication.R;
import com.mydemoapplication.app.di.AppComponent;
import com.mydemoapplication.app.environment.Constants;
import com.mydemoapplication.presentation.base.BaseFragment;

public class AboutFragment extends BaseFragment implements Constants {

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_about;
    }

    @Override
    protected void inject(AppComponent appComponent) {

    }

    @Override
    protected void init() {

    }

    @Override
    protected CharSequence getTitle() {
        return getArguments().getCharSequence(BUNDLE_KEY2);
    }
}
