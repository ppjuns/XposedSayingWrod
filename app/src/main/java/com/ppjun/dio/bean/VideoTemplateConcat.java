package com.ppjun.dio.bean;

import java.io.File;

public class VideoTemplateConcat {
    public static final int AD_TYPE_BAIDU = 101;
    public static final int AD_TYPE_FEED_EXPRESS = 13;
    public static final int AD_TYPE_GDT = 102;
    public static final int AD_TYPE_NORMAL = 0;
    public static final int AD_TYPE_TT = 103;
    private boolean isFeedIndex;
    private VideoTemplateItem item;

    public boolean isFeedIndex() {
        return this.isFeedIndex;
    }

    public void setFeedIndex(boolean z) {
        this.isFeedIndex = z;
    }

    public VideoTemplateItem getItem() {
        return this.item;
    }

    public void setItem(VideoTemplateItem videoTemplateItem) {
        this.item = videoTemplateItem;
    }


}