package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + ", i = " + i);
            try {
                Thread.sleep(1000/speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread t = new Thread(this);
        t.start();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution(2);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\dev\\JavaRushTasks\\source_files\\task2015\\1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        solution.writeObject(oos);
        oos.close();
        fileOutputStream.close();

        Thread.sleep(3000);
        FileInputStream fileInputStream = new FileInputStream("D:\\dev\\JavaRushTasks\\source_files\\task2015\\1.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Solution loadedSolution = (Solution) new Object();
        loadedSolution.readObject(ois);
        ois.close();
        fileInputStream.close();

//        System.out.println(object);
//        Solution loadedSolution = (Solution)object;
//        loadedSolution.start();
    }
}
