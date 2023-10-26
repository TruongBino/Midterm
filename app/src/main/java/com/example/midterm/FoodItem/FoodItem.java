package com.example.midterm.FoodItem;

public class FoodItem {
    private final int imageResId;
    private final String name;

    public FoodItem(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }
}
