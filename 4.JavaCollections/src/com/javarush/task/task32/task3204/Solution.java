package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        String alphabet = "abcdefghigklmnopqrstuvwxyz" + "abcdefghigklmnopqrstuvwxyz".toUpperCase() + "1234567890";
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            String pass = "";
            for (int i = 0; i < 8; i++) {
                pass += alphabet.charAt((int) ((alphabet.length() - 1) * Math.random()));
            }
//            System.out.println(pass);
            if (isValidPassword(pass)) {
                arrayOutputStream.write(pass.getBytes());
                break;
            }
        }
        return arrayOutputStream;
    }

    private static boolean isValidPassword(String pass) {
        String dig = "1234567890", lowC = "abcdefghigklmnopqrstuvwxyz", upC = "abcdefghigklmnopqrstuvwxyz".toUpperCase();

        boolean digit = false;
        boolean lowChar = false;
        boolean upChar = false;
        for (int i = 0; i < pass.length(); i++) {
            String c = "" + pass.charAt(i);
            if (dig.contains(c))
                digit = true;
            if (lowC.contains(c))
                lowChar = true;
            if (upC.contains(c))
                upChar = true;
        }

        return digit&&lowChar&&upChar;
    }
}