package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses
                ) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses
                ) {
            horse.print();
        }
        System.out.print(System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
                + System.lineSeparator());

    }

    public Horse getWinner() {
        Horse h = null;
        double max = 0;
        for (Horse horse : horses
                ) {
            if (horse.getDistance() > max) {
                max = horse.getDistance();
                h = horse;
            }

        }
//        for (Horse horse:horses
//             ) {
//            if (horse.getDistance()==max) return horse;
//        }
        return h;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName()+"!");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("A", 3, 0));
        horses.add(new Horse("B", 3, 0));
        horses.add(new Horse("C", 3, 0));
        game = new Hippodrome(horses);
        for (Horse h : horses
                ) {
            System.out.println(h.getName() + " " + h.getSpeed() + " " + h.getDistance());
        }
        game.run();
        game.printWinner();
    }
}
