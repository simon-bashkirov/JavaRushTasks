package com.javarush.task.task27.task2707;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        final boolean[] b = {false};
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1,o2);
                b[0] = true;
            }
        });
        t1.setDaemon(true);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });
        t2.setDaemon(true);

        synchronized (o1) {
            t1.start();
            t2.start();
            Thread.sleep(1);
        }
        synchronized (o1) {

        }


        return t1.isAlive();
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
