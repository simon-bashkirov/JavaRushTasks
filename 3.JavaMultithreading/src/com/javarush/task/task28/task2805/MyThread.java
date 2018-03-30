package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static Integer priorityIntValue = 0;

    {
        /*setPriority(priorityIntValue++ <  getThreadGroup().getMaxPriority() ? priorityIntValue : getThreadGroup().getMaxPriority());*/
        /*setPriority(++priorityIntValue);
        if (priorityIntValue == 10)
            priorityIntValue = 0;*/
        /*setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));*/
        setPriority(priorityIntValue < 10 ? ++priorityIntValue : (priorityIntValue = 1));
    }

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
