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
        final Boolean[] flag = {null};
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        solution.someMethodWithSynchronizedBlocks(o1, o2);
//                        System.out.println("t2 done");
                    }
                });
                t2.setDaemon(true);
                t2.start();
                synchronized (o2) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (o1) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag[0] = !t2.isAlive();
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
        while (flag[0] == null) {
            Thread.sleep(1);
        }
        return flag[0];
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
