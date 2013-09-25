package chap17;

public class Q06 {
//    Given an array of integers, write a method to find indices m and n such that if you
//    sorted elements m through n, the entire array would be sorted. Minimize n - m
//    (that is, find the smallest such sequence).
//    EXAMPLE
//    Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
//    Output: (3, 9)
//    
//    SOLUTION:
//    end(left_part) <= min(middle_part)
//    first(right_part) >= max(middle_part)
    
    static int[] findUnsortedPart(int[] a) {
        int leftEnd = 0;
        while (leftEnd+1 <= a.length-1 && a[leftEnd] <= a[leftEnd+1]) {
            ++leftEnd;
        }
        int rightFirst = a.length - 1;
        while (rightFirst-1 >= 0 && a[rightFirst] >= a[rightFirst-1]) {
            --rightFirst;
        }
        if (leftEnd >= rightFirst) return null;
        
        int min = min(a, leftEnd, rightFirst);//XXX
        while (a[leftEnd] > min) {
            --leftEnd;
        }
        ++leftEnd;
        int max = max(a, leftEnd, rightFirst);//XXX
        while (a[rightFirst] < max) {
            ++rightFirst;
        }
        --rightFirst;
        return new int[] {leftEnd, rightFirst};
    }
    
    static int min(int[] a, int low, int high) {
        int min = Integer.MAX_VALUE;
        for (int i = low; i <= high; ++i) {
            if (a[i] < min) min = a[i];
        }
        return min;
    }
    
    static int max(int[] a, int low, int high) {
        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; ++i) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }
    
    //---------------------------------
    public static void main(String[]args) {
        int[] a = {1, 2, 4, 7, 7, 10, 11, 7, 12, 12, 12, 16, 18, 19};
//        int[] a = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] res = findUnsortedPart(a);
        System.out.println(res[0]+" "+res[1]);
    }

}
