package chap18;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q09 {
//    Numbers are randomly generated and passed to a method. Write a program to
//    find and maintain the median value as new values are generated.
//    
//    SOLUTION:
//    Use a max heap, a min heap, 
//    where maxheap.size() == minheap.size() or
//          maxheap.size()-1 == minheap.size() always holds.
    
    //maxheap contains all SMALL elements
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(50, Collections.reverseOrder());
    //minheap contains all LARGE elements
    static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(50);
    
    static void addNum(int n) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(n);
        }
        if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.offer(n);
            }
            else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(n);
            }
        }
        else {
            if (n > maxHeap.peek()) {
                minHeap.offer(n);
            }
            else {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(n);
            }
        }
    }
    
    static int getMedian() {
        if (maxHeap.isEmpty()) return 0;
        else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
        else {
            return maxHeap.peek();
        }
    }
    
    //-------------------------------------
    public static void main(String[]args) {
        addNum(3);addNum(2);addNum(4);addNum(5);addNum(1);
        System.out.println(getMedian());
    }

}
