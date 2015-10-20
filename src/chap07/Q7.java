package chap07;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Design an algorithm to find the kth number such that the only
 * prime factors are 3, 5, and 7.
 */
public class Q7 {
    public static int findKthNum(int k) {
        if (k <= 0) return -1;
        int num = 1;
        ArrayList<Integer> q = new ArrayList<Integer>();
        q.add(num);
        for (int i = 0; i < k; ++i) {
            num = removeMin(q);
            q.add(3 * num);
            q.add(5 * num);
            q.add(7 * num);
        }
        return num;
    }

    private static int removeMin(ArrayList<Integer> q) {
        Integer min = Integer.MAX_VALUE;
        for (int n : q) {
            if (n < min) min = n;
        }
        while (q.contains(min)) {
            q.remove(min);
        }
        return min;
    }

    public static int findKthNum2(int k) {
        if (k <= 0) return -1;
        int num = 1;
        LinkedList<Integer> q3 = new LinkedList<Integer>();
        LinkedList<Integer> q5 = new LinkedList<Integer>();
        LinkedList<Integer> q7 = new LinkedList<Integer>();
        q3.add(num);
        for (int i = 0; i < k; ++i) {
            int n3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
            int n5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();
            int n7 = q7.isEmpty() ? Integer.MAX_VALUE : q7.peek();
            num = Math.min(n3, Math.min(n5, n7));
            if (num == n3) {
                q3.removeFirst();
                q3.add(3 * num);
                q5.add(5 * num);
                q7.add(7 * num);
            } else if (num == n5) {
                q5.removeFirst();
                q5.add(5 * num);
                q7.add(7 * num);
            } else if (num == n7) {
                q7.removeFirst();
                q7.add(7 * num);
            }
        }
        return num;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        for (int i = 1; i <= 20; ++i) {
            println(findKthNum(i) + " " + findKthNum2(i));
        }
    }
}
