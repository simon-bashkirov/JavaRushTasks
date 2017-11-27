package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName,true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\source_files\\task2022\\1.txt";
        String fileName_oos = "D:\\IdeaProjects\\JavaRushTasks\\source_files\\task2022\\2.txt";
        Solution solution = new Solution(fileName);
        solution.writeObject("one");

        //Serialize
        FileOutputStream fileOutputStream = new FileOutputStream(fileName_oos);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

//        A a = new A();
        oos.writeObject(solution);

        oos.close();
        fileOutputStream.close();

        //Deserialize
        FileInputStream fileInputStream = new FileInputStream(fileName_oos);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);

        Solution loadedSolution = (Solution)ois.readObject();

        ois.close();
        fileInputStream.close();

        loadedSolution.writeObject("two");
    }

    /*public static class A implements Serializable {
        String someText="Some text";
    }*/
}
