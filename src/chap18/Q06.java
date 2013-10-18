package chap18;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q06 {
//    Describe an algorithm to find the smallest one million numbers in one billion
//    numbers. Assume that the computer memory can hold all one billion numbers.
    
    ArrayList<Integer> findNSmallestElements(ArrayList<Integer> nums, int n) {
        if (nums == null) return null;
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(n);
        for (int num : nums) {
            minheap.offer(num);
        }
        return new ArrayList<Integer>(minheap);
    }

}
