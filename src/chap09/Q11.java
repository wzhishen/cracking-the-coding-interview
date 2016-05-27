package chap09;

import static helpers.Printer.*;

import java.util.HashMap;

/**
 * Given a boolean expression consisting of the symbols (0, 1, &,
 * /, and ^) and a desired boolean result value result, implement
 * a function to count the number of ways of parenthesizing the
 * expression such that it evaluates to result.
 */
public class Q11 {
    /*
     * SOLUTION
     * Iterate through all operators, dividing the expression into
     * left/right subexpressions. Evaluate left/right subexpressions
     * recursively, according to &, |, ^ rules.
     */
    public static int count(String exp, boolean res) {
        return countDP(exp, res, 0, exp.length() - 1, new HashMap<String, Integer>());
    }

    private static int countDP(String expression, boolean result, int start, int end, HashMap<String, Integer> cache) {
        String key = "" + result + start + end;
        if (cache.containsKey(key)) return cache.get(key);
        // Base case: single value evaluation
        if (start == end) {
            char operand = expression.charAt(start);
            if (result) {
                if (operand == '1') return 1;
                else if (operand == '0') return 0;
                else throw new IllegalArgumentException("Invalid operand!");
            } else {
                if (operand == '0') return 1;
                else if (operand == '1') return 0;
                else throw new IllegalArgumentException("Invalid operand!");
            }
        }
        // Recursive case: subexpression evaluation
        int cnt = 0;
        if (result) {
            for (int i = start + 1; i < end; i += 2) {
                char operator = expression.charAt(i);
                if (operator == '&') {
                    cnt += countDP(expression, true, start, i - 1, cache) * countDP(expression, true, i + 1, end, cache);
                } else if (operator == '|') {
                    cnt += countDP(expression, true, start, i - 1, cache) * countDP(expression, false, i + 1, end, cache);
                    cnt += countDP(expression, false, start, i - 1, cache) * countDP(expression, true, i + 1, end, cache);
                    cnt += countDP(expression, true, start, i - 1, cache) * countDP(expression, true, i + 1, end, cache);
                } else if (operator == '^') {
                    cnt += countDP(expression, true, start, i - 1, cache) * countDP(expression, false, i + 1, end, cache);
                    cnt += countDP(expression, false, start, i - 1, cache) * countDP(expression, true, i + 1, end, cache);
                } else {
                    throw new IllegalArgumentException("Invalid operator!");
                }
            }
        } else {
            for (int i = start + 1; i < end; i += 2) {
                char operator = expression.charAt(i);
                if (operator == '&') {
                    cnt += countDP(expression, false, start, i - 1, cache) * countDP(expression, false, i + 1, end, cache);
                    cnt += countDP(expression, false, start, i - 1, cache) * countDP(expression, true, i + 1, end, cache);
                    cnt += countDP(expression, true, start, i - 1, cache) * countDP(expression, false, i + 1, end, cache);
                } else if (operator == '|') {
                    cnt += countDP(expression, false, start, i - 1, cache) * countDP(expression, false, i + 1, end, cache);
                } else if (operator == '^') {
                    cnt += countDP(expression, true, start, i - 1, cache) * countDP(expression, true, i + 1, end, cache);
                    cnt += countDP(expression, false, start, i - 1, cache) * countDP(expression, false, i + 1, end, cache);
                } else {
                    throw new IllegalArgumentException("Invalid operator!");
                }
            }
        }
        cache.put(key, cnt);
        return cnt;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(count("1^0|1",true));
        println(count("1^0&1|0&1^0&1|0^1|1|0&0",true));
    }
}
