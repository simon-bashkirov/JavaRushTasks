package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = reader.readLine();
            if (input.equals("exit")) break;
            else if (!input.isEmpty()) {
                ReadThread t = new ReadThread(input);
                t.start();
            }
        }

        reader.close();
        for (String fileName : resultMap.keySet()) {
            System.out.println(fileName + ": " + (char)(int)resultMap.get(fileName));
        }

    }

    public static class ReadThread extends Thread {
        public String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            HashMap<Integer, Integer> byteCount = new LinkedHashMap<>();
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    if (!byteCount.containsKey(data)) byteCount.put(data, 1);
                    else byteCount.put(data, byteCount.get(data) + 1);
                }
                int mostMetByte=0;
                int count=0;
                for (Map.Entry<Integer,Integer> pair : byteCount.entrySet()) {
                    int key = pair.getKey();
                    int value=pair.getValue();
                    if (value>count) {
                        mostMetByte=key;
                        count=value;
                    }
                }
                synchronized (this) {
                    resultMap.put(fileName, mostMetByte);
                }
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
