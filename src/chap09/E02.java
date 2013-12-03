package chap09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class E02 {
    // find all subsets of the input array that sum to target (elements can be used more than once)
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        combinationSum(candidates, target, new ArrayList<Integer>(), ret);
        return new ArrayList<ArrayList<Integer>>(ret);
    }
    
    private void combinationSum(int[] a, int target, ArrayList<Integer> subset, HashSet<ArrayList<Integer>> res) {
        if (target <= 0) return;
        for (int n : a) {
            subset.add(n);
            if (n == target) {
                ArrayList<Integer> r = (ArrayList<Integer>) subset.clone();
                Collections.sort(r);
                res.add(r);
            }
            combinationSum(a, target - n, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
    
    // find all subsets of the input array that sum to target (elements can be used exactly once)
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0) return null;
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int n : num) a.add(n);
        combinationSum2(a, target, new ArrayList<Integer>(), ret);
        return new ArrayList<ArrayList<Integer>>(ret);
    }
    
    private void combinationSum2(ArrayList<Integer> num, int target, ArrayList<Integer> subset, HashSet<ArrayList<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
                ArrayList<Integer> r = (ArrayList<Integer>) subset.clone();
                Collections.sort(r);
                res.add(r);
                return;
        }
        for (int i = 0; i < num.size(); ++i) {
            int n = num.get(i);
            subset.add(n);
            int tmp = num.remove(i); // remove this element since it's already used
            combinationSum2(num, target - n, subset, res);
            num.add(i, tmp); // but remember to add them back when you're done from recursion
            subset.remove(subset.size() - 1);
        }
    }
    
    //----------------------------------
    public static void main(String[] args) {
        System.out.println(new E02().combinationSum2(new int[] {2,3,6,7}, 7));
//        System.out.println(new E02().combinationSum2(new int[] {32,33,5,32,12,7,17,33,29,13,18,16,23,28,26,26,12,6,23,19,22,12,9,6,5,34,22,27,11,33,27,30,24,27,27,31,29,32,21,24,32,5,27,21,20,10,12,28,11,31,12,20,30,17,21,30,8,8}, 27));
    }

}
