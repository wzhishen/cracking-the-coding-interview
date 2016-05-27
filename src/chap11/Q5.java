package chap11;

import static helpers.Printer.*;

/**
 * Given a sorted array of strings which is interspersed with
 * empty strings, write a method to find the location of a
 * given string.
 */
public class Q5 {
    public static int search(String[] strings, String s) {
        if (strings == null || s == null) return -1;
        return search(strings, s, 0, strings.length - 1);
    }

    // worst case is O(n) time, no better than a linear scan
    private static int search(String[] strings, String s, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (strings[mid].isEmpty()) {
            int left = mid - 1, right = mid + 1;
            // If strings[mid] is empty, find closest non-empty string.
            while (true) {
                if (left < low && right > high)
                    return -1;
                if (left >= low && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                if (right <= high && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                }
                --left;
                ++right;
            }
        }
        if (strings[mid].equals(s))
            return mid;
        else if (strings[mid].compareTo(s) < 0)
            return search(strings, s, mid + 1, high);
        else
            return search(strings, s, low, mid - 1);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String[] strings = {"","","a","","","","b"};
        println(search(strings, "a"));
    }
}
