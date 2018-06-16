package com.javarush.task.task35.task3513;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Tile {
    int value;

    private static Map<Integer, Integer> tileColors = new HashMap<>();

    static {
        tileColors.put(0, 0xcdc1b4);
        tileColors.put(2, 0xeee4da);
        tileColors.put(4, 0xede0c8);
        tileColors.put(8, 0xf2b179);
        tileColors.put(16, 0xf59563);
        tileColors.put(32, 0xf67c5f);
        tileColors.put(64, 0xf65e3b);
        tileColors.put(128, 0xedcf72);
        tileColors.put(256, 0xedcc61);
        tileColors.put(512, 0xedc850);
        tileColors.put(1024, 0xedc53f);
        tileColors.put(2048, 0xedc22e);
    }

    public Tile() {
    }

    public Tile(int value) {
        this.value = value;
    }

    public Tile(Tile tile) {
        value = tile.value;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public Color getFontColor() {
        return new Color(value < 16 ? 0x776e65 : 0xf9f6f2);
    }

    public Color getTileColor() {
        Integer color = tileColors.get(value);
        return new Color(color != null ? color : 0xff0000);
    }

    @Override
    public String toString() {
        return "Tile{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return value == tile.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

}
