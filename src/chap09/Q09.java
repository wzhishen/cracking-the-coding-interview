package chap09;

import java.util.ArrayList;

public class Q09 {
//    Write an algorithm to print all ways of arranging eight queens on an 8x8 chess
//    board so that none of them share the same row, column or diagonal. In this case,
//    "diagonal" means all diagonals, not just the two that bisect the board.
    static final int GRID_SIZE = 8;
    
    //Each possible solution (ROW, COL) is stored as int[] columns
    //where columns[ROW] = COL
    static void placeQueens(int row, int[] columns, ArrayList<int[]> result) {
        if (row == GRID_SIZE) {
            result.add(columns.clone());
        }
        else {
            for (int col = 0; col < GRID_SIZE; ++col) {//check each col in current row
                if (checkValid(row, col, columns)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, result);
                }
            }
        }
    }
    
    static boolean checkValid(int row, int col, int[] columns) {
        for (int prevRow = 0; prevRow < row; ++prevRow) {//check each previous row
            if (columns[prevRow] == col) return false;
            int colDistance = Math.abs(columns[prevRow] - col);
            if (colDistance == row - prevRow) return false;
        }
        return true;
    }
    
    static ArrayList<int[]> placeQueens() {
        ArrayList<int[]> ret = new ArrayList<int[]>();
        placeQueens(0, new int[GRID_SIZE], ret);
        return ret;
    }
    
    //-----------------------------------
    public static void main(String[]args) {
        ArrayList<int[]> ret = placeQueens();
        for (int[] r : ret) {
            for (int i : r) {
                System.out.print(i+" ");
            }
        System.out.println();
        }
    }

}
