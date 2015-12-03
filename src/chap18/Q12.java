package chap18;

import static helpers.Printer.println;

import java.util.ArrayList;

/**
 * Given a matrix of positive and negative integers, write code
 * to find the submatrix(es) with the largest possible sum.
 */
public class Q12 {
    /*
     * Brute force:
     * O(n^6) time, O(1) space,
     * where n is the average length of side of matrix.
     */
    public static ArrayList<Submatrix> findLargestSubmatrix(int[][] matrix) {
        if (matrix == null) return null;
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Submatrix> result = new ArrayList<Submatrix>();
        for (int x1 = 0; x1 < matrix.length; ++x1) {
            for (int x2 = x1; x2 < matrix.length; ++x2) {
                for (int y1 = 0; y1 < matrix[0].length; ++y1) {
                    for (int y2 = y1; y2 < matrix[0].length; ++y2) {
                        int sum = sum(matrix, x1, y1, x2, y2);
                        Submatrix submatrix = new Submatrix(x1, y1, x2, y2, sum);
                        if (sum > maxSum) {
                            maxSum = sum;
                            result.clear();
                            result.add(submatrix);
                        } else if (sum == maxSum) {
                            result.add(submatrix);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static int sum(int[][] matrix, int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int x = x1; x <= x2; ++x) {
            for (int y = y1; y <= y2; ++y) {
                sum += matrix[x][y];
            }
        }
        return sum;
    }

    /*
     * Preprocess matrix:
     * O(n^4) time, O(n^2) space, or O(1) space if we are allowed to modify original matrix,
     * where n is the average length of side of matrix.
     */
    public static ArrayList<Submatrix> findLargestSubmatrix2(int[][] matrix) {
        if (matrix == null) return null;
        int[][] processed = preprocess(matrix);
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Submatrix> result = new ArrayList<Submatrix>();
        for (int x1 = 0; x1 < processed.length; ++x1) {
            for (int x2 = x1; x2 < processed.length; ++x2) {
                for (int y1 = 0; y1 < processed[0].length; ++y1) {
                    for (int y2 = y1; y2 < processed[0].length; ++y2) {
                        int sum = sum2(processed, x1, y1, x2, y2);
                        Submatrix submatrix = new Submatrix(x1, y1, x2, y2, sum);
                        if (sum > maxSum) {
                            maxSum = sum;
                            result.clear();
                            result.add(submatrix);
                        } else if (sum == maxSum) {
                            result.add(submatrix);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static int[][] preprocess(int[][] matrix) {
        int[][] processed = new int[matrix.length][matrix[0].length];
        processed[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; ++i) {
            processed[i][0] = processed[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < matrix[0].length; ++j) {
            processed[0][j] = processed[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                processed[i][j] = processed[i - 1][j] +
                                  processed[i][j - 1] -
                                  processed[i - 1][j - 1] +
                                  matrix[i][j];
            }
        }
        return processed;
    }

    /*
     * Optimal - make use of the solution to maximum subarray problem:
     * O(n^3) time, O(n) space for the temporary subarray,
     * where n is the average length of side of matrix.
     */
    public static ArrayList<Submatrix> findLargestSubmatrix3(int[][] matrix) {
        if (matrix == null) return null;
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Submatrix> result = new ArrayList<Submatrix>();
        for (int x1 = 0; x1 < matrix.length; ++x1) {
            int[] subArray = new int[matrix[0].length];
            for (int x2 = x1; x2 < matrix.length; ++x2) {
                for (int y = 0; y < matrix[0].length; ++y) {
                    subArray[y] += matrix[x2][y];
                }
                int[] res = findLargestSubarray(subArray);
                int y1 = res[0], y2 = res[1], sum = res[2];
                Submatrix submatrix = new Submatrix(x1, y1, x2, y2, sum);
                if (sum > maxSum) {
                    maxSum = sum;
                    result.clear();
                    result.add(submatrix);
                } else if (sum == maxSum) {
                    result.add(submatrix);
                }
            }
        }
        return result;
    }

    /*
     * O(n) time solution to the maximum subarray problem.
     * returns [start index for subarray with maxSum,
     *          end index for subarray with maxSum,
     *          maxSum]
     */
    private static int[] findLargestSubarray(int[] a) {
        int sum = 0, start = 0, end = 0;
        int maxSum = Integer.MIN_VALUE, maxStart = 0, maxEnd = 0;
        for (int i = 0; i < a.length; ++i) {
            end = i;
            sum += a[i];
            if (sum > maxSum) {
                maxSum = sum;
                maxStart = start;
                maxEnd = end;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return new int[] {maxStart, maxEnd, maxSum};
    }

    private static int sum2(int[][] processed, int x1, int y1, int x2, int y2) {
        if (x1 == 0 && y1 == 0) {
            return processed[x2][y2];
        } else if (x1 == 0) {
            return processed[x2][y2] - processed[x2][y1 - 1];
        } else if (y1 == 0) {
            return processed[x2][y2] - processed[x1 - 1][y2];
        } else {
            return processed[x2][y2] - processed[x1 - 1][y2] -
                   processed[x2][y1 - 1] + processed[x1 - 1][y1 - 1];
        }
    }

    private static class Submatrix {
        int x1, y1, x2, y2, sum;
        public Submatrix(int x1, int y1, int x2, int y2, int sum) {
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.sum = sum;
        }
        public String toString() {
            return "((" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")," + sum + ")";
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[][] matrix = {{ 1,-2, 3, 1},
                          { 1, 5,-4, 1},
                          { 1, 1, 0, 2},
                          {-1, 1, 1,-8},
                          {-8,-9, 9,-3}};
        println(findLargestSubmatrix(matrix));
        println(findLargestSubmatrix2(matrix));
        println(findLargestSubmatrix3(matrix));
    }
}
