package com.mydemoapplication.data.entity.yandex_fotki;

import com.mydemoapplication.presentation.views.item.RecentPhotoItem;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kras on 04.01.2018.
 */

public class Entry extends RecentPhotoItem implements Serializable {

    public Entry(){
        setModel(this);
    }

//    @Element
//    private String id;
    @Element
    private String title;
//    @Element
//    private String updated;
//    @ElementList(inline = true, required = false)
//    private List<Link> links;
//    @Element
//    private String published;
//    @Element(required = false)
//    private Access access;
//    @Element(required = false)
//    private String created;
    @ElementList(inline = true, required = false)
    private List<Img> img;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public List<Img> getImg() {
        return img;
    }
}
