package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;
    private int i;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        while (i < 15) {
            System.out.println(Thread.currentThread().getName() + ", i = " + i);
            try {
                Thread.sleep(1000/speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            i++;
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Saving solution...");
        out.defaultWriteObject();
        System.out.println("Saved solution.");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Loading solution...");
        in.defaultReadObject();
        Thread t = new Thread(this);
        t.start();
        System.out.println("Loaded solution.");
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution(2);

        Thread.sleep(1000);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\dev\\JavaRushTasks\\source_files\\task2015\\1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
//        solution.writeObject(oos);
        oos.writeObject(solution);
        oos.close();
        fileOutputStream.close();

//        solution.runner.interrupt();
        solution.runner.interrupt();
        Thread.sleep(1000);
        FileInputStream fileInputStream = new FileInputStream("D:\\dev\\JavaRushTasks\\source_files\\task2015\\1.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
//        Solution loadedSolution = (Solution) new Object();
//        loadedSolution.readObject(ois);
        Solution loadedSolution = (Solution)ois.readObject();
        ois.close();
        fileInputStream.close();


//        System.out.println(object);
//        Solution loadedSolution = (Solution)object;
//        loadedSolution.start();
    }
}
