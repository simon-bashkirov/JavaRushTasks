package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
public class Shop {

    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + secretData.getClass().getSimpleName() + "@" + Arrays.toString(secretData) +
                '}';
    }

    static class Goods {
        public List<String> names;

        @Override
        public String toString() {
            return "Goods{" +
                    "names=" + names.getClass().getSimpleName() + "@" + names +
                    '}';
        }
    }
}
