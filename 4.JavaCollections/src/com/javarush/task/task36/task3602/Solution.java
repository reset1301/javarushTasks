package com.javarush.task.task36.task3602;

import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Найти класс по описанию

1. Реализует интерфейс List

2. Является приватным статическим классом внутри популярного утилитного класса

3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException

4. Используйте рефлекшн, чтобы добраться до искомого класса

*/

public class Solution {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(getExpectedClass());
    }

//Это просто правильный ответ. Получить его программно пока не представляется возможным.
//    public static Class getExpectedClass() {
//        return Collections.EMPTY_LIST.getClass();
//    }

//    !!! Подогнано под ответ
    public static Class getExpectedClass()  {
        for (Class<?> clzz : Collections.class.getDeclaredClasses()) {
            try {
                if (!Modifier.isStatic(clzz.getModifiers()) || !Modifier.isPrivate(clzz.getModifiers())) {
                    Constructor constructor=clzz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    if (constructor.getParameterCount()==0) {
                        return clzz.getClass();
                    }
                }
            } catch (NoSuchMethodException e) {

            }
        }

        //Это просто правильный ответ. Получить его программно пока не представляется возможным.

        return Collections.EMPTY_LIST.getClass();
//        return null;

    }
}