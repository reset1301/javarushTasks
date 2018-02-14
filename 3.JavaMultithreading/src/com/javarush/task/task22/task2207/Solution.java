package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
//public class Solution {
//    public static List<Pair> result = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = br.readLine();
//        Map<String, String> map = new HashMap<>();
//        br.close();
////        String fileName = "c:\\111\\1.a";
//        br = new BufferedReader(new FileReader(fileName));
////        FileInputStream fis = new FileInputStream(fileName);
////        fis.
//        StringBuilder stringBuilder = new StringBuilder();
//        while (br.ready()) {
////            char[] c = new char[1000];
//            stringBuilder.append(br.readLine());
//            stringBuilder.append(" ");
////            System.out.println(stringBuilder.toString());
//        }
////        System.out.println(stringBuilder.toString());
//        String[] strings = stringBuilder.toString().split(" ");
//        for (int i=0;i<strings.length;i++) {
//            StringBuilder s1 = new StringBuilder(strings[i]);
//            StringBuilder s2 = null;
//            if (i+1<strings.length) {
//                 s2 = new StringBuilder(strings[i+1]);
//            }else
//                break;
//            if (s1.toString().equals(s2.reverse().toString())) {
//                map.put(s1.toString(), s2.reverse().toString());
////                Pair pair = new Pair();
////                pair.first = s1.toString();
////                pair.second = s2.reverse().toString();
////                result.add(pair);
//                i++;
//            }
//        }
//        for (Map.Entry<String,String> m:map.entrySet()
//             ) {
//            Pair pair = new Pair();
//            pair.first = m.getKey();
//            pair.second = m.getValue();
//            result.add(pair);
//        }
//        for (Pair p:result
//             ) {
//            System.out.println(p.first+" "+p.second);
//        }
////        System.out.println(result);
//    }
//
//    public static class Pair {
//        String first;
//        String second;
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Pair pair = (Pair) o;
//
//            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
//            return second != null ? second.equals(pair.second) : pair.second == null;
//
//        }
//
//        @Override
//        public int hashCode() {
//            int result = first != null ? first.hashCode() : 0;
//            result = 31 * result + (second != null ? second.hashCode() : 0);
//            return result;
//        }
//
//        @Override
//        public String toString() {
//            return first == null && second == null ? "" :
//                    first == null && second != null ? second :
//                            second == null && first != null ? first :
//                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
//
//        }
//    }
//
//}
public class Solution {

    public static List<Pair> result = new LinkedList<>();

    public static List<Integer> busyNum = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        try (FileReader fileReader = new FileReader(reader.readLine()); BufferedReader buffStr = new BufferedReader(fileReader)){

            StringBuilder strB = new StringBuilder();



            while (buffStr.ready()){

                String tmpBuff = buffStr.readLine();

                strB.append(tmpBuff+" ");



            }



            String[] normalStr = strB.toString().split(" ");

            for (int i = 0; i <normalStr.length ; i++) {

                if (checkNum(i)) {



                    String firstStr = normalStr[i];

                    for (int j = 0; j < normalStr.length; j++) {



                        if (i != j && checkNum(j)&&checkNum(i)) {

                            StringBuilder secondStr = new StringBuilder(normalStr[j]);

                            secondStr.reverse();

                            if(firstStr.equals(secondStr.toString())){

                                Pair pair = new Pair();

                                pair.first=firstStr;

                                pair.second = normalStr[j];

                                result.add(pair);

                                busyNum.add(i);

                                busyNum.add(j);



                            }

                        }

                    }

                }

            }

            System.out.println();







        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    public static boolean checkNum(int thisNum){

        for (Integer thatNum:busyNum) {

            if(thatNum==thisNum)return false;

        }

        return true;

    }



    public static class Pair {

        String first;

        String second;







        @Override

        public boolean equals(Object o) {

            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;



            Pair pair = (Pair) o;



            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;

            return second != null ? second.equals(pair.second) : pair.second == null;



        }



        @Override

        public int hashCode() {

            int result = first != null ? first.hashCode() : 0;

            result = 31 * result + (second != null ? second.hashCode() : 0);

            return result;

        }



        @Override

        public String toString() {

            return  first == null && second == null ? "" :

                    first == null && second != null ? second :

                            second == null && first != null ? first :

                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;



        }

    }



}