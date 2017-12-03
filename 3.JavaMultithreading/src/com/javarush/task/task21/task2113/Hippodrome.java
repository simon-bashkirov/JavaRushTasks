package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public static Hippodrome game;

    public Hippodrome() {
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(new Horse("Sally",3,0));
        game.getHorses().add(new Horse("Ilhy",3,0));
        game.getHorses().add(new Horse("Bet",3,0));
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) System.out.println();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner() {
        double max_distance = 0;
        int horse_number = 0;
        for (int i = 0; i < horses.size(); i++) {
            Horse horse = horses.get(i);
            if (horse.getDistance() > max_distance) {
                max_distance = horse.getDistance();
                horse_number = i;
            }
        }
        return horses.get(horse_number);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
