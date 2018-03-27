package com.javarush.task.task26.task2601;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] array = {13, 8, 15, 5, 17,1};
//        Integer[] arr=sort(array);
//        for (int a :arr
//             ) {
//            System.out.println(a);
//        }
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double med = mediana(array);
//        System.out.println(med);
        Comparator<Integer> byMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if ((int) (Math.abs(o1-med)-Math.abs(o2-med))==0)
                    return o1 - o2;
                return (int) (Math.abs(o1-med)-Math.abs(o2-med));
            }
        };
        List<Integer> arr = new LinkedList<>();
        Collections.addAll(arr, array);
        Collections.sort(arr, byMediana);
        return arr.toArray(new Integer[0]);
    }

    public static double mediana(Integer[] array) {
        List<Integer> arr = new LinkedList<>();
        Collections.addAll(arr, array);
        Collections.sort(arr);
        if (arr.size() % 2 == 0) {
            return ((double)arr.get(arr.size() / 2 - 1) + arr.get(arr.size() / 2)) / 2;
        } else
            return arr.get((arr.size() - 1) / 2);
//        return 0;
    }
}
