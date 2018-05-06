package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AdvertisementCollection {
    private List<Advertisement> advertisements;

    AdvertisementCollection() {
        advertisements = new ArrayList<>();
    }

    AdvertisementCollection(Advertisement... advertisements) {
        this.advertisements = new ArrayList<>(Arrays.asList(advertisements));
    }

    AdvertisementCollection(List<Advertisement> advertisements) {
        this.advertisements.addAll(advertisements);
    }

    AdvertisementCollection append(Advertisement... advertisements) {
        this.advertisements = new ArrayList<>(Arrays.asList(advertisements));
        return this;
    }

    AdvertisementCollection append(List<Advertisement> advertisements) {
        try {
            this.advertisements.addAll(advertisements);
        } catch (UnsupportedOperationException e) {
            System.out.println(this.advertisements.getClass());
            throw e;
        }
        return this;
    }

    AdvertisementCollection append(AdvertisementCollection collection) {
        append(collection.getCollection());
        return this;
    }

    List<Advertisement> getCollection() {
        return advertisements;
    }

    public long getTotalPrice() {
        long totalPrice = 0;
        for (Advertisement advertisement : advertisements) {
            totalPrice += advertisement.getAmountPerOneDisplaying();
        }
        return totalPrice;
    }

    public int getTotalDuration() {
        int totalDuration = 0;
        for (Advertisement advertisement : advertisements) {
            totalDuration += advertisement.getDuration();
        }
        return totalDuration;
    }

    public int size() {
        return advertisements.size();
    }
}
