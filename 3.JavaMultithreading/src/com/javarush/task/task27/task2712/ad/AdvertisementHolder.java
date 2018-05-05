package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AdvertisementHolder {
    List<Advertisement> advertisements;

    AdvertisementHolder() {
        advertisements = new ArrayList<>();
    }

    AdvertisementHolder(Advertisement... advertisements) {
        this.advertisements = new ArrayList<>(Arrays.asList(advertisements));
    }

    AdvertisementHolder(List<Advertisement> advertisements) {
        this.advertisements.addAll(advertisements);
    }

    AdvertisementHolder append(Advertisement... advertisements) {
        this.advertisements = new ArrayList<>(Arrays.asList(advertisements));
        return this;
    }

    AdvertisementHolder append(List<Advertisement> advertisements) {
        try {
            this.advertisements.addAll(advertisements);
        } catch (UnsupportedOperationException e) {
            System.out.println(this.advertisements.getClass());
            throw e;
        }
        return this;
    }

    AdvertisementHolder append(AdvertisementHolder holder) {
        append(holder.getAdvertisements());
        return this;
    }

    List<Advertisement> getAdvertisements() {
        return advertisements;
    }
}
