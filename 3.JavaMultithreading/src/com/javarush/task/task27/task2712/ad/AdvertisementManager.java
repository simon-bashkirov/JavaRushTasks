package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    int timeSeconds;
    private AdComparator adComparator = new AdComparator();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> advertisements = storage.list();
        if (advertisements.isEmpty())
            throw new NoVideoAvailableException();
        List<Advertisement> chosenAds = chooseAds(timeSeconds, advertisements.size(), advertisements).getAdvertisements();
        chosenAds.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int compare = -Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                return compare != 0 ? compare : Long.compare(o1.getAmountPerOneSec(), o2.getAmountPerOneSec());
            }

        });
        for (Advertisement advertisement : chosenAds) {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() + ", " + advertisement.getAmountPerOneSec());
            advertisement.revalidate();
        }
    }

    private AdvertisementHolder chooseAds(int timeSeconds, int n, List<Advertisement> advertisements) {
        if (n == 0 || timeSeconds == 0)
            return new AdvertisementHolder();
        else {
            Advertisement advertisement = advertisements.get(n - 1);
            if (advertisement.getDuration() > timeSeconds || advertisement.getHits() <= 0)
                return chooseAds(timeSeconds, n-1, advertisements);
            else {
                return adComparator.max(new AdvertisementHolder(advertisement).append(chooseAds(timeSeconds- advertisement.getDuration(), n-1, advertisements)),
                        chooseAds(timeSeconds, n-1, advertisements)
                );
            }
        }
    }


}
