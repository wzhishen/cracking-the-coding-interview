package chap11;

public class Q6 {
//    Given an M x N matrix in which each row and each column is sorted in ascending
//    order, write a method to find an element.
    
    // returns index [i, j]
    static int[] snakeSearch(int[][] m, int x) {
        if (m == null) return new int[] {-1, -1};
        int i = 0;
        int j = m[0].length - 1;
        while (i <= m.length && j >= 0) {
            if (m[i][j] == x) return new int[] {i, j};
            else if (m[i][j] > x) --j;
            else ++i;
        }
        return new int[] {-1, -1};
    }
    
    //----------------------------------------
    public static void main(String[]s) {
        int[][]a={
            {15,20,40,85},
            {20,35,80,95},
            {30,55,95,105},
            {40,80,100,120}};
        int[]res=snakeSearch(a, 55);
        System.out.println(res[0]+" "+res[1]);
    }

}
