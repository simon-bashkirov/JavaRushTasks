package com.javarush.task.task22.task2213;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class FieldTest {

    private Field field;

    @Before
    private void setUp() {
        field = new Field(10, 8);
    }

    @Test
    public void removesEmptyLines() {
        field = new Field(10, 8);
        int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };



        printMatrix(matrix);

        field.setMatrix(matrix);
        field.removeFullLines();
        System.out.println();
        printMatrix(field.getMatrix());
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[0].length; i1++) {
                System.out.print(String.format("[%" + 2 + "s]",matrix[i][i1]));
            }
            System.out.println();
        }
    }
}