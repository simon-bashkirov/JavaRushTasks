package com.javarush.task.task35.task3513.utils;

import com.javarush.task.task35.task3513.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayOperations {

    private static Tile[] reverseArray(Tile[] gameTile) {
        List<Tile> tiles = new ArrayList<>(Arrays.asList(gameTile));
        Collections.reverse(tiles);
        return tiles.toArray(new Tile[gameTile.length]);
    }

    private static Tile[][] transpose(Tile[][] gameTiles){
        Tile[][] temp = new Tile[gameTiles.length][gameTiles.length];
        for (int i = 0; i < gameTiles.length; i++)
            for (int j = 0; j < gameTiles.length; j++)
                temp[j][i] = gameTiles[i][j];
        return temp;
    }

    private static Tile[][] flip(Tile[][] gameTiles, Flip direction){
        Tile[][] temp = new Tile[gameTiles.length][gameTiles.length];
        for (int i1 = 0; i1 < gameTiles.length; i1++) {
            for (int j1 = 0; j1 < gameTiles.length; j1++) {
                int i2 = (direction == Flip.HORIZONTALLY) ? i1 : gameTiles.length - 1 - i1;
                int j2 = (direction == Flip.HORIZONTALLY) ? gameTiles.length - 1 - j1 : j1;
                temp[i2][j2] = gameTiles[i1][j1];
            }
        }
        return temp;
    }

    private static Tile[][] rotate(Tile[][] gameTiles, Rotate direction){
        Tile[][] temp = new Tile[gameTiles.length][gameTiles.length];
        for (int i1 = 0; i1 < gameTiles.length; i1++) {
            for (int j1 = 0; j1 < gameTiles.length; j1++) {
                int i2 = (direction == Rotate.COUNTERCLOCKWISE) ? gameTiles.length - 1 - j1 : j1;
                int j2 = (direction == Rotate.COUNTERCLOCKWISE) ? i1 : gameTiles.length - 1 - i1;
                temp[i2][j2] = gameTiles[i1][j1];
            }
        }
        return temp;
    }

    public static Tile[][] rotateClockwise(Tile[][] gameTiles) {
        return rotate(gameTiles, Rotate.CLOCKWISE);
    }

    public static Tile[][] rotateCounterclockwise(Tile[][] gameTiles) {
        return rotate(gameTiles, Rotate.COUNTERCLOCKWISE);
    }

    public static Tile[][] flipHorizontally(Tile[][] gameTiles) {
        return flip(gameTiles, Flip.HORIZONTALLY);
    }

    public static Tile[][] flipVerically(Tile[][] gameTiles) {
        return flip(gameTiles, Flip.VERTICALLY);
    }

    private enum Rotate {
        CLOCKWISE,
        COUNTERCLOCKWISE;
    }

    private enum Flip {
        HORIZONTALLY,
        VERTICALLY;
    }
}
