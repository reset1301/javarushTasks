package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s = "";
        try {
            s = bis.readLine();
            if (s.toUpperCase().equals("EXIT"))
                throw new InterruptOperationException();
//            return (s);
        } catch (IOException ignored) {
        }
        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String s = "";
        while (true) {
            s = readString();
            if (s.length() != 3)
                writeMessage(res.getString("invalid.data"));
            else break;
        }
        return s.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String denomination_quantity;
        try {
            while (true) {
                denomination_quantity = readString();
                String[] ss = denomination_quantity.split(" ");
                if (ss.length == 2) {
                    boolean flag = true;
                    for (int j = 0; j < ss.length; j++)
                        for (int i = 0; i < ss[j].length(); i++)
                            if (!Character.isDigit(ss[j].charAt(i))) {
                                flag = false;
                                break;
                            }
                    if (flag) return ss;
                    else writeMessage(res.getString("invalid.data"));
                }
            }
        } catch (IllegalArgumentException ignored) {
        }
        return new String[]{};
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
//        "What operation?\n 0 - LOGIN, 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
        int numberOperation;

        while (true)
            try {
                numberOperation = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(numberOperation);
            } catch (IllegalArgumentException ignored) {
            }
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
