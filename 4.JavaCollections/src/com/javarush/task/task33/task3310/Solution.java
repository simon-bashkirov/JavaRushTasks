package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        testStrategy(new OurHashMapStorageStrategy(), 10_000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        return strings.stream()
                .map(shortener::getId)
                .collect(Collectors.toSet());
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        return keys.stream()
                .map(shortener::getString)
                .collect(Collectors.toSet());
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Shortener shortener = new Shortener(strategy);
        Set<String> randomStrings = Stream.generate(Helper::generateRandomString)
                .limit(elementsNumber)
                .collect(Collectors.toSet());

        Date startDate = new Date();
        Set<Long> ids = getIds(shortener, randomStrings);
        Date endDate = new Date();
        Long msElapsed = endDate.getTime() - startDate.getTime();
        Helper.printMessage("getIds finished in " + msElapsed + "ms");

        startDate = new Date();
        Set<String> strings = getStrings(shortener, ids);
        endDate = new Date();
        msElapsed = endDate.getTime() - startDate.getTime();
        Helper.printMessage("getStrings finished in " + msElapsed + "ms");

        if (randomStrings.equals(strings)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
