package chap09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q04 {
//    Write a method to return all subsets of a set.
    
//    SOLUTION: We compute P(n-1), clone the results, and then add an to each of these cloned sets.
    
    static ArrayList<ArrayList<Integer>> getSubsets2(List<Integer> set) {
        if (set == null) return null;
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 1<<set.size(); ++i) {
            subsets.add(getIthSubset(i, set));
        }
        return subsets;
    }
    
    static private ArrayList<Integer> getIthSubset(int i, List<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        for (int k = i, index = 0; k > 0; k >>= 1, ++index) {//XXX: index is not the same as k
            if ((k & 1) > 0) {
                subset.add(set.get(index));
            }
        }
        return subset;
    }
    
    static ArrayList<ArrayList<Integer>> getSubsets(List<Integer> set) {
        if (set == null) return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (set.isEmpty()) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        ArrayList<ArrayList<Integer>> last = getSubsets(set.subList(1, set.size()));
        ret.addAll(last);
        for (ArrayList<Integer> subset : last) {
            ArrayList<Integer> newset = new ArrayList<Integer>(subset);
            newset.add(set.get(0));
            ret.add(newset);
        }
        return ret;
    }
    
    static ArrayList<ArrayList<Integer>> getSubsetsByNum(int n) {
        if (n < 0) {
            return null;
        }
        else if (n == 0) {
            ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
            subsets.add(new ArrayList<Integer>());
            return subsets;
        }
        else {
            ArrayList<ArrayList<Integer>> last = getSubsetsByNum(n - 1);
            ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>(last);
            for (ArrayList<Integer> subset : last) {
                ArrayList<Integer> newset = new ArrayList<Integer>();
                newset.addAll(subset);
                newset.add(n);
                subsets.add(newset);
            }
            return subsets;
        }
        
    }
    
    //---------------------------------------------
    public static void main(String[]args) {
        System.out.println(getSubsetsByNum(4));
        System.out.println();
        Integer[] a = {1,3,5,7};
        System.out.println(getSubsets2(Arrays.asList(a)));
        System.out.println();
        System.out.println(getSubsets(Arrays.asList(a)));
    }
}
