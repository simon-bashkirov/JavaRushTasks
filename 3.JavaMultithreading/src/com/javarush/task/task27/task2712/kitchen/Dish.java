package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;
import java.util.List;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        Dish[] values = values();
        String[] dishes = new String[values.length];
        for (int i = 0; i < dishes.length; i++) {
            dishes[i] = values[i].toString();
        }
        return String.join(", ", dishes);
    }
}
