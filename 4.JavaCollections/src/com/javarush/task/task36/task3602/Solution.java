package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
//        return Arrays.stream(Collections.class.getDeclaredClasses())
//                .filter(clazz -> clazz.getSimpleName().contains("EmptyList"))
//                .findAny().get();
//        List<Class<?>> collect = Arrays.stream(Collections.class.getDeclaredClasses())
//                .filter(c -> Modifier.isPrivate(c.getModifiers()) && Modifier.isStatic(c.getModifiers())  && List.class.isAssignableFrom(c))
//                .collect(Collectors.toList());
//        System.out.println(collect);
        Arrays.stream(Collections.class.getDeclaredClasses())
                .filter(c -> Modifier.isPrivate(c.getModifiers()) && Modifier.isStatic(c.getModifiers()) && List.class.isAssignableFrom(c))
                .forEach(c -> {
                    try {
                        Constructor<?> constructor = null;
                        try {
                            constructor = c.getConstructor((Class<?>[]) null);
                        } catch (NoSuchMethodException e) {
                            System.out.println("Cannot get constructor with paramaters: null");
                            e.printStackTrace();
                        }
                        constructor.setAccessible(true);
                        List l;
                        try {
                            l = (List) constructor.newInstance();
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException("Cannot create an instance from constructor " + constructor);
                        }
                        l.get(0);
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(c.getSimpleName());
                    }
                });
        return null;
//        return Collections.EMPTY_LIST.getClass();
    }
}
