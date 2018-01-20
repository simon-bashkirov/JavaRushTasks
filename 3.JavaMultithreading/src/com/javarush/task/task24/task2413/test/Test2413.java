package com.javarush.task.task24.task2413.test;

public class Test2413 {
    public static void main(String[] args) {
        double dx;
        double dy;
        double direction = 90;
        double speed = 1;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
        System.out.println(angle);
    }
}
