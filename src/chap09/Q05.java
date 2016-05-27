package chap09;

import static helpers.Printer.*;

import java.util.ArrayList;

/**
 * Write a method to compute all permutations of a string.
 */
public class Q05 {
    /*
     * Naive recursion:
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

    /*
     * Better recursion: backtracking
     */
    public static ArrayList<String> getPermutations2(String s) {
        if (s == null) return null;
        ArrayList<String> result = new  ArrayList<String>();
        permute(result, "", s.toCharArray());
        return result;
    }

    private static void permute(ArrayList<String> result, String curr, char[] s) {
        if (curr.length() == s.length) {
            result.add(curr);
        } else {
            for (int i = 0; i < s.length; ++i) {
                if (s[i] == '\0') continue;
                char ch = s[i];
                s[i] = '\0';
                permute(result, curr + ch, s);
                s[i] = ch;
            }
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(getPermutations("ab12"));
        println(getPermutations2("ab12"));
    }
}
