package com.mydemoapplication.presentation.views.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mydemoapplication.R;
import com.mydemoapplication.app.di.AppComponent;
import com.mydemoapplication.app.environment.Constants;
import com.mydemoapplication.data.entity.yandex_fotki.Entry;
import com.mydemoapplication.presentation.base.BaseFlexibleAdapter;
import com.mydemoapplication.presentation.base.BaseFragment;
import com.mydemoapplication.presentation.contract.ListPhotoFragmentPresenter;
import com.mydemoapplication.presentation.contract.ListPhotoFragmentView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class ListPhotoFragment extends BaseFragment implements ListPhotoFragmentView,Constants {

    @BindView(R.id.fragment_recyclerview)    RecyclerView recyclerView;
    @BindView(R.id.fragment_swipe_refresh_layout)    SwipeRefreshLayout swipeRefreshLayout;

    @Inject    ListPhotoFragmentPresenter presenter;

    private BaseFlexibleAdapter baseFlexibleAdapter;

    private ArrayList<Entry> list=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_list_photo;
    }

    @Override
    protected void inject(AppComponent appComponent) {
        appComponent.presenterComponent().inject(this);
        presenter.onAttach(this);
    }

    @Override
    protected void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        baseFlexibleAdapter = new BaseFlexibleAdapter(list);
        recyclerView.setAdapter(baseFlexibleAdapter);

        if(savedInstanceState!=null) {
            list= (ArrayList<Entry>) savedInstanceState.getSerializable(BUNDLE_KEY2);
            setItems(list);
            recyclerView.post(new Runnable() {
                @Override
                public void run() {
                    recyclerView.getLayoutManager().onRestoreInstanceState(savedInstanceState.getParcelable(BUNDLE_KEY));
                }
            });
        }else {
            swipeRefreshLayout.setRefreshing(true);
            list.clear();
            presenter.loadPhoto(getArguments());
        }

    }

    @Override
    protected CharSequence getTitle() {
        return getArguments().getCharSequence(BUNDLE_KEY2);
    }


    @Override
    public void onError(String... strings) {
        mListener.onError(strings);
    }

    @Override
    public void setItems(List<Entry> list) {
        swipeRefreshLayout.setRefreshing(false);
        baseFlexibleAdapter.addItems(0,list);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(BUNDLE_KEY,recyclerView.getLayoutManager().onSaveInstanceState());
        outState.putSerializable(BUNDLE_KEY2,list);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
