package com.mydemoapplication.presentation.base;

/**
 * Created by Kras on 03.01.2018.
 */

public interface Presenter<T> {
    void onAttach(T t);
}
