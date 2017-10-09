package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws Exception {
//        args = new String[2];
//        args[0] = "tag";
        String tag = args[0];
        ArrayList<String> open_tags = new ArrayList<>();
        ArrayList<String> closed_tags = new ArrayList<>();
        boolean inside_tag = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "D:\\dev\\JavaRushTasks\\source_files\\task1918\\2.txt";
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedFileReader = new BufferedReader(fileReader);

        while (bufferedFileReader.ready()) {
            String lineString = bufferedFileReader.readLine();
            String[] s = lineString.split("");
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("<")) {
                    if (lineString.substring(i + 1, i + 1 + tag.length()).equals(tag))  {
                        inside_tag = true;
                        for (int j = 0; j < open_tags.size(); j++) {
                            open_tags.set(j,open_tags.get(j)+lineString.substring(i, i + 1 + tag.length()));
                        }
                        open_tags.add(lineString.substring(i, i + 1 + tag.length()));
                        i += tag.length();
                    } else {
                        addCurrentSymbol(open_tags, s[i]);
                    }
                } else if (s[i].equals(">")) {
                    if (lineString.substring(i - 1 - tag.length() , i).equals("/" + tag))  {
                        addCurrentSymbol(open_tags, s[i]);
                        closed_tags.add(0,open_tags.get(open_tags.size()-1));
                        open_tags.remove(open_tags.size()-1);
                        if (open_tags.size() == 0) {
                            for (String tag_body : closed_tags) {
                                System.out.println(tag_body);
                            }
                            closed_tags.clear();
                            inside_tag = false;
                        }
                    } else {
                        addCurrentSymbol(open_tags, s[i]);
                    }
                } else if (inside_tag) {
                    addCurrentSymbol(open_tags, s[i]);
                }
            }
        }

        fileReader.close();
        bufferedFileReader.close();

    }

    public static void addCurrentSymbol(ArrayList<String> open_tags, String s) {
        for (int j = 0; j < open_tags.size(); j++) {
            open_tags.set(j,open_tags.get(j)+s);
        }
    }
}
