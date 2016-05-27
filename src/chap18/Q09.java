package chap18;

import static helpers.Printer.*;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Numbers are randomly generated and passed to a method. Write a
 * program to find and maintain the median value as new values are
 * generated.
 *
 * SOLUTION
 * Use a max heap and a min heap to maintain the stream, where
 * maxheap.size() == minheap.size() or
 * maxheap.size() - 1 == minheap.size()
 * always holds.
 */
public class Q09 {
    private static final int N = 100;
    // a max heap that contains all SMALL elements
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(N, Collections.reverseOrder());
    // a min heap that contains all LARGE elements
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(N);

    // O(log n) time, O(n) space
    public static void track(int n) {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.isEmpty() || n < minHeap.peek()) {
                maxHeap.offer(n);
            } else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(n);
            }
        } else {
            if (n > maxHeap.peek()) {
                minHeap.offer(n);
            } else {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(n);
            }
        }
    }

    // O(1) time
    public static double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            track(i);
            println(getMedian());
        }
        for (int i = 100; i < 150; i += 5) {
            track(i);
            println(getMedian());
        }
    }
}
