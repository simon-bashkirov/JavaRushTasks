package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(bufferedReader.readLine());
        bufferedReader.close();

        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
            return;
        }

        final AtomicLong foldersCnt = new AtomicLong();
        final AtomicLong filesCnt = new AtomicLong();
        final AtomicLong totalSize = new AtomicLong();

        SimpleFileVisitor<Path> simpleFileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                filesCnt.incrementAndGet();
                totalSize.addAndGet(Files.size(file));
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                foldersCnt.incrementAndGet();
                System.out.println("foldersCnt = " + foldersCnt + ", incremented for " + dir);
                return super.preVisitDirectory(dir, attrs);
            }

            /*@Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                foldersCnt.incrementAndGet();
                System.out.println("foldersCnt = " + foldersCnt + ", incremented for " + dir);
                return super.postVisitDirectory(dir, exc);
            }*/
        };

        Files.walkFileTree(path, simpleFileVisitor);

        System.out.println("Всего папок - " + foldersCnt.decrementAndGet());
        System.out.println("Всего файлов - " + filesCnt);
        System.out.println("Общий размер - " + totalSize);


    }
}
