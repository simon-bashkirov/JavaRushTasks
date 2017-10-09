package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = reader.readLine();
//        String file2 = reader.readLine();
        String file1 = "D:\\dev\\JavaRushTasks\\source_files\\task1916\\1_final_test.txt";
        String file2 = "D:\\dev\\JavaRushTasks\\source_files\\task1916\\2_final_test.txt";
        reader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));

        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();

        while (bufferedReader1.ready() || bufferedReader2.ready()) {
            if (bufferedReader1.ready()) s1.add(bufferedReader1.readLine());
            if (bufferedReader2.ready()) s2.add(bufferedReader2.readLine());

            if (s1.size() > 0 && s2.size() > 0) {
                outer:
                for (int i = 0; i < s1.size(); i++) {
                    for (int j = 0; j < s2.size(); j++) {
                        if (s1.get(i).equals(s2.get(j))) {
                            if (i == j && i == 0) {
                                lines.add(new LineItem(Type.SAME, s1.get(i)));
//                                System.out.println(Type.SAME + " " + s1.get(i) + ": " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "...s1:" + s1 + ", s2:" + s2);
                                s1.remove(0);
                                s2.remove(0);
                                break outer;
                            } else if (i == j && i > 0) {
                                for (int z = 0; z < i; z++) {
                                    lines.add(new LineItem(Type.REMOVED, s1.get(z)));
//                                    System.out.println(Type.REMOVED + " " + s1.get(z) + ": " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "...s1:" + s1 + ", s2:" + s2);
                                    lines.add(new LineItem(Type.ADDED, s2.get(z)));
//                                    System.out.println(Type.ADDED + " " + s2.get(z) + ": " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "...s1:" + s1 + ", s2:" + s2);
                                }
                                lines.add(new LineItem(Type.SAME, s1.get(i)));
//                                System.out.println(Type.SAME + " " + s1.get(i) + ": " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "...s1:" + s1 + ", s2:" + s2);
                                s1.clear();
                                s2.clear();

                            }
                            else {
                                ArrayList<String> s_with_higher_index = null;
                                ArrayList<String> s_with_lower_index = null;
                                Type type = null;
                                int index = 0;
                                if (i > j) {
                                    s_with_higher_index = s1;
                                    s_with_lower_index = s2;
                                    type = Type.REMOVED;
                                    index = i;
                                } else if (i < j) {
                                    s_with_higher_index = s2;
                                    s_with_lower_index = s1;
                                    type = Type.ADDED;
                                    index = j;
                                }
                                for (int z = 0; z < index; z++) {
                                    lines.add(new LineItem(type, s_with_higher_index.get(z)));
//                                    System.out.println(type + " " + s_with_higher_index.get(z) + ": " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "...s1:" + s1 + ", s2:" + s2);
                                }
                                lines.add(new LineItem(Type.SAME, s_with_higher_index.get(index)));
//                                System.out.println(Type.SAME + " " + s_with_higher_index.get(index) + ": " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "...s1:" + s1 + ", s2:" + s2);
                                for (int z = 0; z <= index; z++) s_with_higher_index.remove(0);
                                s_with_lower_index.remove(0);
                                break outer;
                            }
                        }
 /*                       } catch (IndexOutOfBoundsException e) {
                            System.out.println("i = " + i + ", j = " + j + ", s1.size() = " + s1.size() + ", s2.size() = " + s2.size());
                            e.printStackTrace();
                            return;
                        }*/
                    }
                }
            } else {
                ArrayList<String> s_not_empty = null;
                Type type = null;
                if (s1.size() > 0) {
                    s_not_empty = s1;
                    type = Type.REMOVED;
                } else {
                    s_not_empty = s2;
                    type = Type.ADDED;
                }
                for (String s : s_not_empty) {
                    lines.add(new LineItem(type, s));
//                    System.out.println(type + " " + s + ": " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "...s1:" + s1 + ", s2:" + s2);
                }
                s_not_empty.clear();
            }
        }

        for (String s : s1) {
            lines.add(new LineItem(Type.REMOVED, s));
//            System.out.println(Type.REMOVED + " " + s + ": " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "...s1:" + s1 + ", s2:" + s2);
        }
        for (String s : s2) {
            lines.add(new LineItem(Type.ADDED, s));
//            System.out.println(Type.ADDED + " " + s + ": " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "...s1:" + s1 + ", s2:" + s2);
        }

        bufferedReader1.close();
        bufferedReader2.close();

        for (LineItem l : lines) {
            System.out.println(l.type + " " + l.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
