package chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q12 {
//    Design an algorithm to find all pairs of integers within an array which sum to a
//    specified value.
    
    //have array sorted; have two pointers, move them inward
    //O(n log n) time
    ArrayList<ArrayList<Integer>> findPairSum(int[] a, int sum) {
        if (a == null) return null;
        ArrayList<ArrayList<Integer>> ret = new  ArrayList<ArrayList<Integer>>();
        Arrays.sort(a);
        int head = 0;
        int tail = a.length - 1;
        while (head < tail) {
            if (a[head] + a[tail] == sum) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(a[head]); pair.add(a[tail]);
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
    
    //use a hashtable
    //O(n) time, extra O(n) space
    ArrayList<ArrayList<Integer>> findPairSum2(int[] a, int sum) {
        if (a == null) return null;
        ArrayList<ArrayList<Integer>> ret = new  ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; ++i) {
            if (map.containsKey(a[i])) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(a[map.get(a[i])]); pair.add(a[i]);
                ret.add(pair);
            }
            else {
                map.put(sum - a[i], i);
            }
        }
        return ret;
    }

}
