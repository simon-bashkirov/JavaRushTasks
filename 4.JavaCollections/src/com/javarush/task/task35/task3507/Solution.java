package com.javarush.task.task35.task3507;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.stream.Collectors;

import com.javarush.task.task35.task3507.data.Cat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 
ClassLoader - что это такое?
*/
public class Solution {

    private static final Logger LOG = LoggerFactory.getLogger(Solution.class);

    public static void main(String[] args) throws Exception {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException {
        LOG.debug("pathToAnimals = " + pathToAnimals);

        if (pathToAnimals.endsWith("/")) {
            pathToAnimals = pathToAnimals.substring(0, pathToAnimals.length() - 1);
        }

        CustomClassLoader cl = new CustomClassLoader(pathToAnimals);
        Set<Class> classes = cl.loadAllClasses();

        Set<Animal> animals = new HashSet<>();

        for (Class<?> aClass : classes) {
            try {
                if (Animal.class.isAssignableFrom(aClass)) {
                    for (Constructor<?> constructor : aClass.getConstructors()) {
                        if (constructor.getParameterCount() == 0) {
                            Animal animal = (Animal) constructor.newInstance();
                            animals.add(animal);
                        }
                    }
                }
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return animals;
    }
}
