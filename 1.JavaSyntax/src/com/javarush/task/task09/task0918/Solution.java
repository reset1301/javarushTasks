package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends ClassNotFoundException{
    }

    static class MyException2 extends FileNotFoundException{
    }

    static class MyException3 extends NullPointerException{
    }

    static class MyException4 extends IndexOutOfBoundsException{
    }
}

