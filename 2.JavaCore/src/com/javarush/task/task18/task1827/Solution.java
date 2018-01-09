package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//public class Solution {
//    public static void main(String[] args) throws Exception {
////        System.out.println(String.format("%-8d %-30s qqq",30005,"111111"));
////        String ss = "1984689   Шорты пляжные синие           159.00 12";
////        System.out.println(ss.indexOf(" "));
////        System.out.println(ss.substring(0,ss.indexOf(" ")));
////        int max = 100000105,maxbuf=max,count=0;
////        while (maxbuf>0){
////            maxbuf/=10;
////            count++;
////        }
////        String maxStr=max+"";
////        for (int i=count;i<8;i++){
////            maxStr+=".";
////        }
////        System.out.println(maxStr);
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String nameFile = br.readLine();
//            if (args.length != 0 && args[0].equals("-c")) {
//                String id = newID(nameFile);
//                String productName = args[1];
//                String price = args[2];
//                String quantity = args[3];
//                for (int i = productName.length(); i < 30; i++) {
//                    productName += " ";
//                }
//                for (int i = price.length(); i < 8; i++) {
//                    price += " ";
//                }
//                for (int i = quantity.length(); i < 4; i++) {
//                    quantity += " ";
//                }
//                String allStr = String.format("\r\n%-8s" + "%-30s" + "%-8s" + "%-4s", id, args[1], args[2], args[3]);
//                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(nameFile, true));
//                fileWriter.write(allStr);
//                fileWriter.close();
//                br.close();
////            FileInputStream fileInputStream = new FileInputStream(nameFile);
////            byte[]b= new byte[fileInputStream.available()];
////            fileInputStream.read(b);
////            fileInputStream.close();
////            FileOutputStream fileOutputStream = new FileOutputStream(nameFile);
////            fileOutputStream.write(b);
////            fileOutputStream.write(allStr.getBytes());
////            fileOutputStream.close();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public static String newID(String nameFile) throws IOException {
//        String s = "";
//        int max = 0, count = 0;
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));
//            while ((s = bufferedReader.readLine()) != null) {
//                if (max < Integer.parseInt(s.substring(0, s.indexOf(" ")))) {
//                    max = Integer.parseInt(s.substring(0, s.indexOf(" ")));
//                }
//            }
//            max++;
//            bufferedReader.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        String maxStr = max + "";
////        while (max>0){
////            max/=10;
////            count++;
////        }
////        for (int i=count;i<8;i++){
////            maxStr+=" ";
////        }
//
//        return maxStr;
//    }
//}
public class Solution {



    public static void main(String[] args) throws Exception {

        if (args.length < 4 || !args[0].equals("-c")) return;

        float price;

        int qty;



        //Если что-то передали не то

        try {

            price = Float.parseFloat(args[args.length - 2]);

            qty = Integer.parseInt(args[args.length - 1]);

        } catch (NumberFormatException e) {

            return;

        }



        //Если у нас аргументов больше 4 из-за пробелов в строке productName

        String productName;

        if (args.length > 4) {

            StringBuffer buf = new StringBuffer();

            for (int i = 1; i < args.length - 2; i++)

                buf.append(args[i]).append(" ");

            productName = buf.substring(0, buf.length() - 1);

        } else

            productName = args[1];



        //Read file name from console

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = consoleReader.readLine();

        consoleReader.close();



        //Get Lines from file

        //List<String> lines = Files.readAllLines(Paths.get(fileName)); //так проще, но не пропускается

        List<String> lines = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {

            while (fileReader.ready())

                lines.add(fileReader.readLine());

        }



        //Get ID from line

        Pattern p = Pattern.compile("([0-9]{1,8})");

        int maxID = 0;

        for (String s : lines) {

            Matcher m = p.matcher(s);

            if (m.lookingAt()) {

                try {

                    //System.out.println(s.substring(m.start(), m.end()));

                    int id = Integer.parseInt(s.substring(m.start(), m.end()));

                    if (id > maxID)

                        maxID = id;

                } catch (NumberFormatException e) {

                    continue;

                }

            }

        }



        if (maxID++ == 99999999)

            return;

        String toFile = String.format(Locale.ROOT,"%-8d%-30s%-8.2f%-4d", maxID, productName, price, qty);



        lines.add(toFile);

        try (BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {

            for (String s: lines)

                buf.write(s+"\r\n");

        }

    }

}