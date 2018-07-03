package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(1, "First"), Second.class);
        First f = (First) convertOneToAnother(new Second(2, "Second"), First.class);
        System.out.println(s + "\n" + f);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        StringWriter stringWriter = new StringWriter();

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(stringWriter, one);

        String s = stringWriter.toString();
        s = s.replaceFirst(one.getClass().getSimpleName(), resultClassObject.getSimpleName());

        System.out.println(s);

        StringReader stringReader = new StringReader(s);

        return objectMapper.readValue(stringReader, resultClassObject);
//        return null;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
    public static class First {
        public int i;
        public String name;

        public First() {
        }

        public First(int i) {
            this.i = i;
        }

        public First(int i, String name) {
            this.i = i;
            this.name = name;
        }

        @Override
        public String toString() {
            return "First{" +
                    "i=" + i +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
    public static class Second {
        public int i;
        public String name;

        public Second() {
        }

        public Second(int i) {
            this.i = i;
        }

        public Second(int i, String name) {
            this.i = i;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Second{" +
                    "i=" + i +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
