package com.mydemoapplication.presentation.contract;

/**
 * Created by Kras on 03.01.2018.
 */

public interface InteractiveModelView<T> extends ModelView<T>  {
    void setListener(Listener listener);

    interface Listener {
        void onModelAction(int code, Object o);
    }

}
