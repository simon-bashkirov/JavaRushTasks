package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        for (Thread t : threads) {
            t.start();
        }
    }

    public static class Thread1 extends Thread {
        public Thread1() {
            super();
            super.setName(this.getClass().getSimpleName());
        }

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Thread2 extends Thread {
        public Thread2() {
            super();
            super.setName(this.getClass().getSimpleName());
        }

        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        public Thread3() {
            super();
            super.setName(this.getClass().getSimpleName());
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        public Thread4() {super();
            super.setName(this.getClass().getSimpleName());
        }

        @Override
        public void run() {
            showWarning();
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class Thread5 extends Thread {
        public Thread5() {
            super();
            super.setName(this.getClass().getSimpleName());
        }

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int inputSum = 0;
            try {
                while (true) {
                    String s = reader.readLine();
//                    System.out.println("STRING IS: \"" + s + "\"");
                    try {
                        inputSum += Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        if (s.equals("N")) {
                            System.out.println(inputSum);
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println(getName() + " died");
        }
    }
}