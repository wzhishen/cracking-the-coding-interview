package chap01;

import java.util.ArrayList;
import java.util.Arrays;

public class E4 {
//    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//    For example,
//    Given the following matrix:
//
//    [
//     [ 1, 2, 3 ],
//     [ 4, 5, 6 ],
//     [ 7, 8, 9 ]
//    ]
//    You should return [1,2,3,6,9,8,7,4,5].
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int width = matrix.length;
        //handles edge cases
        if (matrix == null || width == 0) return ret;
        int length = matrix[0].length;
        if (width == 1) {
            for (int n : matrix[0]) ret.add(n);
            return ret;
        }
        if (length == 1) {
            for (int[] n : matrix) ret.add(n[0]);
            return ret;
        }
        
        for (int layer1 = 0, layer2 = 0; layer1 <= width / 2 || layer2 <= length / 2; ++layer1, ++layer2) {
            if (layer1 <= width / 2) {
                //print top
                System.out.println(layer1+" Tcond "+(length - layer1 - 1));////////////////
                for (int j = layer1; j < length - layer1 - 1; ++j) {
                    System.out.print(matrix[layer1][j]+"t ");/////////////////
                    ret.add(matrix[layer1][j]);
                }
                System.out.println();//////////////////////
            }
            if (layer2 <= length / 2) {
                //print right
                System.out.println(layer2+" Rcond "+(width - layer2 - 1));////////////////
                for (int j = layer2; j <= width - layer2 - 1; ++j) {
                    System.out.print(matrix[j][length - layer2 - 1]+"r ");////////////////
                    ret.add(matrix[j][length - layer2 - 1]);
                }
                System.out.println();////////////////
            }
            if (layer1 <= width / 2) {
                //print bottom
                for (int j = layer1; j <= length - layer2 - 1; ++j) {
                    System.out.print(matrix[width - layer1 - 1][length - j - 1]+"b ");///////////////
                    ret.add(matrix[width - layer1 - 1][length - j - 1]);
                }
                System.out.println();/////////////////////
            }
            if (layer2 <= length / 2) {
                //print left
                for (int j = layer2; j <= width - layer2 - 1; ++j) {
                    System.out.print(matrix[width - j - 1][layer2]+"l ");///////////////////
                    ret.add(matrix[width - j - 1][layer2]);
                }
                System.out.println();////////////
            }
        }
        return ret;
    }
    
    //----------------------------------------
    public static void main(String[] args) {
        int[][] m= {
                {1, 2, 3, 4, 5, 6},
//                {7, 8, 9, 10,11,12},
//                {13,14,15,16,17,18},
//                {19,20,21,22,23,24},
                {25,26,27,28,29,30}};
//        int[][]m= {
//                {1,2,3,3,3,1},
//                {4,5,6,6,6,1},
//                {7,8,9,9,9,1}};
        System.out.println(new E4().spiralOrder(m));
    }

}
