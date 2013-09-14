package chap01;

public class Q6_2 {
    
    static void rotateCounterclockwiseInPlace(int[][] matrix, int n) {
        for (int layer = 0; layer < n/2; ++layer) {
            for (int i = layer; i < n - 1 - layer; ++i) {
                // save top
                int tmp = matrix[layer][i];
                
                // right to top
                matrix[layer][i] = matrix[i][n - 1 - layer];
                
                // bottom to right
                matrix[i][n - 1 - layer] = matrix[n - 1 - layer][n - 1 - i];
                
                // left to bottom
                matrix[n - 1 - layer][n - 1- i] = matrix[n - 1 - i][layer];
                
                // top to left
                matrix[n - 1 - i][layer] = tmp;
            }
        }
    }
    
    static void mirrorNWSE(int[][] matrix, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    static void mirrorNESW(int[][] matrix, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tmp;
            }
        }
    }
    
    static void mirrorHorizontal(int[][] matrix, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n/2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
    
    static void mirrorVertical(int[][] matrix, int n) {
        for (int i = 0; i < n/2; ++i) {
            for (int j = 0; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
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
        
        rotateCounterclockwiseInPlace(a, 5);
        printArray(a);
        System.out.println();
        resetArray(a);
        
        mirrorNWSE(a, 5);
        printArray(a);
        System.out.println();
        resetArray(a);
        
        mirrorNESW(a, 5);
        printArray(a);
        System.out.println();
        resetArray(a);
        
        mirrorHorizontal(a, 5);
        printArray(a);
        System.out.println();
        resetArray(a);
        
        mirrorVertical(a, 5);
        printArray(a);
        System.out.println();
        resetArray(a);
    }
    
    private static void printArray(int[][] a) {
        for (int[] row : a) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    
    private static void resetArray(int[][] a) {
        a[0][0]=1;a[0][1]=2;a[0][2]=3;a[0][3]=4;a[0][4]=5;
        a[1][0]=11;a[1][1]=22;a[1][2]=33;a[1][3]=44;a[1][4]=55;
        a[2][0]=5;a[2][1]=4;a[2][2]=3;a[2][3]=2;a[2][4]=1;
        a[3][0]=55;a[3][1]=44;a[3][2]=33;a[3][3]=22;a[3][4]=11;
        a[4][0]=6;a[4][1]=7;a[4][2]=8;a[4][3]=9;a[4][4]=0;
    }

}
