package chap09;

import static helpers.Printer.*;

import java.util.ArrayList;

/**
 * Write an algorithm to print all ways of arranging eight queens
 * on an 8x8 chess board so that none of them share the same row,
 * column or diagonal. In this case, "diagonal" means all diagonals,
 * not just the two that bisect the board.
 */
public class Q09 {
    public static ArrayList<int[]> placeQueens(int gridSize) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        placeQueens(0, new int[gridSize], result, gridSize);
        return result;
    }

    private static void placeQueens(int row, int[] solution, ArrayList<int[]> solutions, int gridSize) {
        if (row == gridSize) {
            solutions.add(solution.clone());
            return;
        }
        for (int col = 0; col < gridSize; ++col) {
            if (canPlace(row, col, solution)) {
                solution[row] = col;
                placeQueens(row + 1, solution, solutions, gridSize);
            }
        }
    }

    /*
     * FOLLOW UP
     * What if you only need to count the number of solutions?
     */
    public static int placeQueensNum(int gridSize) {
        return placeQueensNum(0, new int[gridSize], gridSize);
    }

    private static int placeQueensNum(int row, int[] solution, int gridSize) {
        if (row == gridSize) {
            return 1;
        }
        int num = 0;
        for (int col = 0; col < gridSize; ++col) {
            if (canPlace(row, col, solution)) {
                solution[row] = col;
                num += placeQueensNum(row + 1, solution, gridSize);
            }
        }
        return num;
    }

    private static boolean canPlace(int row, int col, int[] solution) {
        for (int prevRow = 0; prevRow < row; ++prevRow) {
            if (col == solution[prevRow]) return false;
            if (row - prevRow == Math.abs(col - solution[prevRow])) return false;
        }
        return true;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println("Solutions:");
        printSolution(placeQueens(8));
        println("\nNumber of solutions:");
        println(placeQueensNum(8));
    }

    private static void printSolution(ArrayList<int[]> solutions) {
        for (int[] solution : solutions) {
            for (int i : solution) print(i + " ");
            println();
        }
    }
}
