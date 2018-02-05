package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {
//        A a = (A) objectStream.readObject();
//        if (a instanceof B)
//            return (B) a;
//        return a;
        A a = null;
        try {
            a = (A) objectStream.readObject();
//            if (o instanceof B)
//                throw new ClassNotFoundException();
//            else return (A)o;
        } catch (Exception e) {
            return null;
        }
//        if
//        } catch (IOException e) {
//            return null;
//        }
        return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
