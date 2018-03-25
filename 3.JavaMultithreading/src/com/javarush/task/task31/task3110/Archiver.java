package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        /*ConsoleHelper.writeMessage("Введите полный путь к архиву");
        Path path = Paths.get(ConsoleHelper.readString());
        ZipFileManager zipFileManager = new ZipFileManager(path);
        ConsoleHelper.writeMessage("Введите полный путь к архивируемому файлу");
        Path source = Paths.get(ConsoleHelper.readString());
        zipFileManager.createZip(source);*/

        Operation operation = null;

        while (true) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
                if (operation == Operation.EXIT)
                    break;
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }

    }

    public static Operation askOperation() throws Exception {
        ConsoleHelper.writeMessage("Выберите операцию:");
        for (Operation operation : Operation.values()) {
            ConsoleHelper.writeMessage(operation.ordinal() + " - " + operation.getDescription());
        }
        return Operation.values()[ConsoleHelper.readInt()];
    }
}
