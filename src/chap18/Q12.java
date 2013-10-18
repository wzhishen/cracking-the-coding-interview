package chap18;

public class Q12 {
//    Given an NxN matrix of positive and negative integers, write code to find the
//    submatrix with the largest possible sum.
    
    //brute force: O(n^6) time.
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
    
    //preprocess matrix: O(n^4) time, reducing getSum to constant time.
    int[][] processMatrix(int[][] m) {
        if (m == null) return null;
        int[][] sumMatrix = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; ++ i) {
            int sumRowOne = 0; int sumColOne = 0;
            for (int j = 0; j < m[0].length; ++j) {
                if (i == 0) {
                    sumRowOne += m[i][j];
                    sumMatrix[i][j] = sumRowOne;
                }
                if (j == 0) {
                    sumColOne += m[i][j];
                    sumMatrix[i][j] = sumColOne;
                }
                if (i != 0 && j != 0) {
                    sumMatrix[i][j] = m[i][j] + 
                            sumMatrix[i][j-1] + 
                            sumMatrix[i-1][j] - 
                            sumMatrix[i-1][j-1];
                }
            }
        }
        return sumMatrix;
    }
    
    static int getSum2(int[][] sumMatrix, int r1, int c1, int r2, int c2) {
        return sumMatrix[r2][c2] - 
                sumMatrix[r1][c2] - 
                sumMatrix[r2][c1] + 
                sumMatrix[r1][c1];
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
