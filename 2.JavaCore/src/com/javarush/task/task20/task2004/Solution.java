package com.javarush.task.task20.task2004;

import java.io.*;
import java.util.Properties;

/* 
Читаем и пишем в файл статики
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

//            File your_file_name = File.createTempFile("your_file_name", null);
            String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task2003\\1.txt";
            File your_file_name = new File(fileName);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            System.out.println("classWithStatic: " + classWithStatic);

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            System.out.println("loadedObject before load: " + loadedObject);

            loadedObject.load(inputStream);
            if (classWithStatic.equals(loadedObject)) System.out.println("class was loaded correctly");
            else System.out.println("class was NOT loaded correctly");

            System.out.println("loadedObject after load: " + loadedObject);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
            e.printStackTrace();
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
        Properties prop;

        public ClassWithStatic() {
            prop = new Properties();
        }

        public void save(OutputStream outputStream) throws Exception {
            prop.setProperty("staticString",staticString);
            prop.setProperty("i",String.valueOf(i));
            prop.setProperty("j",String.valueOf(j));
            prop.store(outputStream, null);
        }

        public void load(InputStream inputStream) throws Exception {
            prop.load(inputStream);
            staticString = prop.getProperty("staticString");
            i = Integer.parseInt(prop.getProperty("i"));
            j = Integer.parseInt(prop.getProperty("j"));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        @Override
        public String toString() {
            return "ClassWithStatic. staticString = \"" + staticString + "\", i=" + i + ", j=" + j;
        }
    }
}
