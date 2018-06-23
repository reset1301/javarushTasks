package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.math.BigInteger;
import java.util.ArrayList;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        int i = (int) new Object();
    }

    public void methodThrowsNullPointerException() {
        Integer integer=null;
        integer ++;
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.methodThrowsClassCastException();
        veryComplexClass.methodThrowsNullPointerException();
    }
}
