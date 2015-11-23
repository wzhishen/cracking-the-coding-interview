package chap17;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Design an algorithm to find all pairs of integers within an
 * array which sum to a specified value.
 *
 * The array only contains unique values.
 */
public class Q12 {
    // O(n) time, O(n) space
    public static ArrayList<ArrayList<Integer>> twoSum(int[] a, int sum) {
        if (a == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; ++i) {
            int comp = sum - a[i];
            if (map.containsKey(comp)) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(a[map.get(comp)]);
                pair.add(a[i]);
                result.add(pair);
            }
            map.put(a[i], i);
        }
        return result;
    }

    // O(n log n) time, O(log n) space for sorting
    public static ArrayList<ArrayList<Integer>> twoSum2(int[] a, int sum) {
        if (a == null) return null;
        Arrays.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        int left = 0, right = a.length - 1;
        while (left < right) {
            if (a[left] + a[right] == sum) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(a[left]);
                pair.add(a[right]);
                result.add(pair);
                ++left;
                --right;
            } else if (a[left] + a[right] < sum) {
                ++left;
            } else {
                --right;
            }
        }
        return result;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(twoSum(new int[] {2, 5, 1, -1, 10, 7, 17, -3, -5}, 12));
        println(twoSum2(new int[] {2, 5, 1, -1, 10, 7, 17, -3, -5}, 12));
    }
}
