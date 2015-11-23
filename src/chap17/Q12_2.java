package chap17;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Design an algorithm to find all pairs of integers within
 * an array which sum to a specified value.
 *
 * The array might contain duplicates.
 * Return a list of ALL possible index pairs.
 */
public class Q12_2 {
    // average O(n) time, O(n) space
    public static ArrayList<ArrayList<Integer>> twoSum(int[] a, int sum) {
        if (a == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < a.length; ++i) {
            int comp = sum - a[i];
            if (map.containsKey(comp)) {
                for (int compIndex : map.get(comp)) {
                    ArrayList<Integer> pair = new ArrayList<Integer>();
                    pair.add(compIndex);
                    pair.add(i);
                    result.add(pair);
                }
            }
            ArrayList<Integer> compIndexList = new ArrayList<Integer>();
            if (map.containsKey(a[i])) compIndexList = map.get(a[i]);
            compIndexList.add(i);
            map.put(a[i], compIndexList);
        }
        return result;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(twoSum(new int[] {2, 5, 1, -1, 10, 7, 5, 7, 10, 17, -3, -5}, 12));
        println(twoSum(new int[] {1, 1, 1, 1, 1, 1}, 2));
    }
}
