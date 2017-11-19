package com.example.demo;

/**
 * Created by paul_ on 11/18/2017.
 */
public class Widget {

    private final long id;
    private final String content;

    public Widget(String content,int x, int y) {
        this.id = x;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}