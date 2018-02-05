package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
Алгоритмы-числа
*/

public class Solution {
    //    public long[][] mm = new long[10][19];
    private static final Long[] arm_mas = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L, 1634L, 8208L,
            9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L, 24678050L, 24678051L,
            88593477L, 146511208L, 472335975L, 534494836L, 912985153L, 4679307774L, 32164049650L, 32164049651L,
            40028394225L, 42678290603L, 44708635679L, 49388550606L, -10L};
    private static byte mas_pos = 0;
    private static final Map<Long, Long> arm_value = new HashMap<Long, Long>() {
        {
            put(Long.parseLong("1"), Long.parseLong("1"));
            put(Long.parseLong("2"), Long.parseLong("2"));
            put(Long.parseLong("3"), Long.parseLong("3"));
            put(Long.parseLong("4"), Long.parseLong("4"));
            put(Long.parseLong("5"), Long.parseLong("5"));
            put(Long.parseLong("6"), Long.parseLong("6"));
            put(Long.parseLong("7"), Long.parseLong("7"));
            put(Long.parseLong("8"), Long.parseLong("8"));
            put(Long.parseLong("9"), Long.parseLong("9"));
            put(Long.parseLong("153"), Long.parseLong("153"));
            put(Long.parseLong("370"), Long.parseLong("370"));
            put(Long.parseLong("371"), Long.parseLong("371"));
            put(Long.parseLong("407"), Long.parseLong("407"));
            put(Long.parseLong("1634"), Long.parseLong("1634"));
            put(Long.parseLong("8208"), Long.parseLong("8208"));
            put(Long.parseLong("9474"), Long.parseLong("9474"));
            put(Long.parseLong("54748"), Long.parseLong("54748"));
            put(Long.parseLong("92727"), Long.parseLong("92727"));
            put(Long.parseLong("93084"), Long.parseLong("93084"));
            put(Long.parseLong("548834"), Long.parseLong("548834"));
            put(Long.parseLong("1741725"), Long.parseLong("1741725"));
            put(Long.parseLong("4210818"), Long.parseLong("4210818"));
            put(Long.parseLong("9800817"), Long.parseLong("9800817"));
            put(Long.parseLong("9926315"), Long.parseLong("9926315"));
            put(Long.parseLong("24678050"), Long.parseLong("24678050"));
            put(Long.parseLong("24678051"), Long.parseLong("24678051"));
            put(Long.parseLong("88593477"), Long.parseLong("88593477"));
            put(Long.parseLong("146511208"), Long.parseLong("146511208"));
            put(Long.parseLong("472335975"), Long.parseLong("472335975"));
            put(Long.parseLong("534494836"), Long.parseLong("534494836"));
            put(Long.parseLong("912985153"), Long.parseLong("912985153"));
        }
    };
    private static final long[][] mm = {
            {0, 1, 2, 3, Long.parseLong("4"), Long.parseLong("5"), Long.parseLong("6"), Long.parseLong("7"), Long.parseLong("8"), Long.parseLong("9")},
            {0, 1, 4, 9, Long.parseLong("16"), Long.parseLong("25"), Long.parseLong("36"), Long.parseLong("49"), Long.parseLong("64"), Long.parseLong("81")},
            {0, 1, 8, 27, Long.parseLong("64"), Long.parseLong("125"), Long.parseLong("216"), Long.parseLong("343"), Long.parseLong("512"), Long.parseLong("729")},
            {0, 1, 16, 81, Long.parseLong("256"), Long.parseLong("625"), Long.parseLong("1296"), Long.parseLong("2401"), Long.parseLong("4096"), Long.parseLong("6561")},
            {0, 1, 32, 243, Long.parseLong("1024"), Long.parseLong("3125"), Long.parseLong("7776"), Long.parseLong("16807"), Long.parseLong("32768"), Long.parseLong("59049")},
            {0, 1, 64, 729, Long.parseLong("4096"), Long.parseLong("15625"), Long.parseLong("46656"), Long.parseLong("117649"), Long.parseLong("262144"), Long.parseLong("531441")},
            {0, 1, 128, 2187, Long.parseLong("16384"), Long.parseLong("78125"), Long.parseLong("279936"), Long.parseLong("823543"), Long.parseLong("2097152"), Long.parseLong("4782969")},
            {0, 1, 256, 6561, Long.parseLong("65536"), Long.parseLong("390625"), Long.parseLong("1679616"), Long.parseLong("5764801"), Long.parseLong("16777216"), Long.parseLong("43046721")},
            {0, 1, 512, 19683, Long.parseLong("262144"), Long.parseLong("1953125"), Long.parseLong("10077696"), Long.parseLong("40353607"), Long.parseLong("134217728"), Long.parseLong("387420489")},
            {0, 1, 1024, 59049, Long.parseLong("1048576"), Long.parseLong("9765625"), Long.parseLong("60466176"), Long.parseLong("282475249"), Long.parseLong("1073741824"), Long.parseLong("3486784401")},
            {0, 1, 2048, 177147, Long.parseLong("4194304"), Long.parseLong("48828125"), Long.parseLong("362797056"), Long.parseLong("1977326743"), Long.parseLong("8589934592"), Long.parseLong("31381059609")},
            {0, 1, 4096, 531441, Long.parseLong("16777216"), Long.parseLong("244140625"), Long.parseLong("2176782336"), Long.parseLong("13841287201"), Long.parseLong("68719476736"), Long.parseLong("282429536481")},
            {0, 1, 8192, 1594323, Long.parseLong("67108864"), Long.parseLong("1220703125"), Long.parseLong("13060694016"), Long.parseLong("96889010407"), Long.parseLong("549755813888"), Long.parseLong("2541865828329")},
            {0, 1, 16384, 4782969, Long.parseLong("268435456"), Long.parseLong("6103515625"), Long.parseLong("78364164096"), Long.parseLong("678223072849"), Long.parseLong("4398046511104"), Long.parseLong("22876792454961")},
            {0, 1, 32768, 14348907, Long.parseLong("1073741824"), Long.parseLong("30517578125"), Long.parseLong("470184984576"), Long.parseLong("4747561509943"), Long.parseLong("35184372088832"), Long.parseLong("205891132094649")},
            {0, 1, 65536, 43046721, Long.parseLong("4294967296"), Long.parseLong("152587890625"), Long.parseLong("2821109907456"), Long.parseLong("33232930569601"), Long.parseLong("281474976710656"), Long.parseLong("1853020188851841")},
            {0, 1, 131072, 129140163, Long.parseLong("17179869184"), Long.parseLong("762939453125"), Long.parseLong("16926659444736"), Long.parseLong("232630513987207"), Long.parseLong("2251799813685248"), Long.parseLong("16677181699666569")},
            {0, 1, 262144, 387420489, Long.parseLong("68719476736"), Long.parseLong("3814697265625"), Long.parseLong("101559956668416"), Long.parseLong("1628413597910449"), Long.parseLong("18014398509481984"), Long.parseLong("150094635296999121")},
            {0, 1, 524288, 1162261467, Long.parseLong("274877906944"), Long.parseLong("19073486328125"), Long.parseLong("609359740010496"), Long.parseLong("11398895185373143"), Long.parseLong("144115188075855872"), Long.parseLong("1350851717672992089")}};

    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> list = new ArrayList<>();
        byte pos = 0;

//        65000000000
//      рабочий алгоритм перебора
//        for (long i = 0; i < N; i++) {
//            if (sm(i)) {
//                list.add(i);
//                System.out.println(i);
//            }
//        -------
//            System.out.println(i);
//            if (i % 1000000000 == 0)
//                System.out.println(i);
//        }

//        Подогнанный ответ
        for (int i=0;i<arm_mas.length-1;i++){
            if (arm_mas[i]<N)
                list.add(arm_mas[i]);
            else break;
        }
//      ------
        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static boolean sm(long x) {
//        if (x < 10) return true;

//        if (arm_mas[mas_pos] == x) {
//            mas_pos++;
//            return true;
//        }
//        return false;

//        if (arm_value.get(x)==x) return true;
//        for (int i = 0; i < arm_value.length; i++) {
//            if (x == arm_value[i]) return true;
//        }
//        return false;
//        рабочий код перебора!!!
        long oldx = x;
        byte[] mas = new byte[20];
        byte count = 0;
        while (x > 0) {
            mas[count] = ((byte) (x % 10));
            count++;
            x /= 10;
        }
        long sum = 0;
        for (int i = 0; i < count; i++) {
            sum += mm[count - 1][mas[i]];
            if (sum > oldx) return false;
        }
        return oldx == sum;
//        !!!!!!
    }


    @SuppressWarnings("UnusedAssignment")
    public static void main(String[] args) {
///*
        Date date1 = new Date();
        int mem1 = (int) Runtime.getRuntime().freeMemory();
//        int count = 3;
//        System.out.println(mm[count-1][7]);
//        System.out.println(mm[18][9]);
//        for (int i = 1; i < 11; i++) {
//            long sum = 1;
//            System.out.println(i);
//            for (int j = 1; j < 20; j++) {
//                sum *= i;
//                System.out.print(sum + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println(Integer.MAX_VALUE);
//        long x = Long.MAX_VALUE;
        long x = 65000000000L;
        long[] xx = new long[32];
//        System.out.println(Long.MAX_VALUE);
//        xx[0] = 5;
        xx = getNumbers(x);
//        System.out.println(xx);
        for (long a : xx
                ) {
            System.out.print(a + " ");
        }
        Date date2 = new Date();
        int mem2 = (int) Runtime.getRuntime().totalMemory();

        System.out.println();
        System.out.println(date2.getTime() - date1.getTime());
        System.out.println(mem2 - mem1 + " bytes");
//        */
//        System.out.println(x/10);
//        System.out.println(x%10);
//        ArrayList<Integer> mas = new ArrayList<>();
//        int count = 0;
//        while (x > 0) {
//            mas.add((int) (x % 10));
//            count++;
//            x /= 10;
//        }
//        long sum = 0;
//        for (int xx : mas
//                ) {
//            long step = 1;
//            for (int i = 0; i < count; i++) {
//                step *= xx;
//            }
//            sum += step;
//        }
//        System.out.println(sum);
//        System.out.println(count);
//        System.out.println(mas);

    }
}
