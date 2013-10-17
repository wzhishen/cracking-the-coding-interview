package chap17;

public class Q02 {
    // 0 means x, 1 means o, -1 means EMPTY.
    // N * N board
    int win(int[][] board) {
        int len = board.length;
        for (int i = 0; i < len; ++i) {
            int j;
            //check row
            if (board[i][0] != -1) {
                for (j = 1; j < len; ++j) {
                    if (board[i][j] != board[i][j-1]) break;
                }
                if (j == len) return board[i][0];
            }
            //check column
            if (board[0][i] != -1) {
                for (j = 1; j < len; ++j) {
                    if (board[j][i] != board[j-1][i]) break;
                }
                if (j == len) return board[0][i];
            }
        }
        int i;
        if (board[0][0] != -1) {
            for (i = 1; i < len; ++i) {
                if (board[i][i] != board[i-1][i-1]) break;
            }
            if (i == len) return board[0][0];
        }
        if (board[0][len-1] != -1) {
            for (i = 1; i < len; ++i) {
                if (board[i][len-i-1] != board[i-1][len-i]) break;
            }
            if (i == len) return board[0][len-1];
        }
        return -1;
    }
}
