package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.util.ArrayList;
import java.util.Random;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws Exception {
        super(tablet);
    }

    @Override
    protected void initDishes() throws Exception {
        dishes = new ArrayList<>();

        Dish[] values = Dish.values();

        int howManyDishes = new Random().nextInt(values.length)+1;
        while (howManyDishes-- > 0) {
            int dishNumber = new Random().nextInt(values.length);
            dishes.add(values[dishNumber]);
        }
    }
}
