package chap18;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Describe an algorithm to find the smallest one million numbers in
 * one billion numbers. Assume that the computer memory can hold all
 * one billion numbers.
 *
 * SOLUTION
 * 1. Sort. O(n log n) time, O(log n) space.
 * 2. Heap. O(n log m) time, O(m) space.
 * 3. Quick Select. O(n) time, O(log n) space. Need to modify input array.
 */
public class Q06 {
    public static ArrayList<Integer> findNSmallestElements(ArrayList<Integer> nums, int n) {
        if (nums == null || n < 0) return null;
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        for (int num : nums) {
            if (maxheap.size() < n) {
                maxheap.offer(num);
            } else {
                if (num < maxheap.peek()) {
                    maxheap.poll();
                    maxheap.offer(num);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!maxheap.isEmpty() ) {
            result.add(maxheap.poll());
        }
        return result;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        final int N = 1000;
        for (int i = 0; i < N; ++i) nums.add(i);
        Collections.shuffle(nums);
        println(findNSmallestElements(nums, 50));
    }
}
