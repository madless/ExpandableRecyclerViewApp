package com.anandbose.expandablelistdemo;

import java.util.List;

/**
 * Created by dmikhov on 04.01.2017.
 */
public class Category {
    String name;
    List<Word> words;

    public Category(String name, List<Word> words) {
        this.name = name;
        this.words = words;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return name;
    }
}
