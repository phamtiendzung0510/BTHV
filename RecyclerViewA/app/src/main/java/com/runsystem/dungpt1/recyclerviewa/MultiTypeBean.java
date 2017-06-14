package com.runsystem.dungpt1.recyclerviewa;

/**
 * Created by dungpt1 on 07-Jun-17.
 */

public class MultiTypeBean {

    public static final int HEADER = 0;
    public static final int ITEM = 1;

    public int viewType = ITEM;
    public String image;
    public String title;
    public String description;

    public MultiTypeBean(String description, String image, String title, int viewType) {
        this.viewType = viewType;
        this.image = image;
        this.title = title;
        this.description = description;
    }
}
