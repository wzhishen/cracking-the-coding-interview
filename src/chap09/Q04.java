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
     * Naive recursion:
     * Compute P(n-1), clone the results, and then add a(n) to each of these cloned sets.
     * O(2^n) time and space.
     */
    public static ArrayList<ArrayList<Integer>> getSubsetsNaive(List<Integer> set) {
        if (set == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (set.isEmpty()) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<ArrayList<Integer>> lastSubsets = getSubsetsNaive(set.subList(1, set.size()));
        result.addAll(lastSubsets);
        for (ArrayList<Integer> lastSubset : lastSubsets) {
            ArrayList<Integer> subset = new ArrayList<Integer>(lastSubset);
            subset.add(set.get(0));
            result.add(subset);
        }
        return result;
    }

    /*
     * Better recursion: backtracking
     */
    public static List<List<Integer>> getSubsetsBacktrack(List<Integer> set) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getSubsetsBacktrack(set, 0, result, new ArrayList<Integer>());
        return result;
    }

    private static void getSubsetsBacktrack(List<Integer> input, int index, List<List<Integer>> result, List<Integer> subset) {
        result.add(new ArrayList<Integer>(subset));
        for (int i = index; i < input.size(); ++i) {
            subset.add(input.get(i));
            getSubsetsBacktrack(input, i + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
    }

    /*
     * Bitmap:
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
        println(getSubsetsNaive(Arrays.asList(a)));
        println(getSubsetsBacktrack(Arrays.asList(a)));
        println(getSubsetsIterative(Arrays.asList(a)));
    }
}
