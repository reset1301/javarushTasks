package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
//        Thread thread = new Thread(() -> {
//            StatisticManager manager = StatisticManager.getInstance();
//            while (true) {
//                try {
//                    if (!orderQueue.isEmpty()) {
//                        Set<Cook> cooks = manager.getCooks();
//                        for (Cook c : cooks) {
//                            if (!c.isBusy()) {
//                                Order order = orderQueue.take();
//                                c.startCookingOrder(order);
//                            }
//                        }
//                    }
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {}
//            }
//        });
//        thread.setDaemon(true);
//        thread.start();
//        ============
//        Thread thread;
//        thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (!Thread.currentThread().isInterrupted()) {
//                    Set<Cook> cooks = StatisticManager.getInstance().getCooks();
//                    if (!orderQueue.isEmpty()) {
////                    boolean cookBusy = true;
//                        for (Cook cook : cooks) {
//                            if (!cook.isBusy()) {
//                                try {
//                                    Order order = orderQueue.take();
//                                    cook.startCookingOrder(order);
//                                } catch (InterruptedException e) {
//                                    break;
//                                }
////                            cookBusy = false;
//                                break;
//                            }
//                        }
//                    }
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        break;
//                    }
//                }
//            }
//        });
//        thread.setDaemon(true);
//        thread.start();
    }

    @Override
    public void update(Observable tablet, Object order) {
        try {
            orderQueue.put((Order) order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
