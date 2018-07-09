package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int amount;
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String amountStr = ConsoleHelper.readString();
            boolean b = true;
            for (int i = 0; i < amountStr.length(); i++)
                if (!Character.isDigit(amountStr.charAt(i))) {
                    b = false;
                    break;
                }
            if (!b) ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            else {
                amount = Integer.parseInt(amountStr);
                if (manipulator.isAmountAvailable(amount)) {
                    Map<Integer, Integer> withdrawAmount = null;
                    try {
                        withdrawAmount = manipulator.withdrawAmount(amount);

                        ArrayList<Integer> sortedList = new ArrayList<>(withdrawAmount.keySet());
                        Collections.sort(sortedList);
                        Collections.reverse(sortedList);
                        for (Integer n : sortedList) {
                            ConsoleHelper.writeMessage("\t" + n + " - " + withdrawAmount.get(n));
                        }
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                        break;
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    }
                } else {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                }
            }
        }


    }
}
