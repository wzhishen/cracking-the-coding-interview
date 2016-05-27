package chap18;

import static helpers.Printer.*;

import java.util.ArrayList;

/**
 * Imagine you have a square matrix, where each cell (pixel) is either
 * black or white. Design an algorithm to find the maximum subsquare(s)
 * such that all four borders are filled with black pixels.
 * (Suppose black is 1, white is 0 in the matrix.)
 */
public class Q11 {
    // Brute force: O(n^4) time, O(1) space, n is the length of side of matrix.
    public static ArrayList<Square> findLargestSubsquare(int[][] matrix) {
        if (matrix == null) return null;
        ArrayList<Square> result = new ArrayList<Square>();
        for (int size = matrix.length; size >= 1; --size) {
            for (int i = 0; i < matrix.length - size + 1; ++i) {
                for (int j = 0; j < matrix[0].length - size + 1; ++j) {
                    if (isValid(matrix, i, j, size)) {
                        result.add(new Square(i, j, size));
                    }
                }
            }
            if (!result.isEmpty()) break;
        }
        return result;
    }

    private static boolean isValid(int[][] matrix, int row, int col, int size) {
        for (int i = row; i < row + size; ++i) {
            if (matrix[i][col] == 0) return false;
            if (matrix[i][col + size - 1] == 0) return false;
        }
        for (int j = col; j < col + size; ++j) {
            if(matrix[row][j] == 0) return false;
            if(matrix[row + size - 1][j] == 0) return false;
        }
        return true;
    }

    // Preprocess matrix: O(n^3) time, O(n^2) space, n is the length of side of matrix.
    public static ArrayList<Square> findLargestSubsquare2(int[][] matrix) {
        if (matrix == null) return null;
        Cell[][] cells = preprocess(matrix);
        ArrayList<Square> result = new ArrayList<Square>();
        for (int size = cells.length; size >= 1; --size) {
            for (int i = 0; i < cells.length - size + 1; ++i) {
                for (int j = 0; j < cells[0].length - size + 1; ++j) {
                    if (isValid(cells, i, j, size)) {
                        result.add(new Square(i, j, size));
                    }
                }
            }
            if (!result.isEmpty()) break;
        }
        return result;
    }

    public static Cell[][] preprocess(int[][] matrix) {
        int size = matrix.length;
        Cell[][] cells = new Cell[size][size];

        for (int i = size - 1; i >= 0; --i) {
            for (int j = size - 1; j >= 0; --j) {
                int right = matrix[i][j] + (j == size - 1 ? 0 : cells[i][j + 1].availableRight);
                int below = matrix[i][j] + (i == size - 1 ? 0 : cells[i + 1][j].availableBelow);
                cells[i][j] = new Cell(below, right);
            }
        }
        return cells;
    }

    private static boolean isValid(Cell[][] matrix, int row, int col, int size) {
        Cell topLeft = matrix[row][col];
        Cell topRight = matrix[row][col + size - 1];
        Cell bottomLeft = matrix[row + size - 1][col];
        Cell bottomRight = matrix[row + size - 1][col + size - 1];
        return (topLeft.availableBelow - bottomLeft.availableBelow + 1 == size) &&
               (topRight.availableBelow - bottomRight.availableBelow + 1 == size) &&
               (topLeft.availableRight - topRight.availableRight + 1 == size) &&
               (bottomLeft.availableRight - bottomRight.availableRight + 1 == size);
    }

    private static class Square {
        int row, col, size;
        public Square(int r, int c, int s) {
            row = r;
            col = c;
            size = s;
        }
        public String toString() {
            return "(" + row + "," + col + "," + size + ")";
        }
    }

    private static class Cell {
        int availableBelow, availableRight;
        public Cell(int b, int r) {
            availableBelow = b;
            availableRight = r;
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,1,1},
                          {1,1,1,0,1},
                          {1,1,1,1,1},
                          {1,1,1,1,0},
                          {1,0,1,0,1}};
        println(findLargestSubsquare(matrix));
        println(findLargestSubsquare2(matrix));
    }
}
