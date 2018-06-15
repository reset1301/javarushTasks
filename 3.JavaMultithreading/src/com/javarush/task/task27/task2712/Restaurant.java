package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.*;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();


    public static void main(String[] args) throws IOException, InterruptedException {
//        System.out.println(Dish.allDishesToString());
//        ConsoleHelper.getAllDishesForOrder();
//        Order order = new Order(new Tablet(1));
//        System.out.println(order.toString());
//        for (int i = 0; i < 32768; i++) {
//            System.out.print((char)i+" ");
//        }
//        System.out.println();
//        Tablet tablet = new Tablet(5);
//        Order order = tablet.createOrder();
////        TestOrder order = tablet.createTestOrder();;
//        if (order.isEmpty())
//            return;
//        Cook amigo = new Cook("Amigo");
//        tablet.addObserver(amigo);
        Waiter waiter = new Waiter();
//        amigo.addObserver(waiter);
//        amigo.update(tablet, order);
//        waiter.update(amigo, order);
        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("Bingo");

        cook1.setQueue(orderQueue);
        cook2.setQueue(orderQueue);

//        StatisticManager.getInstance().register(cook1);
//        StatisticManager.getInstance().register(cook2);
//        OrderManager orderManager = new OrderManager();

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
//            if (i % 2 == 0)
//            tablet.addObserver(orderManager);
//            else
//                tablet.addObserver(orderManager);
            tablets.add(tablet);
        }

        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(task);

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

        new Thread(cook1).start();
        new Thread(cook2).start();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
//        new Cook("www").update(new Tablet(5).createOrder(),);

    }
}
