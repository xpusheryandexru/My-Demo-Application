package com.mydemoapplication.data.entity.yandex_fotki;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

/**
 * Created by Kras on 04.01.2018.
 */

public class Img implements Serializable {
    @Attribute(required = false)
    private int height;
    @Attribute(required = false)
    private String href;
    @Attribute(required = false)
    private String size;
    @Attribute(required = false)
    private int width;

    public int getHeight() {
        return height;
    }

    public String getHref() {
        return href;
    }

    public String getSize() {
        return size;
    }

    public int getWidth() {
        return width;
    }
}
