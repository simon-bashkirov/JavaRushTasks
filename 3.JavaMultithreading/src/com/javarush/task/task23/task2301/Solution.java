package com.javarush.task.task23.task2301;

import java.io.Externalizable;

/*
Запрети наследование
*/
public class Solution {

    public static final class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    /*public static class ExtendedListener extends Listener {

    }*/

    public static void main(String[] args) {
        /*Listener listener = new Listener();
        System.out.println(listener);
        ExtendedListener extendedListener = new ExtendedListener();
        System.out.println(extendedListener);*/
    }
}
