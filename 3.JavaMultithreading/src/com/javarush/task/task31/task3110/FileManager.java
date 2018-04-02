package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        fileList = new ArrayList<>();
        collectFileList(this.rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path)) {
//            System.out.println(path + " is a regular path");
            fileList.add(rootPath.relativize(path));
        } else if (Files.isDirectory(path)) {
//            System.out.println(path + " is a directory");
            try (DirectoryStream<Path> paths = Files.newDirectoryStream(path)) {
                for (Path path1 : paths) {
                    collectFileList(path1);
                }
            }
        }

    }
}
