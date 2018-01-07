package com.mydemoapplication.presentation.contract;

import com.mydemoapplication.data.entity.yandex_fotki.Entry;
import com.mydemoapplication.presentation.base.BasicView;

import java.util.List;

/**
 * Created by Kras on 03.01.2018.
 */

public interface ListPhotoFragmentView extends BasicView{
    void setItems(List<Entry> list);
}
