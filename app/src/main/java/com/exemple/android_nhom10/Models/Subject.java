package com.exemple.android_nhom10.Models;

public class Subject {
    private String name;
    private int imageResId;

    public Subject(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
