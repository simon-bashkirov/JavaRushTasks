package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = objectMapper.readValue(new File(fileName), clazz);
        return t;
    }

    public static void main(String[] args) throws Exception {
        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task3303\\1.txt";

        /*Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(fileWriter, cat);
        }*/

        Cat cat1 = convertFromJsonToNormal(fileName, Cat.class);

        System.out.println(cat1);
    }
}
