package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws Exception {
        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("Diego");
        cook1.setQueue(orderQueue);
        cook2.setQueue(orderQueue);

        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        List<Tablet> tablets = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.setQueue(orderQueue);
        }

        Thread cookThread1 = new Thread(cook1);
        cookThread1.start();
        Thread cookThread2 = new Thread(cook1);
        cookThread2.start();

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(randomOrderGeneratorTask);
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();
        cookThread1.interrupt();
        cookThread2.interrupt();

        /*DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();*/
    }

}
