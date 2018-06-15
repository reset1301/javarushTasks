package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    public void initDishes() {
        this.dishes = new ArrayList<>();
        int numberOfDishes = (int) (5 * Math.random() + 1);
        int dishCount = Dish.values().length;
        Dish[] dishes1=Dish.values();
        for (int i = 0; i < numberOfDishes; i++) {
            dishes.add(dishes1[(int) ((dishCount - 1) * Math.random())]);
        }
    }
}
