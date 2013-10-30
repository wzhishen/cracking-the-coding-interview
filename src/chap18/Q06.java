package chap18;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q06 {
//    Describe an algorithm to find the smallest one million numbers in one billion
//    numbers. Assume that the computer memory can hold all one billion numbers.
    
    ArrayList<Integer> findNSmallestElements(ArrayList<Integer> nums, int n) {
        if (nums == null) return null;
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int num : nums) {
            minheap.offer(num);
        }
        for (int i = 0; i < n; ++i) {
            ret.add(minheap.poll());
        }
        return ret;
    }

}
