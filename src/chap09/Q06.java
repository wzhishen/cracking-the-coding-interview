package chap09;

import static helpers.Printer.println;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Implement an algorithm to print all valid (e.g., properly
 * opened and closed) combinations of n-pairs of parentheses.
 *
 * EXAMPLE
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class Q06 {
    public static HashSet<String> getParens(int n) {
        if (n < 0) return null;
        HashSet<String> result = new HashSet<String>();
        if (n == 0) {
            result.add("");
            return result;
        }
        HashSet<String> lastParens = getParens(n - 1);
        for (String parens : lastParens) {
            for (int i = 0; i <= parens.length(); ++i) {
                result.add(parens.substring(0, i) +
                           "()" +
                           parens.substring(i));
            }
        }
        return result;
    }

    public static ArrayList<String> getParens2(int n) {
        if (n < 0) return null;
        ArrayList<String> result = new ArrayList<String>();
        addParens(n, n, new char[n * 2], 0, result);
        return result;
    }

    private static void addParens(int leftNum, int rightNum, char[] chars, int i, ArrayList<String> parens) {
        if (leftNum == 0 && rightNum == 0) {
            parens.add(new String(chars));
        }
        if (leftNum > 0) {
            chars[i] = '(';
            addParens(leftNum - 1, rightNum, chars, i + 1, parens);
        }
        if (rightNum > leftNum) {
            chars[i] = ')';
            addParens(leftNum, rightNum - 1, chars, i + 1, parens);
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(getParens(4));
        println(getParens2(4));
    }
}
