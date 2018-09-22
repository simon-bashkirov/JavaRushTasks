package com.javarush.task.task25.task2515;

import java.util.ArrayList;

public class SpaceShip extends BaseObject {
    private double dx;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    /*
     * если dx = -1, корабль каждый ход идет на 1 влево
     */
    public void moveLeft() {
        dx = -1;
    }

    /*
     * если dx = 1, корабль каждый ход идет на 1 вправо
     */
    public void moveRight() {
        dx = 1;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {
        x += dx;
        checkBorders(0 + radius, Space.game.getWidth() - radius, 0 + radius, Space.game.getHeight() - radius);
    }

    public void fire() {
        ArrayList<Rocket> rockets = Space.game.getRockets();
        rockets.add(new Rocket(x - 2, y));
        rockets.add(new Rocket(x + 2, y));
    }
}
