package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private StatisticManager statisticManager = StatisticManager.getInstance();

    public OrderManager() {

        Thread orderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    outer:
                    while ( orderQueue.peek() != null) {
                        for (Cook cook : cooks()) {
                            if (!cook.isBusy()) {
                                Order finalPoll = orderQueue.poll();
                                Thread cookThread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        cook.startCookingOrder(finalPoll);
                                    }
                                });
                                cookThread.setDaemon(true);
                                cookThread.start();
                                continue outer;
                            }
                        }
                        break;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        orderThread.setDaemon(true);
        orderThread.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        orderQueue.add((Order) arg);
    }


    public Set<Cook> cooks() {
        return statisticManager.getCooks();
    }
}
