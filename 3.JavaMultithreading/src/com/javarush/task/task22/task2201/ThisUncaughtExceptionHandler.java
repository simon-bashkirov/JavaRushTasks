package com.javarush.task.task22.task2201;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.err.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.err.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.err.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return t.getName() + " : " + e.getClass().getSimpleName() + " : " + e;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return e + " : " + e.getClass().getSimpleName() + " : " + t.getName();
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return e.getClass().getSimpleName() + " : " + e + " : " + t.getName();
    }

    // + " ??? " + e.getStackTrace()[0]
}

