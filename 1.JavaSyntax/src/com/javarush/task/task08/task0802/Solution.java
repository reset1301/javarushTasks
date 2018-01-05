package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String>m=new HashMap<>();
        m.put("арбуз", "ягода");
        m.put("банан", "трава");
        m.put("вишня","ягода");
        m.put("груша","фрукт");
        m.put("дыня","овощ");
        m.put("ежевика","куст");
        m.put("жень-шень","корень");
        m.put("земляника","ягода");
        m.put("ирис","цветок");
        m.put("картофель","клубень");

        for (Map.Entry<String,String> mm:m.entrySet() ) {
            System.out.println(mm.getKey()+" - "+mm.getValue());
        }

    }
}
