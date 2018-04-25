package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String text = bis.readLine();
        return text;
    }

    public static List<Dish> getAllDishesForOrder() throws Exception {
        List<Dish> dishes = new ArrayList<>();
        while (true) {
            writeMessage("");
            writeMessage("Выберите блюдо:");
            for (Dish dish : Dish.values()) {
                writeMessage(String.format("\t %s", dish.toString()));
            }
            writeMessage("\t exit - выход");
            writeMessage("");
            writeMessage("Введите название блюда:");
            String s = readString();
            if (s.toLowerCase().equals("exit")) {
                break;
            }
            else {
                try {
                    Dish dish = Dish.valueOf(s.substring(0, 1).toUpperCase() + s.substring(1));
                    dishes.add(dish);
                } catch (IllegalArgumentException e) {
                    writeMessage("Такое блюдо отсутствует в меню");
                }
            }
        }
        return dishes;
    }
}
