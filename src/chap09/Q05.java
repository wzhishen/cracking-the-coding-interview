package chap09;

import static helpers.Printer.*;

import java.util.ArrayList;

/**
 * Write a method to compute all permutations of a string.
 */
public class Q05 {
    /*
     * Solve for f(n - 1), and then push a(n) into every spot
     * in each of these strings.
     * O(n!) time.
     */
    public static ArrayList<String> getPermutations(String s) {
        if (s == null) return null;
        ArrayList<String> result = new  ArrayList<String>();
        // Even no need to have s.length()==1 base case
        if (s.isEmpty()) {
            result.add(s);
            return result;
        }
        ArrayList<String> lastStrings = getPermutations(s.substring(1));
        for (String lastString : lastStrings) {
            for (int i = 0; i <= lastString.length(); ++i) {
                result.add(lastString.substring(0, i) +
                           s.charAt(0) +
                           lastString.substring(i));
            }
        }
        return result;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        ArrayList<String> permutations = getPermutations("ab12");
        println(permutations);
    }
}
