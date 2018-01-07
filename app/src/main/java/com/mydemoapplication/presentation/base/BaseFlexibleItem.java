package com.mydemoapplication.presentation.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mydemoapplication.presentation.contract.ModelView;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;

/**
 * Created by Kras on 05.01.2018.
 */

public abstract class BaseFlexibleItem <T, V extends View & ModelView<T>>   extends AbstractFlexibleItem<ModelViewHolder<V>> {

    private T model;

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public BaseFlexibleItem(T model) {
        this.model = model;
    }

    public BaseFlexibleItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseFlexibleItem<?, ?> that = (BaseFlexibleItem<?, ?>) o;

        return model != null ? model.equals(that.model) : that.model == null;
    }

    @Override
    public abstract int getLayoutRes();

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }

    @Override
    public ModelViewHolder<V> createViewHolder(FlexibleAdapter adapter,
                                               LayoutInflater inflater, ViewGroup parent) {
        ModelViewHolder<V> holder = new ModelViewHolder<>(inflater.inflate(getLayoutRes(), parent, false), adapter);
        if(adapter instanceof BaseFlexibleAdapter) {
            holder.setListener(((BaseFlexibleAdapter) adapter).getListener());
        }
        return holder;
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ModelViewHolder<V> holder,
                               int position, List payloads) {
        holder.view.setModel(model);
    }

}
