package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;

    public Model() {
        resetGameTiles();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        emptyTiles.get((int) (emptyTiles.size() * Math.random())).value = Math.random() < 0.9 ? 2 : 4;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        for (int i = 0; i < 2; i++) {
            addTile();
        }
    }

    private void compressTiles(Tile[] tiles) {
        List<Tile> tileList = new LinkedList<>(Arrays.asList(tiles));

        int countOfZeros = 0;
        for (Tile tile : tileList) {
            if (tile.isEmpty())
                countOfZeros++;
        }

        int i = 0;
        while (countOfZeros > 0) {
            if (tileList.get(i).isEmpty()) {
                tileList.add(tileList.remove(i));
                countOfZeros--;
            }
            else
                i++;
        }

        tiles = tileList.toArray(tiles);
    }

    private void mergeTiles(Tile[] tiles) {
        List<Tile> tileList = new LinkedList<>(Arrays.asList(tiles));

        for (int i = 0; i < tileList.size()-1; i++) { //cntOfMerges = 0; cntOfMerges < 2 &&
            Tile currentTile = tileList.get(i);
            Tile nextTile = tileList.get(i + 1);

            if (currentTile.value == nextTile.value) {
                currentTile.value *= 2;
                tileList.remove(i+1);
                tileList.add(new Tile());

                if (currentTile.value > maxTile)
                    maxTile = currentTile.value;

                score += currentTile.value;
            }
        }

        tiles = tileList.toArray(tiles);
    }
}
