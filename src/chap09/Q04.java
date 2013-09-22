package chap09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q04 {
//    Write a method to return all subsets of a set.
    
//    SOLUTION: We compute P(n-l), clone the results, and then add an to each of these cloned sets.
    
    static ArrayList<ArrayList<Integer>> getSubsets2(List<Integer> set) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 1<<set.size(); ++i) {
            subsets.add(getIthSubset(i, set));
        }
        return subsets;
    }
    
    static private ArrayList<Integer> getIthSubset(int i, List<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for (int k = i; k > 0; k >>= 1, ++index) {//XXX: index is not the same as k
            if ((k & 1) > 0) {
                subset.add(set.get(index));
            }
        }
        return subset;
    }
    
    static ArrayList<ArrayList<Integer>> getSubsets(int n) {
        if (n < 0) {
            return null;
        }
        else if (n == 0) {
            ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
            subsets.add(new ArrayList<Integer>());
            return subsets;
        }
        else {
            ArrayList<ArrayList<Integer>> last = getSubsets(n - 1);
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
    
    //---------------------------------
    public static void main(String[]args) {
//        ArrayList<ArrayList<Integer>>res=getSubsets(10);
        Integer[] a = {1,3,5,7};
        ArrayList<ArrayList<Integer>>res=getSubsets2(Arrays.asList(a));
        for (ArrayList<Integer>l:res) {
            System.out.println(l);
        }
    }
}
