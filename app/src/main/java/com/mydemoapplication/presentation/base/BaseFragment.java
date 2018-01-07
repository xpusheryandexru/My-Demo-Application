package com.mydemoapplication.presentation.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mydemoapplication.app.di.AppComponent;
import com.mydemoapplication.app.environment.MyDemoApplication;

import butterknife.ButterKnife;


/**
 * Created by Kras on 03.01.2018.
 */

public abstract class BaseFragment extends Fragment {
    protected Bundle savedInstanceState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState=savedInstanceState;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject(MyDemoApplication.getAppComponent());
        bindView(view);
        init();
        view.post(new Runnable() {
            @Override
            public void run() {
                mListener.setTitle(getTitle());
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    //**************************************
    protected OnFragmentInteractionListener mListener;

    public abstract int getFragmentLayout() ;
    protected abstract void inject(AppComponent appComponent);
    protected abstract void init();
    protected abstract CharSequence getTitle();

    public interface OnFragmentInteractionListener {

        void setTitle(CharSequence title);
        void onError(String... strings);

    }

    protected void bindView(View view){
        ButterKnife.bind(this,view);
    }

}
