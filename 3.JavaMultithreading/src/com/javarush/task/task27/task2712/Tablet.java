package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    private Order createOrderOfType(OrderType orderType) {
        Order order = null;
        try {
            order = orderType.newOrder(this);
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
            }
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60, toString());
            advertisementManager.processVideos();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    public Order createOrder() {
        return createOrderOfType(OrderType.NORMAL_ORDER);
    }

    public void createTestOrder(){
        createOrderOfType(OrderType.TEST_ORDER);
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    private enum OrderType {
        NORMAL_ORDER {
            @Override
            public Order newOrder(Tablet tablet) throws Exception {
                return new Order(tablet);
            }
        },
        TEST_ORDER {
            @Override
            public Order newOrder(Tablet tablet) throws Exception {
                return new TestOrder(tablet);
            }
        };

        public abstract Order newOrder(Tablet tablet) throws Exception;
    }
}
