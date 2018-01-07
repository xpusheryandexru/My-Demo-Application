package com.mydemoapplication.presentation.base;

import android.view.View;

import com.mydemoapplication.presentation.contract.InteractiveModelView;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by Kras on 03.01.2018.
 */

public class ModelViewHolder <V extends View> extends FlexibleViewHolder {
    public final V view;
    private InteractiveModelView.Listener listener;

    public ModelViewHolder(View view, FlexibleAdapter adapter) {
        super(view, adapter);
        this.view = ((V) view);
    }

    public void setListener(InteractiveModelView.Listener listener) {
        this.listener = listener;
        if(listener != null && (view instanceof InteractiveModelView)) {
            ((InteractiveModelView) view).setListener(listener);
        }
    }

}
