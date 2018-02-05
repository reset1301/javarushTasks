package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public Solution() {
    }

    public static class SubSolution extends Solution {
        public SubSolution() {
        }

        private void writeObject(ObjectOutputStream outputStream) throws NotSerializableException {
//            try {
                throw new NotSerializableException();
//            } catch (NotSerializableException e) {
//                e.printStackTrace();
//            }
        }
        private void readObject(ObjectInputStream objectInputStream) throws NotSerializableException {
//            try {
                throw new NotSerializableException();
//            } catch (NotSerializableException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) {

    }
}
