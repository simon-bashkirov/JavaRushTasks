package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static final int SPACE = 32;
    public static final int RETURN = 13;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
//        String fileName1 = "D:\\dev\\JavaRushTasks\\source_files\\task1908\\1.txt";
//        String fileName2 = "D:\\dev\\JavaRushTasks\\source_files\\task1908\\2.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        AWord aWord = new AWord();
        while (bufferedReader.ready()) {
            char[] cbuf = new char[100];
            int count = bufferedReader.read(cbuf);
            for (int i = 0; i < count; i++) {
                if ((int)cbuf[i] == SPACE || (int)cbuf[i] == RETURN) {
                    if (aWord.isNumber()) {
                        bufferedWriter.write(aWord.getCharArray());
                        bufferedWriter.write(SPACE);
                    }
                    aWord.reset();
                } else if (!((int)cbuf[i] == 10)) {
                    aWord.append(cbuf[i]);
                }
            }
        }
        if (aWord.isNumber()) {
            bufferedWriter.write(aWord.getCharArray());
            bufferedWriter.write(SPACE);
        }
        aWord.reset();


        bufferedReader.close();
        bufferedWriter.close();

    }

    public static class AWord {
        private char[] charArray;

        public AWord() {
            charArray = new char[0];
        }

        public void append(char ch) {
            char[] tmpCharAray = new char[charArray.length+1];
            for (int i = 0; i < charArray.length; i++) tmpCharAray[i] = charArray[i];
            charArray = tmpCharAray;
            charArray[charArray.length-1] = ch;
        }

        public boolean isNumber() {
            boolean isNumber = true;
            for (char aCharArray : charArray) {
                if (!isSymbolADigit((int) aCharArray)) {
                    isNumber = false;
                    break;
                }
            }
            return isNumber;
        }

        public String getString() {
            String s = "";
            for (char aCharArray : charArray) {
                s += aCharArray;
            }
            return s;
        }

        public char[] getCharArray() {
            return charArray;
        }

/*        public String newWord() {
            if (this.isNumber()) return this.getString();
            this.reset();
        }*/

        public void reset() {
            charArray = new char[0];
        }
    }

    public static char[] copyArray(char[] sourceArray, int startIndex, int endIndex) {
        char copyOfArray[] = new char[endIndex-startIndex];
        int j = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            copyOfArray[j] = sourceArray[i];
        }
        return copyOfArray;
    }

    public static boolean isSymbolADigit(int a) {
        return a >= 48 && a <= 57;
    }

    public static boolean isNewLine(int a) {
        return a == 13 || a == 10;
    }
}
