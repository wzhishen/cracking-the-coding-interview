package chap18;

public class Q12 {
//    Given an NxN matrix of positive and negative integers, write code to find the
//    submatrix with the largest possible sum.
    
    //brute force
    //returns [r1, c1, r2, c2, sum] where (r1,c1),(r2,c2) represents 
    //the diagonal of submatrix
    static int[] findLargestSubmatrix(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int[] ret = {-1, -1, -1, -1, 0};
        for (int r1 = 0; r1 < matrix.length; ++r1) {
            for (int r2 = r1; r2 < matrix.length; ++r2) {
                for (int c1 = 0; c1 < matrix[0].length; ++c1) {
                    for (int c2 = c1; c2 < matrix[0].length; ++c2) {
                        int sum = getSum(matrix, r1, c1, r2, c2);
                        if (sum > maxSum) {
                            maxSum = sum;
                            ret = new int[] {r1, c1, r2, c2, sum};
                        }
                    }
                }
            }
        }
        return ret;
    }
    
    static int getSum(int[][] matrix, int r1, int c1, int r2, int c2) {
        int sum = 0;
        for (int r = r1; r <= r2; ++r) {
            for (int c = c1; c <= c2; ++c) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }
    
    //--------------------------------------
    public static void main(String[]args) {
        int[][]m = {
                {1,-2,3,1},
                {1,5,-4,1},
                {1,1,0,2},
                {-1,1,1,-8}};
        int[] r = findLargestSubmatrix(m);
        System.out.println("("+r[0]+", "+r[1]+") ("+r[2]+", "+r[3]+") sum: "+r[4]);
    }

}
