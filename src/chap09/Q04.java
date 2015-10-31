package chap09;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a method to return all subsets of a set.
 */
public class Q04 {
    /*
     * Naive recursion
     * Compute P(n-1), clone the results, and then add a(n) to each of these cloned sets.
     * O(2^n) time and space.
     */
    public static ArrayList<ArrayList<Integer>> getSubsetsRecursive(List<Integer> set) {
        if (set == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (set.isEmpty()) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<ArrayList<Integer>> lastSubsets = getSubsetsRecursive(set.subList(1, set.size()));
        result.addAll(lastSubsets);
        for (ArrayList<Integer> lastSubset : lastSubsets) {
            ArrayList<Integer> subset = new ArrayList<Integer>(lastSubset);
            subset.add(set.get(0));
            result.add(subset);
        }
        return result;
    }

    /*
     * Iterate through all numbers from 1 to 2^n and translate the binary representation
     * of the numbers into a set.
     * O(2^n) time and space.
     */
    public static ArrayList<ArrayList<Integer>> getSubsetsIterative(List<Integer> set) {
        if (set == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int bitmap = 0; bitmap < 1 << set.size(); ++bitmap) {
            result.add(getSubsetFromBitmap(set, bitmap));
        }
        return result;
    }

    private static ArrayList<Integer> getSubsetFromBitmap(List<Integer> set, int bitmap) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int i = 0;
        while (bitmap > 0) {
            if ((bitmap & 1) != 0) subset.add(set.get(i));
            bitmap >>= 1;
            ++i;
        }
        return subset;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Integer[] a = {1,3,5,7};
        println(getSubsetsRecursive(Arrays.asList(a)));
        println(getSubsetsIterative(Arrays.asList(a)));
    }
}
