package com.javarush.task.task31.task3110;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь к архиву");
        Path path = Paths.get(ConsoleHelper.readString());
        ZipFileManager zipFileManager = new ZipFileManager(path);
        ConsoleHelper.writeMessage("Введите полный путь к архивируемому файлу");
        Path source = Paths.get(ConsoleHelper.readString());
        zipFileManager.createZip(source);


    }
}
