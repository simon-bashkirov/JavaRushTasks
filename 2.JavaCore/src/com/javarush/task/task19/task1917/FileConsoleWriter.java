package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;
    private CharArrayWriter charArrayWriter = new CharArrayWriter();

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }


    public void write(int c) throws IOException {
        fileWriter.write(c);
//        charArrayWriter.write(c);
//        System.out.println(charArrayWriter.toString());
//        charArrayWriter.reset();
        System.out.println(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        charArrayWriter.write(cbuf, off, len);
        System.out.println(charArrayWriter.toString());
        charArrayWriter.reset();
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        charArrayWriter.write(str, off, len);
        System.out.println(charArrayWriter.toString());
        charArrayWriter.reset();
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        charArrayWriter.write(cbuf);
        System.out.println(charArrayWriter.toString());
        charArrayWriter.reset();
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        charArrayWriter.write(str);
        System.out.println(charArrayWriter.toString());
        charArrayWriter.reset();
    }

    public void close() throws IOException {
        fileWriter.close();
    }

}
