package chap03;

import static helpers.Printer.*;

import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Q5 {
    private static final int LOAD_FACTOR = 10;
    private Stack<Integer> head = new Stack<Integer>();
    private Stack<Integer> tail = new Stack<Integer>();

    public void enqueue(int item) {
        rebalance();
        tail.push(item);
    }

    public int dequeue() {
        rebalance();
        if (head.isEmpty())
            throw new IllegalStateException("Queue is empty!");
        return head.pop();
    }

    public int peekHead() {
        if (head.isEmpty())
            throw new IllegalStateException("Queue is empty!");
        return head.peek();
    }

    public int peekTail() {
        if (head.isEmpty())
            throw new IllegalStateException("Queue is empty!");
        return tail.peek();
    }

    public int size() {
        return head.size() + tail.size();
    }

    public void rebalance() {
        if (tail.size() >= LOAD_FACTOR &&
                tail.size() >= 2 * head.size() ||
                head.isEmpty()) {
            while (!tail.isEmpty() ) {
                head.push(tail.pop());
            }
        }
    }

    public void printQueue() {
        printQueue(true);
    }

    public void printQueue(boolean showBoundary) {
        print("[HEAD] ");
        for (int i = head.size() - 1; i >= 0; --i)
            print(head.get(i) + " ");
        if (showBoundary)
            print("| ");
        for (int item : tail)
            print(item + " ");
        println("[TAIL]");
        println();
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Q5 myQueue = new Q5();
        myQueue.printQueue();
        for (int i = 1; i <= 6; ++i) {
            println("Enqueue " + i);
            myQueue.enqueue(i);
        }
        myQueue.printQueue();
        for (int i = 1; i <= 3; ++i) {
            int item = myQueue.dequeue();
            println("Dequeue " + item);
        }
        myQueue.printQueue();
        for (int i = 1; i <= 3; ++i) {
            println("Enqueue " + i);
            myQueue.enqueue(i);
        }
        myQueue.printQueue();
    }
}
