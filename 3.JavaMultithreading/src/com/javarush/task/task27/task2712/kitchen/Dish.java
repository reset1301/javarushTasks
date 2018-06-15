package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int i) {
        duration = i;
    }

    public static String allDishesToString() {
        Dish[] s = Dish.values();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length - 1; i++) {
            builder.append(s[i]).append(", ");
        }
        builder.append(s[s.length - 1]);
        return builder.toString();
    }

    public int getDuration() {
        return duration;
    }
}
