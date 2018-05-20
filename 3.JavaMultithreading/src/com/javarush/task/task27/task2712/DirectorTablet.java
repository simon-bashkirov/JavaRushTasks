package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.statistic.DateHolder;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {
    private final StatisticManager statisticManager = StatisticManager.getInstance();
    private final StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
    private Comparator<Advertisement> adNameComparator = new Comparator<Advertisement>() {
        @Override
        public int compare(Advertisement o1, Advertisement o2) {
            return o1.getName().toLowerCase().
                    compareTo(o2.getName().toLowerCase());
        }
    };

    public void printAdvertisementProfit() {
        ConsoleHelper.writeMessage("AdvertisementProfit:");

        NavigableMap<DateHolder, Long> profitPerDayMap = new TreeMap<>(statisticManager.getAdvertisementProfit()).descendingMap();
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
        ConsoleHelper.writeMessage("CookWorkloading");

        NavigableMap<DateHolder, Map<String, Integer>> workloadMap = new TreeMap<>(statisticManager.getWorkload()).descendingMap();

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
        ConsoleHelper.writeMessage("ActiveVideoSet");

        List<Advertisement> activeVideoSet = statisticAdvertisementManager.getActiveVideoSet();
        Collections.sort(activeVideoSet, adNameComparator);
        for (Advertisement advertisement : activeVideoSet) {
            ConsoleHelper.writeMessage(String.format("%s - %d", advertisement.getName(), advertisement.getHits()));
        }
    }

    public void printArchivedVideoSet() {
        ConsoleHelper.writeMessage("ArchivedVideoSet");

        List<Advertisement> archivedVideoSet = statisticAdvertisementManager.getArchivedVideoSet();
        Collections.sort(archivedVideoSet, adNameComparator);
        for (Advertisement advertisement : archivedVideoSet) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
