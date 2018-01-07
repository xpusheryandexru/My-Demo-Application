package com.mydemoapplication.presentation.views.item;

import com.mydemoapplication.R;
import com.mydemoapplication.data.entity.yandex_fotki.Entry;
import com.mydemoapplication.presentation.base.BaseFlexibleItem;
import com.mydemoapplication.presentation.views.widget.PhotoView;

/**
 * Created by Kras on 05.01.2018.
 */

public class RecentPhotoItem extends BaseFlexibleItem<Entry, PhotoView> {
    @Override
    public int getLayoutRes() {
        return R.layout.view_phpto_item;
    }
}
