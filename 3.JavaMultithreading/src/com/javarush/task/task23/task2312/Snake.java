package com.javarush.task.task23.task2312;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new LinkedList<>();
        sections.add(new SnakeSection(x,y));
        isAlive = true;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (isAlive) {
            if (direction==SnakeDirection.UP) move(0,-1);
            else if (direction==SnakeDirection.RIGHT) move(1,0);
            else if (direction==SnakeDirection.DOWN) move(0, 1);
            else if (direction==SnakeDirection.LEFT) move(-1,0);
        }
    }

    public void move(int x, int y) {
        SnakeSection newSection = new SnakeSection(sections.get(0).getX()+x,sections.get(0).getY()+y);
        checkBody(newSection);
        checkBorders(newSection);
        if (isAlive) {
            sections.add(0,newSection);
            if (newSection.getX() == Room.game.getMouse().getX() && newSection.getY() == Room.game.getMouse().getY()) {
                Room.game.eatMouse();
            } else sections.remove(sections.size()-1);
        }
    }

    public void checkBorders(SnakeSection head) {
        if (head.getX() < 0 || head.getX() >= Room.game.getWidth() || head.getY() < 0 || head.getY() >= Room.game.getHeight()) isAlive = false;
    }

    public void checkBody(SnakeSection head) {
        if (sections.contains(head)) isAlive = false;
    }
}
