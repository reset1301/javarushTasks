package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public Order(Tablet tablet) throws IOException {
        initDishes();
        this.tablet = tablet;
//        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
//        Your order: [Juice, Fish] of Tablet{number=5}
        if (dishes.size() == 0)
            return "";
        else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < dishes.size() - 1; i++) {
                builder.append(dishes.get(i)).append(", ");
            }
            builder.append(dishes.get(dishes.size() - 1));
            return "Your order: [" +
                    builder.toString() +
                    "] of " + tablet.toString() +
                    ", cooking time " + getTotalCookingTime() +
                    "min";
        }
    }

    public int getTotalCookingTime() {
        int totTime = 0;
        for (Dish d : dishes
                ) {
            switch (d) {
                case Fish:
                    totTime += 25;
                    break;
                case Steak:
                    totTime += 30;
                    break;
                case Soup:
                    totTime += 15;
                    break;
                case Juice:
                    totTime += 5;
                    break;
                case Water:
                    totTime += 3;
            }
        }
        return totTime;
    }

    public boolean isEmpty() {
        return dishes.size() <= 0;
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }
}
