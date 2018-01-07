package com.mydemoapplication.presentation.views.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mydemoapplication.R;
import com.mydemoapplication.data.entity.MainMenuItem;
import com.mydemoapplication.presentation.contract.ModelView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kras on 03.01.2018.
 */

public class MainMenuItemView extends RelativeLayout implements ModelView<MainMenuItem>{
    @BindView(R.id.view_menuField_icon)    ImageView icon;
    @BindView(R.id.view_menuField_title)    TextView title;


    private MainMenuItem model;

    public MainMenuItemView(Context context) {
        super(context);
    }

    public MainMenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MainMenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MainMenuItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void setModel(MainMenuItem model) {
        this.model=model;
        title.setText(model.getTitle());
        setBackgroundResource(model.isSelected() ?
                R.drawable.bg_main_menu_item_selected: R.drawable.bg_main_menu_item);

    }

    @Override
    public MainMenuItem getModel() {
        return this.model;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }
}
