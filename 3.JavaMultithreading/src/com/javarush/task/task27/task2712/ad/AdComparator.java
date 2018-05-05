package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;
import java.util.List;

class AdComparator implements Comparator<List<Advertisement>> {
    private Comparator<List<Advertisement>> compareByTotalPrice = new Comparator<List<Advertisement>>() {
        @Override
        public int compare(List<Advertisement> o1, List<Advertisement> o2) {
            int o1TotalPrice = 0;
            for (Advertisement advertisement : o1) {
                o1TotalPrice += advertisement.getAmountPerOneDisplaying();
            }

            int o2TotalPrice = 0;
            for (Advertisement advertisement : o2) {
                o2TotalPrice += advertisement.getAmountPerOneDisplaying();
            }

            return Integer.compare(o1TotalPrice, o2TotalPrice);
        }
    };

    private Comparator<List<Advertisement>> compareByTotalDuration = new Comparator<List<Advertisement>>() {
        @Override
        public int compare(List<Advertisement> o1, List<Advertisement> o2) {
            int o1TotalDuration = 0;
            for (Advertisement advertisement : o1) {
                o1TotalDuration += advertisement.getDuration();
            }

            int o2TotalDuration = 0;
            for (Advertisement advertisement : o2) {
                o2TotalDuration += advertisement.getDuration();
            }

            return Integer.compare(o1TotalDuration, o2TotalDuration);
        }
    };

    private Comparator<List<Advertisement>> compareByAdCount = new Comparator<List<Advertisement>>() {
        @Override
        public int compare(List<Advertisement> o1, List<Advertisement> o2) {
            return -Integer.compare(o1.size(), o2.size());
        }
    };

    private Comparator<List<Advertisement>>[] comparators = new Comparator[]{compareByTotalPrice, compareByTotalDuration, compareByAdCount};

    @Override
    public int compare(List<Advertisement> o1, List<Advertisement> o2) {
        int compare = 0;
        for (Comparator comparator : comparators) {
            compare = comparator.compare(o1,o2);
            if (compare != 0) {
                break;
            }
        }
        return compare;
    }

    public AdvertisementHolder max(AdvertisementHolder o1, AdvertisementHolder o2) {
        int compare = compare(o1.getAdvertisements(), o2.getAdvertisements());
        return compare >= 0 ? o1 : o2;
    }

}
