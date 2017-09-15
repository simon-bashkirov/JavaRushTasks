package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws Exception {
/*        Scanner sc = new Scanner(new FileInputStream("D:\\IdeaProjects\\JavaRushTasks\\source_files\\task1904.txt"));
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(sc);
        while(sc.hasNextLine()) {
            System.out.println(personScannerAdapter.read());
        }
        personScannerAdapter.close();*/
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            DateFormat df = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
            String row = fileScanner.nextLine();
            String[] fields = row.split(" ");
            String firstName = fields[1];
            String lastName = fields[0];
            String middleName = fields[2];
            Date bd = null;
            try {
                bd = df.parse(fields[3] + fields[4] + fields[5]);
            } catch (ParseException e) { e.printStackTrace(); }
            return new Person(firstName,middleName,lastName,bd);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
