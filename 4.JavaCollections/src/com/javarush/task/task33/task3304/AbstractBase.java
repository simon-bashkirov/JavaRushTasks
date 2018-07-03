package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonSubTypes;


public abstract class AbstractBase {

    public int i;
    public String s;

    public AbstractBase() {
    }

    public AbstractBase(int i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return "AbstractBase1{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {

        First first = new First(1, "one");
        Second second = new Second(1, "two");
        System.out.println(first);
        System.out.println(second);

        ObjectMapper om = new ObjectMapper();

        // Test Foo:
        String foojson = om.writeValueAsString(first);
        System.out.println(foojson);
        AbstractBase fooDeserialised = om.readValue(foojson, First.class);
        System.out.println(fooDeserialised);

        // Test Bar:
        String barjson = om.writeValueAsString(second);
        System.out.println(barjson);
        AbstractBase barDeserialised = om.readValue(barjson, Second.class);
        System.out.println(barDeserialised);

    }

    @JsonTypeInfo(use = Id.NAME, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = First.class, name = "First"),
            @JsonSubTypes.Type(value = Second.class, name = "Second")
    })
    static class First extends AbstractBase {

        public First(int i, String s) {
            super(i, s);
        }

        public First() {}

        @Override
        public String toString() {
            return "First{" +
                    "i=" + i +
                    ", s='" + s + '\'' +
                    '}';
        }
    }

    static class Second extends AbstractBase {

        public Second(int i, String s) {
            super(i, s);
        }

        public Second() {}

        @Override
        public String toString() {
            return "Second{" +
                    "i=" + i +
                    ", s='" + s + '\'' +
                    '}';
        }
    }

}

