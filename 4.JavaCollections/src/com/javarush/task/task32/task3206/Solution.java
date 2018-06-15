package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

/*
Дженерики для создания прокси-объекта
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    public <T extends Item> T getProxy(Class<T> itemClass, Class<?>... bigClass) {
//        ArrayList<Class<?>> interfaces = new ArrayList<>(Arrays.asList(itemClass.getClass().getInterfaces()));

        Class[] mas = new Class[bigClass.length + 1];
        for (int i = 0; i < bigClass.length; i++) {
            mas[i] = bigClass[i];
        }
//        System.arraycopy(bigClass, 0, mas, 0, bigClass.length);
        mas[mas.length - 1] = itemClass;
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), mas, new ItemInvocationHandler());
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}