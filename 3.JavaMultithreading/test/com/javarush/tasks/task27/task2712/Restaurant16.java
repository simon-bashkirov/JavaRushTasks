package com.javarush.tasks.task27.task2712;

import com.javarush.task.task27.task2712.DirectorTablet;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Restaurant16 {

    public static void main(String[] args) throws Exception {
        test2();
    }
    
    public static void test1() throws Exception {
        StatisticManager instance = StatisticManager.getInstance();
                
        class VideoSelectedEventDataRowTest extends VideoSelectedEventDataRow {

            public VideoSelectedEventDataRowTest(List<Advertisement> optimalVideoSet, long amount, int totalDuration, Date date) {
                super(optimalVideoSet, amount, totalDuration);
                Field date1;
                try {
                    date1 = this.getClass().getSuperclass().getDeclaredField("currentDate");
                    date1.setAccessible(true);
                    date1.set(this, date);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        try {
            instance.register(new VideoSelectedEventDataRowTest(advertisements, 120, 180, df.parse("14-May-2013 14:03")));
            instance.register(new VideoSelectedEventDataRowTest(advertisements, 130, 180, df.parse("14-May-2013 17:05")));
            instance.register(new VideoSelectedEventDataRowTest(advertisements, 102, 180, df.parse("13-May-2013 07:02")));
            instance.register(new VideoSelectedEventDataRowTest(advertisements, 54000, 180, df.parse("12-May-2013 11:07")));
            instance.register(new VideoSelectedEventDataRowTest(advertisements, 300, 180, df.parse("12-May-2013 13:09")));
            instance.register(new VideoSelectedEventDataRowTest(advertisements, 98, 180, df.parse("12-May-2013 15:08")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
    }

    public static void test2() {
        StatisticManager instance = StatisticManager.getInstance();

        class CookedOrderEventDataRowTest extends CookedOrderEventDataRow {

            public CookedOrderEventDataRowTest(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishes, Date date) {
                super(tabletName, cookName, cookingTimeSeconds, cookingDishes);
                Field date1;
                try {
                    date1 = this.getClass().getSuperclass().getDeclaredField("currentDate");
                    date1.setAccessible(true);
                    date1.set(this, date);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh:mm");

        Tablet t1 = new Tablet(1);
        Tablet t2 = new Tablet(2);

        Cook ivanov = new Cook("Ivanov");
        Cook petrov = new Cook("Petrov");

        ArrayList<Dish> dishes = new ArrayList<>();

        try {
            instance.register(new CookedOrderEventDataRowTest(t1.toString(), ivanov.toString(), 1200, dishes, df.parse("14-May-2013 14:03")));
            instance.register(new CookedOrderEventDataRowTest(t1.toString(), ivanov.toString(), 2400, dishes, df.parse("14-May-2013 15:03")));
            instance.register(new CookedOrderEventDataRowTest(t2.toString(), petrov.toString(), 2100, dishes, df.parse("14-May-2013 12:03")));

            instance.register(new CookedOrderEventDataRowTest(t1.toString(), ivanov.toString(), 1200, dishes, df.parse("13-May-2013 11:01")));
            instance.register(new CookedOrderEventDataRowTest(t1.toString(), ivanov.toString(), 1200, dishes, df.parse("13-May-2013 12:03")));
            instance.register(new CookedOrderEventDataRowTest(t1.toString(), ivanov.toString(), 1200, dishes, df.parse("13-May-2013 16:04")));
            instance.register(new CookedOrderEventDataRowTest(t1.toString(), ivanov.toString(), 540, dishes, df.parse("13-May-2013 17:05")));

            instance.register(new CookedOrderEventDataRowTest(t1.toString(), ivanov.toString(), 300, dishes, df.parse("12-May-2013 19:05")));
            instance.register(new CookedOrderEventDataRowTest(t2.toString(), petrov.toString(), 360, dishes, df.parse("12-May-2013 11:05")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printCookWorkloading();
    }
}
