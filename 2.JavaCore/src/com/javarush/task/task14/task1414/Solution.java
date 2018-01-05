package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        Movie movie=null;
        while (s.equals("cartoon")||s.equals("thriller")||s.equals("soapOpera")){
            if (s.equals("cartoon")) {
//                movie = new Cartoon();
                movie = MovieFactory.getMovie(s);
            }
            else if (s.equals("thriller")) {
//                movie=new Thriller();
                movie = MovieFactory.getMovie(s);
            }
            else {
//                movie = new SoapOpera();
                movie = MovieFactory.getMovie(s);
            }
            System.out.println(movie.getClass().getSimpleName());
            s=br.readLine();
        }
        movie=MovieFactory.getMovie(s);
//        System.out.println(movie.getClass().getSimpleName());
        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            else if ("cartoon".equals(key)) {
                movie=new Cartoon();
            }
            else if ("thriller".equals(key))
                movie=new Thriller();

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3
    static class Cartoon extends Movie{}
    static class Thriller extends Movie{}
}
