package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;
import java.util.List;

class AdComparator implements Comparator<AdvertisementCollection> {
    private Comparator<AdvertisementCollection> compareByTotalPrice = new Comparator<AdvertisementCollection>() {
        @Override
        public int compare(AdvertisementCollection o1, AdvertisementCollection o2) {
            return Long.compare(o1.getTotalPrice(), o2.getTotalPrice());
        }
    };

    private Comparator<AdvertisementCollection> compareByTotalDuration = new Comparator<AdvertisementCollection>() {
        @Override
        public int compare(AdvertisementCollection o1, AdvertisementCollection o2) {
            return Integer.compare(o1.getTotalDuration(), o2.getTotalDuration());
        }
    };

    private Comparator<AdvertisementCollection> compareByAdCount = new Comparator<AdvertisementCollection>() {
        @Override
        public int compare(AdvertisementCollection o1, AdvertisementCollection o2) {
            return -Integer.compare(o1.size(), o2.size());
        }
    };

    private Comparator<AdvertisementCollection>[] comparators = new Comparator[]{compareByTotalPrice, compareByTotalDuration, compareByAdCount};

    @Override
    public int compare(AdvertisementCollection o1, AdvertisementCollection o2) {
        int compare = 0;
        for (Comparator comparator : comparators) {
            compare = comparator.compare(o1,o2);
            if (compare != 0) {
                break;
            }
        }
        return compare;
    }

    public AdvertisementCollection max(AdvertisementCollection o1, AdvertisementCollection o2) {
        return compare(o1, o2) >= 0 ? o1 : o2;
    }

}
