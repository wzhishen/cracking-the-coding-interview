package chap18;

public class Q11 {
//    Imagine you have a square matrix, where each cell (pixel) is either black or white
//    Design an algorithm to find the maximum subsquare such that all four borders
//    are filled with black pixels.
//    
//    Suppose black is 1, white is 0.
    
    //brute force: O(n^4) time.
    //Preprocessing matrix can make isValid take constant time,
    //reducing total runtime to O(n^3).
    static Result findLargestSubsquare(int[][] matrix) {
        for (int len = matrix.length; len >= 2; --len) {
            Result res = findSubsquare(matrix, len);
            if (res != null) return res;
        }
        return null;
    }
    
    static Result findSubsquare(int[][] matrix, int length) {
        int cnt = matrix.length - length + 1;
        for (int i = 0; i < cnt; ++i) {
            for (int j = 0; j < cnt; ++j) {
                if (isValid(matrix, i, j, length)) {
                    return new Result(i, j, length);
                }
            }
        }
        return null;
    }
    
    static boolean isValid(int[][] m, int r, int c, int l) {
        for (int n = 0; n < l/*XXX*/; ++n) {
            //check top and bottom rows
            if (m[r][c+n] == 0 || m[r+l-1][c+n] == 0)
                return false;
            //check left and right columns
            if (m[r+n][c] == 0 || m[r+n][c+l-1] == 0)
                return false;
        }
        return true;
    }
    
    static class Result {
        int col; int row; int length;
        public Result(int r, int c, int l) {row=r;col=c;length=l;}
    }
    
    //--------------------------------------
    public static void main(String[]args) {
        int[][]m = {
                {1,0,1,1},
                {1,0,1,1},
                {1,1,0,1},
                {1,1,1,1}};
        Result r = findLargestSubsquare(m);
        System.out.println(r.row+" "+r.col+" "+r.length);
    }

}
