package chap01;

import java.util.HashMap;

public class E3 {
//    Given an array of positive and negative integers (no 0's in the array). 
//    Find the first sub-array with zero sum? handle all the edge cases.
    
    static int[] findZeroSumArr(int[] a) {
        if (a == null) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1); //XXX: edge case: zero sum of [0..i]
        int sum = 0;
        for (int i = 0; i < a.length; ++i) {
            sum += a[i];
            if (map.containsKey(sum)) {
                return new int[] {map.get(sum) + 1, i};
            }
            else {
                map.put(sum, i);
            }
        }
        return new int[] {-1, -1};
    }
    
    //----------------------------------------
    public static void main(String[] args) {
        int[] r = findZeroSumArr(new int[] {3,4,-1,5,3,4,-2,-5,7,-1,2});
        int[] s = findZeroSumArr(new int[] {1,2,3,-4,-2,7});
        System.out.println(r[0]+" "+r[1]);
        System.out.println(s[0]+" "+s[1]);
    }

}
