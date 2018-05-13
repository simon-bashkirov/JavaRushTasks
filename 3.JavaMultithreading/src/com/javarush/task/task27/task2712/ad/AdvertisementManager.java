package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private AdCollectionComparator adCollectionComparator = new AdCollectionComparator();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> advertisements = advertisementStorage.list();
        if (advertisements.isEmpty())
            throw new NoVideoAvailableException();

        AdvertisementCollection optimalCollection = chooseAds(timeSeconds, advertisements.size(), advertisements);
        List<Advertisement> optimalVideoSet = optimalCollection.getCollection();

        optimalVideoSet.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int compare = -Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                return compare != 0 ? compare : Long.compare(o1.getAmountPerOneSec(), o2.getAmountPerOneSec());
            }

        });

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(optimalVideoSet, optimalCollection.getTotalPrice(), optimalCollection.getTotalDuration()));

        for (Advertisement advertisement : optimalVideoSet) {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() + ", " + advertisement.getAmountPerOneSec());
            advertisement.revalidate();
        }
    }

    private AdvertisementCollection chooseAds(int timeSeconds, int n, List<Advertisement> advertisements) {
        if (n == 0 || timeSeconds == 0)
            return new AdvertisementCollection();
        else {
            Advertisement advertisement = advertisements.get(n - 1);
            if (advertisement.getDuration() > timeSeconds || advertisement.getHits() <= 0)
                return chooseAds(timeSeconds, n-1, advertisements);
            else {
                return adCollectionComparator.max(new AdvertisementCollection(advertisement).append(chooseAds(timeSeconds- advertisement.getDuration(), n-1, advertisements)),
                        chooseAds(timeSeconds, n-1, advertisements)
                );
            }
        }
    }


}
