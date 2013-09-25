package chap17;

public class Q08 {
//    You are given an array of integers (both positive and negative). Find the contiguous
//    sequence with the largest sum. Return the sum.
//    EXAMPLE
//    Input: 2, -8, 3, -2, 4, -10
//    Outputs (i.e., {3, -2, 4})
    
    //returns [begIndexInc, endIndexInc, maxSum]
    static int[] getMaxSumSeq(int[] a) {
        if (a == null) return null;
        int sum = 0;
        int maxSum = 0;
        int[] triple = new int[3];
        triple[0] = 0;
        for (int i = 0; i < a.length; ++i) {
            sum += a[i];
            if (sum > maxSum) {
                maxSum = sum;
                triple[1] = i;
                triple[2] = maxSum;
            }
            else if (sum < 0) {
                sum = 0;
                triple[0] = i + 1;
            }
        }
        return triple;
    }
    
    //-----------------------------------
    public static void main(String[]args) {
        int[] a = {2, -8, 3, 5, 1, -2, 4, -10};
        int[] res = getMaxSumSeq(a);
        System.out.println(res[0]+" "+res[1]+" "+res[2]);
    }

}
