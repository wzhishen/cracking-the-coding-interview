package chap17;

import java.util.ArrayList;
import java.util.Arrays;

public class Q12 {
//    Design an algorithm to find all pairs of integers within an array which sum to a
//    specified value.
    
    //have array sorted; have two pointers, move them inward
    ArrayList<ArrayList<Integer>> findPairSum(int[] a, int sum) {
        if (a == null) return null;
        ArrayList<ArrayList<Integer>> ret = new  ArrayList<ArrayList<Integer>>();
        Arrays.sort(a);
        int head = 0;
        int tail = a.length - 1;
        while (head < tail) {
            if (a[head] + a[tail] == sum) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(head); pair.add(tail);
                ret.add(pair);
                ++head;
                --tail;
            }
            else if (a[head] + a[tail] < sum) {
                ++head;
            }
            else {
                --tail;
            }
        }
        return ret;
    }

}
