package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws Exception {
/*        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\source_files\\task2021\\1.txt";
        SubSolution subSolution = new SubSolution();

        FileOutputStream fileOutput = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutput);

        oos.writeObject(subSolution);

        oos.close();
        fileOutput.close();

        FileInputStream fiStream = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fiStream);

        SubSolution loadedSubSolution = (SubSolution)ois.readObject();

        ois.close();
        fiStream.close();*/
    }
}
