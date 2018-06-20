package com.javarush.task.task35.task3513;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private Model model = new Model();

    @Test
    void resetGameTiles() {
//        System.out.println("resetGameTiles()");
        model.resetGameTiles();
        int sum = 0;
        Tile[][] gameTiles = getGameTiles();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                sum += gameTiles[i][j].value;
            }
        }
//        System.out.println("expected = " + 4 + ", sum = " + sum);
        assertEquals(4, sum);
    }

    @Test
    void left() {
        Tile[][] tiles = null;
        tiles = generateTiles(new Integer[][]{
                {2, 2, 2, 2},
                {2, 2, 8, 0},
                {0, 4, 4, 2},
                {0, 0, 0, 0}
        });

        setGameTiles(tiles);

        Tile[][] tilesUpdatedExpected = generateTiles(new Integer[][]{
                {4, 4, 0, 0},
                {4, 8, 0, 0},
                {8, 2, 0, 0},
                {0, 0, 0, 0}
        });

//        System.out.println("tiles");
//        printTiles(tiles);
        model.left();
//        System.out.println("tilesUpdated");
//        printTiles(tiles);

        assertTrue(areBoardsEqualAfterMove(tiles, tilesUpdatedExpected));
    }

    @Test
    void right() {
        Tile[][] tiles = null;
        tiles = generateTiles(new Integer[][]{
                {2, 2, 2, 2},
                {2, 2, 8, 0},
                {0, 4, 4, 2},
                {0, 0, 0, 0}
        });

        setGameTiles(tiles);

        Tile[][] tilesUpdatedExpected = generateTiles(new Integer[][]{
                {0, 0, 4, 4},
                {0, 0, 4, 8},
                {0, 0, 8, 2},
                {0, 0, 0, 0}
        });

        model.right();

        assertTrue(areBoardsEqualAfterMove(tiles, tilesUpdatedExpected));
    }

    @Test
    void up() {
        Tile[][] tiles = null;
        tiles = generateTiles(new Integer[][]{
                {2, 2, 2, 2},
                {2, 2, 8, 0},
                {0, 4, 4, 2},
                {0, 0, 0, 0}
        });

        setGameTiles(tiles);

        Tile[][] tilesUpdatedExpected = generateTiles(new Integer[][]{
                {4, 4, 2, 4},
                {0, 4, 8, 0},
                {0, 0, 3, 0},
                {0, 0, 0, 0}
        });

        model.right();

        assertTrue(areBoardsEqualAfterMove(tiles, tilesUpdatedExpected));
    }

    @Test
    void down() {
        Tile[][] tiles = null;
        tiles = generateTiles(new Integer[][]{
                {2, 2, 2, 2},
                {2, 2, 8, 0},
                {0, 4, 4, 2},
                {0, 0, 0, 0}
        });

        setGameTiles(tiles);

        Tile[][] tilesUpdatedExpected = generateTiles(new Integer[][]{
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {0, 4, 8, 0},
                {4, 4, 4, 4}
        });

        model.right();

        assertTrue(areBoardsEqualAfterMove(tiles, tilesUpdatedExpected));
    }

    public void setGameTiles(Tile[][] tiles) {
        Field gameTiles;
        try {
            gameTiles = model.getClass().getDeclaredField("gameTiles");
            gameTiles.setAccessible(true);
            gameTiles.set(model, tiles);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Tile[][] getGameTiles() {
        Field gameTiles;
        try {
            gameTiles = model.getClass().getDeclaredField("gameTiles");
            gameTiles.setAccessible(true);
            return (Tile[][]) gameTiles.get(model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Tile[][] generateTiles(Integer[][] tileValues) {
        Tile[][] tiles = new Tile[4][4];

        for (int i = 0; i < tileValues.length; i++) {
            for (int j = 0; j < tileValues.length; j++) {
                tiles[i][j] = new Tile(tileValues[i][j]);
            }
        }

        return tiles;
    }

    public void printTiles(Tile[][] tiles) {
        int maxLen = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                int length = String.valueOf(tiles[i][j].value).length();
                if (length > maxLen)
                    maxLen = length;
            }
        }
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                System.out.print(String.format("[%" + maxLen + "s]",tiles[i][j].value));
            }
            System.out.println();
        }
    }

    public boolean areBoardsEqualAfterMove(Tile[][] tiles1, Tile[][] tiles2) {
        boolean areEqual = false; // 1 new tile is ignored
        for (int i = 0; i < tiles1.length; i++) {
            for (int j = 0; j < tiles1.length; j++) {
                areEqual = tiles1[i][j].equals(tiles1[i][j]) || (tiles1[i][j].value == 0 && tiles1[i][j].value == 2);
            }
        }
        return areEqual;
    }

    @Test
    void canMove() {
        Tile[][] tiles = null;
        tiles = generateTiles(new Integer[][]{
                {2, 2, 2, 2},
                {2, 2, 8, 0},
                {0, 4, 4, 2},
                {0, 0, 0, 0}
        });
        setGameTiles(tiles);
        assertTrue(model.canMove());

        tiles = generateTiles(new Integer[][]{
                {2, 4,16, 2},
                {8, 2, 8, 0},
                {4, 8, 4, 2},
                {2, 4, 2, 4}
        });
        setGameTiles(tiles);
        assertTrue(model.canMove());

        tiles = generateTiles(new Integer[][]{
                {2, 4,16, 2},
                {8, 2, 8, 4},
                {4, 8, 4, 2},
                {2, 4, 2, 4}
        });
        setGameTiles(tiles);
        assertFalse(model.canMove());
    }
}