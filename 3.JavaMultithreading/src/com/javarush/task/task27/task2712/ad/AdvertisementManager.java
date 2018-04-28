package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> advertisements = storage.list();
        if (advertisements.isEmpty())
            throw new NoVideoAvailableException();
        /*Collections.sort(advertisements, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return 0;
            }
        });
        for (Advertisement advertisement : advertisements) {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... " + advertisement.getAmountPerOneDisplaying() + ", " + (advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
        }*/
    }
}
