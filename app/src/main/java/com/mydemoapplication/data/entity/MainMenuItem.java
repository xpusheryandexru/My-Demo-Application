package com.mydemoapplication.data.entity;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mydemoapplication.R;
import com.mydemoapplication.app.environment.Constants;
import com.mydemoapplication.presentation.base.ModelViewHolder;
import com.mydemoapplication.presentation.views.widget.MainMenuItemView;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;

/**
 * Created by Kras on 03.01.2018.
 */

public class MainMenuItem extends AbstractFlexibleItem<ModelViewHolder<MainMenuItemView>> implements Constants{

    private int id;
    private int icon;
    private String title;
    private boolean selected;

    public MainMenuItem (int id, int icon, String title) {
        this.id = id;
        this.icon = icon;
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainMenuItem menuField = (MainMenuItem) o;

        return id == menuField.id;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.view_main_menu_item;
    }

    @Override
    public ModelViewHolder<MainMenuItemView> createViewHolder(FlexibleAdapter adapter,
                                                       LayoutInflater inflater,
                                                       ViewGroup parent) {
        return new ModelViewHolder<>(inflater.inflate(getLayoutRes(), parent, false), adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ModelViewHolder<MainMenuItemView> holder,
                               int position, List payloads) {
        holder.view.setModel(this);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
