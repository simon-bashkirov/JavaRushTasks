package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f != null)
            return (f.isDirectory() || f.getName().toLowerCase().matches(".*\\.htm[l]?$"));
        else
            return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
