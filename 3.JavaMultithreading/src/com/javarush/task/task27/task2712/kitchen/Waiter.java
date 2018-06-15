package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {
    @Override
    public void update(Observable cook, Object order) {
//        Order order1 = (Order) order;
//        if (order1.isEmpty())
//            return;
        ConsoleHelper.writeMessage(order.toString() + " was cooked by " + cook.toString());
    }
}
