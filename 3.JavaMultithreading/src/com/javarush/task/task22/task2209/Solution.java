package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = br.readLine();
//        String nameFile = "c:\\111\\1.a";
        br.close();
        br = new BufferedReader(new FileReader(nameFile));
        String[] s = br.readLine().split(" ");
        StringBuilder result = getLine(s);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

//        Не добавляет слова в начало списка
        
//        if (words.length == 0) return new StringBuilder("");
//        Map<String, Integer> map = new HashMap<>();
//        ArrayList<StringBuilder> list = new ArrayList<>();
//        Map<Integer, String> map1 = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            map.put(words[i], i);
//        }
//        for (Map.Entry<String, Integer> m : map.entrySet()
//                ) {
//            list.add(new StringBuilder(m.getKey()));
//        }
//        boolean b = true;
//        StringBuilder result = new StringBuilder();
//        if (result.length() == 0) {
//            int i = 0;
//            while (b) {
//                char ch = list.get(i).toString().toUpperCase().charAt(list.get(i).length() - 1);
//                for (int j = i; j < list.size(); j++) {
//                    if (ch == list.get(j).toString().toUpperCase().charAt(0)) {
//                        result.append(list.get(i));
//                        result.append(" ");
//                        result.append(list.get(j));
//                        result.append(" ");
//                        list.remove(j);
//                        list.remove(i);
//                        i = j = list.size();
//                        b = false;
//                    }
//                }
//                i++;
//            }
//        }
////        System.out.println(result.toString());
////        System.out.println(result.toString().toUpperCase().charAt(result.length() - 2));
//        b = true;
//        while (b) {
//            b = false;
//            for (int j = 0; j < list.size(); j++) {
//                char ch = result.toString().toUpperCase().charAt(result.length() - 2);
//                if (ch == list.get(j).toString().toUpperCase().charAt(0)) {
//                    result.append(list.get(j));
//                    result.append(" ");
//                    list.remove(j);
//                    b = true;
//                    j = 0;
//                }
//            }
//        }
//        if (list.size() > 0)
//            for (StringBuilder s : list
//                    ) {
//                result.append(s.toString());
//                result.append(" ");
//            }
//        return result;
////        return new StringBuilder(result.toString().trim());
//    }
//}
        if (words == null) {return new StringBuilder();}

        if (words.length==0) {return new StringBuilder();}



        //String[] array = i.split(" ");

        ArrayList<String> arrayList = new ArrayList<>();

        for (String s: words) {

            arrayList.add(s);

        }

        int neededCounter = arrayList.size();

        StringBuilder resultBuilder = new StringBuilder();

        while (true)

        {

            int wordCounter = 0;

            ArrayList<String> temp = new ArrayList<>(arrayList);

            Collections.shuffle(temp);

            StringBuilder tempBuilder = new StringBuilder();

            tempBuilder.append(arrayList.get(0));

            temp.remove(arrayList.get(0));

            boolean canAdd = true;



            while (canAdd)

            {

                {

                    ArrayList<String> toDelete = new ArrayList<>();

                    for (String s : temp)

                    {

                        StringBuilder word = new StringBuilder(s);

                        // если конец стрингбилдера равен первой букве другого слова

                        if (tempBuilder.substring(tempBuilder.length() - 1).equals(word.reverse().substring(s.length() - 1).toLowerCase()))

                        {

                            tempBuilder.append(" " + s);

                            toDelete.add(s);

                            wordCounter++;

                            continue;

                        }

                        // если начало стрингбилдера равно последней букве другого слова "Киев Вена" - "Нью Йорк"

                        if (tempBuilder.toString().substring(0, 1).toLowerCase().equals(s.substring(s.length() - 1).toLowerCase()))

                        {

                            tempBuilder.reverse().append(" " + word);

                            tempBuilder.reverse();

                            toDelete.add(s);

                            wordCounter++;

                            continue;

                        }

                    }

                    // удаляем уже вставленные слова

                    for (String s : toDelete)

                    {

                        temp.remove(s);

                    }

                    toDelete.clear();

                    // если ни к концу ни к началу нельзя добавить символ - break;

                    for (String s : temp)

                    {

                        StringBuilder word = new StringBuilder(s);

                        if (!tempBuilder.substring(tempBuilder.length() - 1).equals(word.reverse().substring(s.length() - 1).toLowerCase()) &&

                                !tempBuilder.toString().substring(0, 1).toLowerCase().equals(s.substring(s.length() - 1).toLowerCase()))

                        {

                            canAdd = false;

                        }

                    }

                }

                resultBuilder = tempBuilder;

                if (wordCounter==neededCounter-1) {

                    return resultBuilder;

                }

            }

        }

    }

}