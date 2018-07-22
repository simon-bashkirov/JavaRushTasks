package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        logger.debug("Initiating this.value1 to " + value1 + ", this.value2 to " + value2 + ", this.value3 to " + value3);
    }

    public static void main(String[] args) {
        logger.info("Entering main");
        Solution solution = new Solution(1, "String value2", new Date());
        solution.divide(1, 0);
        solution.printString();
        solution.printDateAsLong();
        solution.calculateAndSetValue3(777L);
    }

    public void calculateAndSetValue3(long value) {
        logger.trace("inside calculateAndSetValue3(long value) with value = " + value);
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("Changed value1 to " + (int) (value / Integer.MAX_VALUE));
        } else {
            value1 = (int) value;
            logger.debug("Changed value1 to " + (int) value);
        }
    }

    public void printString() {
        logger.trace("inside printString() with value2 = " + value2);
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("inside printDateAsLong() with value3 = " + value3);
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("inside divide(int number1, int number2) with number1 = " + number2 + ", number2 = " + number2);
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("Oops, some ArithmeticException", e);
        }
    }

    public void setValue1(int value1) {
        logger.debug("Changing " + this.value1 + " to " + value1);
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug("Changing " + this.value2 + " to " + value2);
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        logger.debug("Changing " + this.value3 + " to " + value3);
        this.value3 = value3;
    }
}
