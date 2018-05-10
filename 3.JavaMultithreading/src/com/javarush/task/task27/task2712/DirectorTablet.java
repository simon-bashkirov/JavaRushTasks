package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.DateHolder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.sql.SQLOutput;
import java.util.*;

public class DirectorTablet {
    private final StatisticManager instance = StatisticManager.getInstance();

    public void printAdvertisementProfit() {
        NavigableMap<DateHolder, Long> profitPerDayMap = new TreeMap<>(instance.getAdvertisementProfit()).descendingMap();
        double totalProfit = 0;

        for (Map.Entry<DateHolder, Long> entryDateLong : profitPerDayMap.entrySet()) {
            String date = entryDateLong.getKey().getDateAsString();
            Double profit = entryDateLong.getValue() / 100.0;
            totalProfit += profit;

            ConsoleHelper.writeMessage(String.format("%s - %.2f", date, profit));
        }

        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalProfit));
    }

    public void printCookWorkloading() {
        NavigableMap<DateHolder, Map<String, Integer>> workloadMap = new TreeMap<>(instance.getWorkload()).descendingMap();

        for (Map.Entry<DateHolder, Map<String, Integer>> entryDateMap : workloadMap.entrySet()) {
            ConsoleHelper.writeMessage(entryDateMap.getKey().getDateAsString());

            for (Map.Entry<String, Integer> entryStringInteger : new TreeMap<>(entryDateMap.getValue()).entrySet()) {
                String cookName = entryStringInteger.getKey();
                Integer totalWorkingTime = entryStringInteger.getValue();

                ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, totalWorkingTime / 60));
            }

            ConsoleHelper.writeMessage("");
        }

    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet() {

    }
}
