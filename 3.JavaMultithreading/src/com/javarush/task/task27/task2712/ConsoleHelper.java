package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        String s;
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Введите желаемое блюдо: " + System.lineSeparator() + Dish.allDishesToString());

        while (!(s = reader.readLine()).equals("exit")) {
            switch (s) {
                case "Fish":
                    dishes.add(Dish.Fish);
                    break;
                case "Steak":
                    dishes.add(Dish.Steak);
                    break;
                case "Soup":
                    dishes.add(Dish.Soup);
                    break;
                case "Juice":
                    dishes.add(Dish.Juice);
                    break;
                case "Water":
                    dishes.add(Dish.Water);
            }
            writeMessage("Выберите блюдо." + System.lineSeparator() + Dish.allDishesToString());
        }
        return dishes;
    }
}
