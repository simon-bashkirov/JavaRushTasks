package com.javarush.task.task35.task3507;



import com.javarush.task.task35.task3507.data.Cat;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.stream.Collectors;

/* 
ClassLoader - что это такое?
*/
public class Solution {

    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        String packageName = pathToAnimals.replaceAll("/", ".").replaceFirst(".*.com", "com");

        Set<Animal> animals = new HashSet<>();

        File dirWithClasses = new File(pathToAnimals);
        File[] files = Objects.requireNonNull(dirWithClasses.listFiles());

        URL[] urls = new URL[files.length];
        String[] classNames = new String[files.length];

        try {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                urls[i] = file.toURI().toURL();
                classNames[i] = file.getName().replaceFirst(".class", "");
            }

            URLClassLoader cl = new URLClassLoader(urls);

            for (String className : classNames) {
                Class<?> aClass = cl.loadClass(packageName + "." + className);
                if ( Arrays.toString(aClass.getInterfaces())
                        .contains(Animal.class.getName())
                        ) {
                    try {
                        Animal a = (Animal) aClass.getConstructor((Class<?>[]) null).newInstance();
                        animals.add(a);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored) {
                    }
                }
            }
        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return animals;
    }
}
