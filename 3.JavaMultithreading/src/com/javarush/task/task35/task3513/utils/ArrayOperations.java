package com.javarush.task.task35.task3513.utils;

import com.javarush.task.task35.task3513.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayOperations {

    public static Tile[] reverseArray(Tile[] gameTile) {
        List<Tile> tiles = new ArrayList<>(Arrays.asList(gameTile));
        Collections.reverse(tiles);
        return tiles.toArray(new Tile[gameTile.length]);
    }

    public static Tile[][] transposeMatrix(Tile[][] gameTiles){
        Tile[][] temp = new Tile[gameTiles[0].length][gameTiles.length];
        for (int i = 0; i < gameTiles.length; i++)
            for (int j = 0; j < gameTiles[0].length; j++)
                temp[j][i] = gameTiles[i][j];
        return temp;
    }

    public static Tile[][] flipMatrixHorizontally(Tile[][] gameTiles){
        Tile[][] temp = new Tile[gameTiles[0].length][gameTiles.length];
        for (int i = 0; i < gameTiles.length; i++)
            for (int j = 0; j < gameTiles[0].length; j++)
                temp[i][j] = gameTiles[i][gameTiles[0].length - j - 1];
        return temp;
    }
}
