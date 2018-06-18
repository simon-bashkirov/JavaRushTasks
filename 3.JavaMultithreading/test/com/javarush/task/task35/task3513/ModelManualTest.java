package com.javarush.task.task35.task3513;

import com.javarush.task.task35.task3513.utils.ArrayOperations;

import java.io.StringReader;
import java.lang.reflect.Field;

public class ModelManualTest {
    public static Model model = new Model();

    public static void main(String[] args) {
        Tile[][] tiles = generateTiles();

        setTiles(tiles);

        printTiles(tiles);

        System.out.println("Moving tiles");
        model.down();
        printTiles(tiles);
        /*System.out.println("Running right()");
        model.right();
        printTiles(tiles);*/
    }

    public static void printTiles(Tile[][] tiles) {
        int maxLen = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int i1 = 0; i1 < tiles.length; i1++) {
                int length = String.valueOf(tiles[i][i1].value).length();
                if (length > maxLen)
                    maxLen = length;
            }
        }
        for (int i = 0; i < tiles.length; i++) {
            for (int i1 = 0; i1 < tiles.length; i1++) {
                System.out.print(String.format("[%" + maxLen + "s]",tiles[i][i1].value));
            }
            System.out.println();
        }
    }

    public static void setTiles(Tile[][] tiles) {
        Field date1;
        try {
            date1 = model.getClass().getDeclaredField("gameTiles");
            date1.setAccessible(true);
            date1.set(model, tiles);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Tile[][] generateTiles() {
        Integer[][] tileValues = {
                {2, 2, 2, 2},
                {2, 2, 8, 0},
                {0, 4, 4, 2},
                {0, 0, 0, 0}
        };
        /*Integer[][] tileValues = {
                {2,0,0,0},
                {2,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };*/

        Tile[][] tiles = new Tile[4][4];

        for (int i = 0; i < tileValues.length; i++) {
            for (int i1 = 0; i1 < tileValues.length; i1++) {
                tiles[i][i1] = new Tile(tileValues[i][i1]);
            }
        }

        return tiles;
    }
}
