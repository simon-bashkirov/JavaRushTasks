package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("D:\\dev\\JavaRushTasks\\source_files\\task2002\\1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Vitaly");
            user.setLastName("Chura");
            user.setMale(true);
            user.setBirthDate(df.parse("03091990"));
            user.setCountry(User.Country.UKRAINE);

/*            User user2 = new User();
            user2.setFirstName("Ivan");
            user2.setLastName("Ivanov");
            user2.setMale(true);
            user2.setBirthDate(df.parse("05091994"));
            user2.setCountry(User.Country.OTHER);
            javaRush.users.add(user2);*/

            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            javaRush.printUsers();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            if (javaRush.equals(loadedObject)) System.out.println("class was loaded correctly");
            else System.out.println("class was NOT loaded correctly");
            loadedObject.printUsers();

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something wrong with my file");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Oops, something wrong with save/load method");
            e.printStackTrace();
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
//        SimpleDateFormat df;

        public JavaRush() {
//            df = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
//            printWriter.print(name + "@@@");
            if (users.size() > 0) {
                for (User u : users) {
                    printWriter.println((u.getFirstName() != null ? u.getFirstName() : " ") + "@@@" +
                            (u.getLastName() != null ? u.getLastName() : " ") + "@@@" +
                            u.isMale() + "@@@" +
//                            (u.getBirthDate() != null ? df.format(u.getBirthDate()) : " ") + "@@@" +
                            (u.getBirthDate() != null ? u.getBirthDate().getTime() : " ") + "@@@" +
                            (u.getCountry() != null ? u.getCountry() : " "));
                }
                printWriter.flush();
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()) {
                String[] arguments = bufferedReader.readLine().split("@@@");
                User user = new User();
                if (!arguments[0].equals(" ")) user.setFirstName(arguments[0]);
                if (!arguments[1].equals(" ")) user.setLastName(arguments[1]);
                if (!arguments[2].equals(" ")) user.setMale(Boolean.parseBoolean(arguments[2]));
//                if (!arguments[3].equals(" ")) user.setBirthDate(df.parse(arguments[3]));
                if (!arguments[3].equals(" ")) user.setBirthDate(new Date(Long.parseLong(arguments[3])));
                if (!arguments[4].equals(" ")) user.setCountry(User.Country.valueOf(arguments[4].toUpperCase()));
                users.add(user);
            }
            bufferedReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }

        public void printUsers() {
            System.out.println("Printing users:");
            for (User u : users) {
                System.out.println(u);
            }
        }
    }
}
