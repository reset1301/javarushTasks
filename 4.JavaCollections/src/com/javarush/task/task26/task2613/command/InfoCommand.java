package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> allCurrencyManipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (allCurrencyManipulators.isEmpty())
            ConsoleHelper.writeMessage(res.getString("no.money"));
        else
            for (CurrencyManipulator cm : allCurrencyManipulators)
                ConsoleHelper.writeMessage(cm.hasMoney() ? cm.getCurrencyCode().toUpperCase() + " - " + cm.getTotalAmount() : res.getString("no.money"));
    }
}
