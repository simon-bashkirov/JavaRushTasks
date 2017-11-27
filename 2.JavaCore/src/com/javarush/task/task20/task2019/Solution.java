package com.javarush.task.task20.task2019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Исправить ошибку. Сериализация
*/
public class Solution implements Serializable {
    public static String fileName="D:\\IdeaProjects\\JavaRushTasks\\source_files\\task2019\\1.txt";
    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

//        System.out.println(solution.m); //debug

        //loading
        FileInputStream fiStream = new FileInputStream(fileName);
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

//        System.out.println(loadedObject.m); //debug
        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
