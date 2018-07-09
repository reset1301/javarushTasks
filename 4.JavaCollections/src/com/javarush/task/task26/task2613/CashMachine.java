package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            CommandExecutor.execute(Operation.LOGIN);
//            String currencyCode = ConsoleHelper.askCurrencyCode();
//            String[] denomination_quantity = ConsoleHelper.getValidTwoDigits(currencyCode);
//            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//            currencyManipulator.addAmount(Integer.parseInt(denomination_quantity[0]), Integer.parseInt(denomination_quantity[1]));
//            currencyManipulator.getTotalAmount();
//            ConsoleHelper.writeMessage(currencyManipulator.getTotalAmount() + "");
            Operation operation;
            do {
//                ConsoleHelper.writeMessage("Input number of operation: \n1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }
    }
}
