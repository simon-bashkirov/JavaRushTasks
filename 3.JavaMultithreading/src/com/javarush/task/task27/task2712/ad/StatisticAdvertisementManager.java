package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    private List<Advertisement> getVideoSet(boolean isActiveFlag) {
        List<Advertisement> list = advertisementStorage.list();
        List<Advertisement> filteredVideoList = new ArrayList<>();
        for (Advertisement advertisement : list) {
            if (isActiveFlag ? advertisement.getHits() > 0 : advertisement.getHits() == 0)
                filteredVideoList.add(advertisement);
        }

        return filteredVideoList;
    }

    public List<Advertisement> getActiveVideoSet() {
        return getVideoSet(true);
    }

    public List<Advertisement> getArchivedVideoSet() {
        return getVideoSet(false);
    }

}
