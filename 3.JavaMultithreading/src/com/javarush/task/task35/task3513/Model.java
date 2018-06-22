package com.javarush.task.task35.task3513;

import com.javarush.task.task35.task3513.utils.ArrayOperations;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
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

    public Tile[][] getGameTiles() {
        return gameTiles;
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
        previousStates = new Stack<>();
        previousScores = new Stack<>();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;

        int emptyTileCnt = 0;
        for (Tile tile : tiles) {
            if (tile.isEmpty())
                emptyTileCnt++;
        }

        if (emptyTileCnt == tiles.length || emptyTileCnt == 0)
            return isChanged;

        int i = 0;
        while (emptyTileCnt > 0) {
            if (tiles[i].isEmpty()) {
                for (int j = i; j < tiles.length-1; j++) {
                    if (!tiles[j+1].isEmpty()) {
                        isChanged = true;
                    }
                    tiles[j].value = tiles[j+1].value;
                }
                tiles[tiles.length-1].value = 0;
                emptyTileCnt--;
            }
            else
                i++;
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;

        for (int i = 0; i < tiles.length-1; i++) { //cntOfMerges = 0; cntOfMerges < 2 &&
            Tile currentTile = tiles[i];
            Tile nextTile = tiles[i + 1];

            if (currentTile.value != 0 && currentTile.value == nextTile.value) {
                currentTile.value *= 2;
                for (int j = i + 1; j < tiles.length-1; j++) {
                    tiles[j].value = tiles[j+1].value;
                }
                tiles[tiles.length-1].value = 0;

                if (currentTile.value > maxTile)
                    maxTile = currentTile.value;

                score += currentTile.value;
                isChanged = true;
            }
        }
        return isChanged;
    }

    void left() {
        if (isSaveNeeded)
            saveState(gameTiles);

        boolean isChanged = false;
        for (Tile[] tileRow : gameTiles) {

            isChanged |= compressTiles(tileRow) | mergeTiles(tileRow);
        }
        if(isChanged) {
            addTile();
        }

        isSaveNeeded = true;
    }

    void right() {
        saveState(gameTiles);
        gameTiles = ArrayOperations.flipHorizontally(gameTiles);
        left();
        gameTiles = ArrayOperations.flipHorizontally(gameTiles);
    }

    void up() {
        saveState(gameTiles);
        gameTiles = ArrayOperations.rotateCounterclockwise(gameTiles);
        left();
        gameTiles = ArrayOperations.rotateClockwise(gameTiles);
    }

    void down() {
        saveState(gameTiles);
        gameTiles = ArrayOperations.rotateClockwise(gameTiles);
        left();
        gameTiles = ArrayOperations.rotateCounterclockwise(gameTiles);
    }

    public boolean canMove() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].isEmpty())
                    return true;
                if (i < gameTiles.length - 1 && j < gameTiles.length - 1) {
                    if ( (gameTiles[i][j].value == gameTiles[i+1][j].value) || (gameTiles[i][j].value == gameTiles[i][j+1].value) ) {
                        return true;
                    }
                } else if (i == gameTiles.length - 1 && j < gameTiles.length - 1) {
                    if ( (gameTiles[i][j].value == gameTiles[i][j+1].value) ) {
                        return true;
                    }
                } else if (i < gameTiles.length - 1 && j == gameTiles.length - 1) {
                    if ( (gameTiles[i][j].value == gameTiles[i+1][j].value) ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tilesCopy = new Tile[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tilesCopy[i][j] = new Tile(tiles[i][j]);
            }
        }

        previousStates.push(tilesCopy);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int randomInt = (int) (Math.random() * 4);
        switch (randomInt) {
            case (0):
                left();
                break;
            case (1):
                right();
                break;
            case (2):
                up();
                break;
            case (3):
                down();
                break;
        }
    }

    boolean hasBoardChanged() {
        return !Arrays.deepEquals(gameTiles, previousStates.peek());
    }

    MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = hasBoardChanged() ?
                new MoveEfficiency(getEmptyTiles().size(), score, move) :
                new MoveEfficiency(-1, 0, move);
        rollback();
        return moveEfficiency;
    }
}
