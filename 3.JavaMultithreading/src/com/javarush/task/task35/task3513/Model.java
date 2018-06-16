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

    public static void main(String[] args) {
        Model model = new Model();
        Tile[] tiles = {new Tile(2), new Tile(0), new Tile(2), new Tile(2)};
        boolean isChanged = false;
//        Tile[] tiles = {new Tile(2), new Tile(2), new Tile(2), new Tile(8)};
        System.out.println("Before compression: " + Arrays.toString(tiles));
        isChanged = model.compressTiles(tiles);
        System.out.println("After compression: " + Arrays.toString(tiles) + ",\n\t isChanged = " + isChanged);
        isChanged = model.mergeTiles(tiles);
        System.out.println("After merge: " + Arrays.toString(tiles) + ",\n\t isChanged = " + isChanged);
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty())
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

    private boolean compressTiles(Tile[] tiles) {
        Tile[] initialState = new Tile[tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            initialState[i] = new Tile(tiles[i].value);
        }

        int countOfZeros = 0;
        for (Tile tile : tiles) {
            if (tile.isEmpty())
                countOfZeros++;
        }

        int i = 0;
        while (countOfZeros > 0) {
            if (tiles[i].isEmpty()) {
                for (int j = i; j < tiles.length-1; j++) {
                    tiles[j].value = tiles[j+1].value;
                }
                tiles[tiles.length-1].value = 0;
                countOfZeros--;
            }
            else
                i++;
        }

        boolean isChanged = !Arrays.equals(initialState, tiles);
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        Tile[] initialState = new Tile[tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            initialState[i] = new Tile(tiles[i].value);
        }

        for (int i = 0; i < tiles.length-1; i++) { //cntOfMerges = 0; cntOfMerges < 2 &&
            Tile currentTile = tiles[i];
            Tile nextTile = tiles[i + 1];

            if (currentTile.value == nextTile.value) {
                currentTile.value *= 2;
                for (int j = i + 1; j < tiles.length-1; j++) {
                    tiles[j].value = tiles[j+1].value;
                }
                tiles[tiles.length-1].value = 0;

                if (currentTile.value > maxTile)
                    maxTile = currentTile.value;

                score += currentTile.value;
            }
        }

        boolean isChanged = !Arrays.equals(initialState, tiles);
        return isChanged;
    }

    void left() {
        boolean isChanged = false;
        for (Tile[] gameTile : gameTiles) {
            isChanged |= compressTiles(gameTile);
            isChanged |= mergeTiles(gameTile);
        }
        if(isChanged) {
            addTile();
        }
    }

    public void setGameTiles(Tile[][] gameTiles) {
        this.gameTiles = gameTiles;
    }
}
