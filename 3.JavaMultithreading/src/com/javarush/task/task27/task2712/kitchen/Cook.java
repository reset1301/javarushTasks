package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable{//implements Observer {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
//        return "Cook{" +
//                "name='" + name + '\'' +
//                '}';
        return name;
    }

    //    @Override
//    public void update(Observable tablet, Object order) {
////        Start cooking - Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min
////        Order order1 = (Order) order;
////        if (order1.isEmpty())
////            return;
//        ConsoleHelper.writeMessage("Start cooking - " + order);
//        setChanged();
//        notifyObservers(order);
//        StatisticManager.getInstance().register(new CookedOrderEventDataRow(tablet.toString(),
//                name,
//                ((Order) order).getTotalCookingTime() * 60,
//                ((Order) order).getDishes()));
//    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) throws InterruptedException {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        int totalCookingTime = ((Order) order).getTotalCookingTime();
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),
                name,
                totalCookingTime * 60,
                ((Order) order).getDishes()));
        Thread.sleep(totalCookingTime * 10);
        busy = false;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Thread thread = new Thread(() -> {
            StatisticManager manager = StatisticManager.getInstance();
            while (true) {
                try {
                    if (!queue.isEmpty()) {
//                        Set<Cook> cooks = manager.getCooks();
//                        for (Cook c : cooks) {
//                            if (!c.isBusy()) {
                        if (!isBusy()){
                                Order order = queue.take();
                                startCookingOrder(order);
                            }
//                        }
                    }
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
