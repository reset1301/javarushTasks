package com.javarush.task.task25.task2502;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new LinkedList<>();
            String[] strings = this.loadWheelNamesFromDB();
            if (strings.length!=4)
                throw new IllegalArgumentException();
            for (String s : strings
                    ) {
                if (s == Wheel.BACK_LEFT.toString())
                    wheels.add(Wheel.BACK_LEFT);
                else if (s == Wheel.BACK_RIGHT.toString())
                    wheels.add(Wheel.BACK_RIGHT);
                else if (s == Wheel.FRONT_LEFT.toString())
                    wheels.add(Wheel.FRONT_LEFT);
                else if (s == Wheel.FRONT_RIGHT.toString())
                    wheels.add(Wheel.FRONT_RIGHT);
                else throw new IllegalArgumentException();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
//        Car car = new Car();
//        System.out.println(car.wheels);
    }
}
