package chap01;

public class Q6 {
    //Given an image represented by an NxN matrix, where each pixel in the image is 4
    //bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
    
    // with extra space
    static int[][] rotate(int[][] matrix, int n) {
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ret[i][j] = matrix[n - 1 - j][i];
            }
        }
        return ret;
    }
    
    // in place
    static void rotateInPlace(int[][] matrix, int n) {
        for (int layer = 0; layer < n/2; ++layer) {
            for (int i = layer; i < n - 1 - layer; ++i) {
                // save top
                int tmp = matrix[layer][i];
                
                // left to top
                matrix[layer][i] = matrix[n - 1 - i][layer];
                
                // bottom to left
                matrix[n - 1 - i][layer] = matrix[n - 1 - layer][n - 1 - i];
                
                // right to bottom
                matrix[n - 1 - layer][n - 1 - i] = matrix[i][n - 1 - layer];
                
                // top to right
                matrix[i][n - 1 - layer] = tmp;
            }
        }
    }
    
    //-----------------------------------------------------
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4,5},
                     {11,22,33,44,55},
                     {5,4,3,2,1},
                     {55,44,33,22,11},
                     {6,7,8,9,0}};
        
        printArray(rotate(a, 5));
        System.out.println();
        
        rotateInPlace(a, 5);
        printArray(a);
    }
    
    private static void printArray(int[][] a) {
        for (int[] row : a) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

}
