package chap09;

public class Q09_2 {
//    N-queens problem. But this time just return the total number of distinct solutions.
    static final int GRID_SIZE = 8;
    
    //Each possible solution (ROW, COL) is stored as int[] columns
    //where columns[ROW] = COL
    static int placeQueens(int row, int[] columns) {
        int cnt = 0;
        if (row == GRID_SIZE) {
            return 1;
        }
        else {
            for (int col = 0; col < GRID_SIZE; ++col) {//check each col in current row
                if (checkValid(row, col, columns)) {
                    columns[row] = col;
                    cnt += placeQueens(row + 1, columns);
                }
            }
        }
        return cnt;
    }
    
    static boolean checkValid(int row, int col, int[] columns) {
        for (int prevRow = 0; prevRow < row; ++prevRow) {//check each previous row
            if (columns[prevRow] == col) return false;
            int colDistance = Math.abs(columns[prevRow] - col);
            if (colDistance == row - prevRow) return false;
        }
        return true;
    }
    
    static int placeQueens() {
        return placeQueens(0, new int[GRID_SIZE]);
    }
    
    //-----------------------------------
    public static void main(String[]args) {
        System.out.println(placeQueens());
    }
}
