package com.mydemoapplication.presentation.base;

/**
 * Created by Kras on 03.01.2018.
 */

public class PresenterImpl<V> {
    protected V view;

    public void onAttach(V v) {
        this.view = v;
    }

}
