package com.mydemoapplication.presentation.contract;

/**
 * Created by Kras on 03.01.2018.
 */

public interface ModelView<T> {
    void setModel(T model);
    T getModel();
}
