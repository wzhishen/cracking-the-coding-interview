package chap17;

import static helpers.Printer.*;

/**
 * Design an algorithm to figure out if someone has won a
 * game of tic-tac-toe.
 */
public class Q02 {
    /*
     * N * N board
     * Returns 0 if 'X' wins, 1 if 'O' wins, -1 if tie.
     */
    public static int win(int[][] board) {
        if (board == null)
            throw new IllegalArgumentException("Invalid board!");
        int n = board.length;
        for (int i = 0; i < n; ++i) {
            // check row
            int shape = board[i][0];
            if (shape != -1) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] != shape) break;
                    if (j == n - 1) return shape;
                }
            }
            // check column
            shape = board[0][i];
            if (shape != -1) {
                for (int j = 0; j < n; ++j) {
                    if (board[j][i] != shape) break;
                    if (j == n - 1) return shape;
                }
            }
        }
        // check diagonals
        int shape = board[0][0];
        if (shape != -1) {
            for (int i = 0; i < n; ++i) {
                if (board[i][i] != shape) break;
                if (i == n - 1) return shape;
            }
        }
        shape = board[0][n - 1];
        if (shape != -1) {
            for (int i = 0; i < n; ++i) {
                if (board[i][n - 1 - i] != shape) break;
                if (i == n - 1) return shape;
            }
        }
        return -1;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[][] board = {{1,-1,-1, 0, 1},
                         {0, 1, 1, 0, -1},
                         {0,-1, 1, 0, -1},
                         {1, 1, 1, 0, 1},
                         {1,-1,-1, 0, 1}};
        println(win(board));
    }
}
