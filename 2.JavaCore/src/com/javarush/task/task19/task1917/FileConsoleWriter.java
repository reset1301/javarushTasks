package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

//import org.jetbrains.annotations.NotNull;

//import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter{
    private FileWriter fileWriter=null;

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write( char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.print(String.valueOf(cbuf).substring(off,off+len));
//        System.out.print(off+" ");
//        System.out.println(len);
    }

    public void write( String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off,off+len));
//        System.out.print(off+" ");
//        System.out.println(len);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public void write( char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(cbuf);
    }

    public void write( String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter=new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter=new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter=new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter=new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter=new FileWriter(fd);
    }

    public static void main(String[] args) {

    }

}
