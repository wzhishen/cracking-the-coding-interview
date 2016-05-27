package chap01;

import static helpers.Printer.*;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */
public class Q7 {
    // use boolean array
    static void setZeros(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        // mark zero
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    rows[i] = cols[j] = true;
                }
            }
        }

        // set zeros
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // use bit vector
    static void setZeros2(int[][] matrix) {
        long bitVecRows = 0;
        long bitVecCols = 0;

        // mark zero
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    bitVecRows |= 1 << i;
                    bitVecCols |= 1 << j; 
                }
            }
        }

        // set zeros
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if ((bitVecRows & (1 << i)) != 0 || (bitVecCols & (1 << j)) != 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[][] a = {{0,2,3,4,5},
                    {1,2,3,4,5},
                    {5,4,3,0,1},
                    {5,4,3,2,1},
                    {6,7,8,9,0}};
        setZeros2(a);
        printArray(a);
    }

    private static void printArray(int[][] a) {
        for (int[] row : a) {
            for (int col : row) {
                print(col + " ");
            }
            println();
        }
    }
}
