package com.javarush.task.task14.task1421;

/**
 * Created by Vitaly on 5/7/2017.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton() {};

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}
