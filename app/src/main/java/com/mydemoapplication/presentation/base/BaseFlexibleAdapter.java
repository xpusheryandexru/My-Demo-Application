package com.mydemoapplication.presentation.base;

import android.support.annotation.Nullable;

import com.mydemoapplication.presentation.contract.InteractiveModelView;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

/**
 * Created by Kras on 05.01.2018.
 */

public class BaseFlexibleAdapter<T extends IFlexible> extends FlexibleAdapter<T> {

    private InteractiveModelView.Listener listener;

    public BaseFlexibleAdapter(@Nullable List<T> items) {
        super(items);
    }

    public BaseFlexibleAdapter(@Nullable List<T> items, @Nullable Object listeners) {
        super(items, listeners);
    }

    public BaseFlexibleAdapter(@Nullable List<T> items, @Nullable Object listeners,
                               boolean stableIds) {
        super(items, listeners, stableIds);
    }

    public BaseFlexibleAdapter(@Nullable List<T> items, InteractiveModelView.Listener listener) {
        super(items);
        this.listener = listener;
    }

    public BaseFlexibleAdapter(@Nullable List<T> items, @Nullable Object listeners,
                               InteractiveModelView.Listener listener) {
        super(items, listeners);
        this.listener = listener;
    }

    public BaseFlexibleAdapter(@Nullable List<T> items, @Nullable Object listeners,
                               boolean stableIds, InteractiveModelView.Listener listener) {
        super(items, listeners, stableIds);
        this.listener = listener;
    }

    public InteractiveModelView.Listener getListener() {
        return listener;
    } {

    }
}
