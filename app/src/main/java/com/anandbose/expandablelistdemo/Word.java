package com.anandbose.expandablelistdemo;

/**
 * Created by dmikhov on 04.01.2017.
 */
public class Word {
    String text;

    public Word(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
