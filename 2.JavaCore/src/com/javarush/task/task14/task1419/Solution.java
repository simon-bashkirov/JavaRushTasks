package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.net.SocketException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = null;
            s = s.toLowerCase();
        }
        catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            int[] a = new int[2];
            a[8] = 5;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);
        }
        catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        }
        catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            int[] a = new int[-1];
        }
        catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        try {
            throw new FileNotFoundException();
        }
        catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            throw new FileAlreadyExistsException("s");
        } catch (FileAlreadyExistsException e) {
            exceptions.add(e);
        }

        try {
            throw new SocketException();
        } catch (SocketException e) {
            exceptions.add(e);
        }

        try {
            throw new ArrayStoreException();
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }
    }
}
