package com.javarush.tasks.task27.task2712;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.*;
import java.util.Random;

public class OrderCreator {
    public static Order createRandomOrder(Tablet tablet) {
        InputStream in = System.in;
        PrintStream out = System.out;
        PrintStream nullOut = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        });
        Dish[] values = Dish.values();

        StringBuilder sb = new StringBuilder();
        int howManyDishes = new Random().nextInt(values.length)+1;
        while (howManyDishes-- > 0) {
            int dishNumber = new Random().nextInt(values.length);
            sb.append(values[dishNumber]).append("\n");
        }
        sb.append("exit\n");

        String s = sb.toString();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(byteArrayInputStream);
        ConsoleHelper.reInit();
        System.setOut(nullOut);

        Order order = null;
        try {
            order = tablet.createOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.setIn(in);
        ConsoleHelper.reInit();
        System.setOut(out);
        return order;
    }
}
