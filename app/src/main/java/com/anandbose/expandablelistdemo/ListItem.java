package com.anandbose.expandablelistdemo;

import java.util.List;

/**
 * Created by dmikhov on 04.01.2017.
 */
public class ListItem {
    public int type;
    public String text;
    public List<ListItem> invisibleChildren;

    public ListItem(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ListItem> getInvisibleChildren() {
        return invisibleChildren;
    }

    public void setInvisibleChildren(List<ListItem> invisibleChildren) {
        this.invisibleChildren = invisibleChildren;
    }
}
