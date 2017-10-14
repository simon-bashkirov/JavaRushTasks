package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws Exception {
//        System.out.println(new Solution(4));
        Solution savedObject = new Solution(4);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\dev\\JavaRushTasks\\source_files\\task2014\\1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();
        fileOutputStream.close();

        Solution loadedObject = new Solution(1);

        FileInputStream fileInputStream = new FileInputStream("D:\\dev\\JavaRushTasks\\source_files\\task2014\\1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        loadedObject = (Solution)object;

        if (savedObject.string.equals(loadedObject.string)) System.out.println("Object was loaded correctly");
        else System.out.println("Object was NOT loaded correctly");
        System.out.println(savedObject);
        System.out.println(loadedObject);

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
