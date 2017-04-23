package com.javarush.task.task14.task1408;

/**
 * Created by Vitaly on 4/22/2017.
 */
public class RussianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 60;
    }

    @Override
    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
