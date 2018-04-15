package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 9 && !Thread.currentThread().isInterrupted())  {
            System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
            //Метод System.out.format("Элемент 'ShareItem-N' добавлен") должен быть вызван.
            queue.offer(new ShareItem("ShareItem-" + i, i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (queue.hasWaitingConsumer())
                System.out.format("Consumer в ожидании!%n");
            i++;
        }
    }
}
