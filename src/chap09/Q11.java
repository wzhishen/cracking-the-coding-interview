package chap09;

import java.util.HashMap;

public class Q11 {
//    Given a boolean expression consisting of the symbols 0,1, &, /, and ^, and a desired
//    boolean result value result, implement a function to count the number of ways of
//    parenthesizing the expression such that it evaluates to result.
    
//    SOLUTION: iterate through all operators, dividing the expression into left/right subexpressions;
//    evaluate left/right subexpressions recursively, according to &, |, ^ rules.
    
    static int count(String exp, boolean res, int s, int e) {
        if (s == e) { //base case
            if (exp.charAt(s) == '1' && res)
                return 1;
            if (exp.charAt(s) == '0' && !res)
                return 1;
            return 0;
        }
        int cnt = 0;
        if (res) {
            for (int i = s+1; i <= e; i+=2) {// i is index of an operator
                if (exp.charAt(i) == '&') {// & rule, evaluating to true
                    cnt += count(exp, true, s, i-1) * count(exp, true, i+1, e);
                }
                else if (exp.charAt(i) == '|') {// | rule, evaluating to true
                    cnt += count(exp, true, s, i-1) * count(exp, true, i+1, e) +
                            count(exp, true, s, i-1) * count(exp, false, i+1, e) +
                            count(exp, false, s, i-1) * count(exp, true, i+1, e);
                }
                else if (exp.charAt(i) == '^') {// ^ rule, evaluating to true
                    cnt += count(exp, true, s, i-1) * count(exp, false, i+1, e) +
                            count(exp, false, s, i-1) * count(exp, true, i+1, e);
                }
            }
        }
        else {
            for (int i = s+1; i <= e; i+=2) {// i is index of an operator
                if (exp.charAt(i) == '&') {// & rule, evaluating to false
                    cnt += count(exp, false, s, i-1) * count(exp, false, i+1, e) +
                            count(exp, true, s, i-1) * count(exp, false, i+1, e) +
                            count(exp, false, s, i-1) * count(exp, true, i+1, e);
                }
                else if (exp.charAt(i) == '|') {// | rule, evaluating to false
                    cnt += count(exp, false, s, i-1) * count(exp, false, i+1, e);
                }
                else if (exp.charAt(i) == '^') {// ^ rule, evaluating to false
                    cnt += count(exp, true, s, i-1) * count(exp, true, i+1, e) +
                            count(exp, false, s, i-1) * count(exp, false, i+1, e);
                }
            }
        }
        return cnt;
    }
    
    static int count(String exp, boolean res) {
        return count(exp, res, 0, exp.length()-1);
    }
    
    static int countDP(String exp, boolean res, int s, int e, HashMap<String, Integer> cache) {
        String key = "" + res + s + e;
        if (cache.containsKey(key))
            return cache.get(key);
        
        if (s == e) { //base case
            if (exp.charAt(s) == '1' && res)
                return 1;
            if (exp.charAt(s) == '0' && !res)
                return 1;
            return 0;
        }
        int cnt = 0;
        if (res) {
            for (int i = s+1; i <= e; i+=2) {// i is index of an operator
                if (exp.charAt(i) == '&') {
                    cnt += count(exp, true, s, i-1) * count(exp, true, i+1, e);
                }
                else if (exp.charAt(i) == '|') {
                    cnt += count(exp, true, s, i-1) * count(exp, true, i+1, e) +
                            count(exp, true, s, i-1) * count(exp, false, i+1, e) +
                            count(exp, false, s, i-1) * count(exp, true, i+1, e);
                }
                else if (exp.charAt(i) == '^') {
                    cnt += count(exp, true, s, i-1) * count(exp, false, i+1, e) +
                            count(exp, false, s, i-1) * count(exp, true, i+1, e);
                }
            }
        }
        else {
            for (int i = s+1; i <= e; i+=2) {// i is index of an operator
                if (exp.charAt(i) == '&') {
                    cnt += count(exp, false, s, i-1) * count(exp, false, i+1, e) +
                            count(exp, true, s, i-1) * count(exp, false, i+1, e) +
                            count(exp, false, s, i-1) * count(exp, true, i+1, e);
                }
                else if (exp.charAt(i) == '|') {
                    cnt += count(exp, false, s, i-1) * count(exp, false, i+1, e);
                }
                else if (exp.charAt(i) == '^') {
                    cnt += count(exp, true, s, i-1) * count(exp, true, i+1, e) +
                            count(exp, false, s, i-1) * count(exp, false, i+1, e);
                }
            }
        }
        cache.put(key, cnt);
        return cnt;
    }
    
    static int countDP(String exp, boolean res, HashMap<String, Integer> cache) {
        return countDP(exp, res, 0, exp.length()-1, cache);
    }
    
    //------------------------------------
    public static void main(String[]args) {
        System.out.println(count("1^0&1|0&1^0&1|0^1|1|0&0",true));
        System.out.println(countDP("1^0&1|0&1^0&1|0^1|1|0&0",true,new HashMap<String, Integer>()));
    }
}
