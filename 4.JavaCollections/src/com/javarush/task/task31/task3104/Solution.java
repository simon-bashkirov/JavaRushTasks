package com.javarush.task.task31.task3104;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Поиск скрытых файлов
*/
public class Solution extends SimpleFileVisitor<Path> {
    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();
        Files.walkFileTree(Paths.get("D:\\dev\\JavaRushTasks\\source_files\\task3104"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().toLowerCase().matches(".*zip") || file.toString().toLowerCase().matches(".*rar"))
            archived.add(String.valueOf(file));
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        failed.add(String.valueOf(file));
        return FileVisitResult.SKIP_SUBTREE;
    }

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }
}
