package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        String[] denomin = ConsoleHelper.getValidTwoDigits(currencyManipulator.getCurrencyCode());
        try {
            int nominal = Integer.parseInt(denomin[0]);
            int count = Integer.parseInt(denomin[1]);
            currencyManipulator.addAmount(nominal, count);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), nominal, count));
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
//        ConsoleHelper.writeMessage(res.getString("before"));
//        String currencyCode = ConsoleHelper.askCurrencyCode();
//        String[] denomination_quantity = ConsoleHelper.getValidTwoDigits(currencyCode);
//        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
//        currencyManipulator.addAmount(Integer.parseInt(denomination_quantity[0]), Integer.parseInt(denomination_quantity[1]));
    }
}
