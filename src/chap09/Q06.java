package chap09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q06 {
//    Implement an algorithm to print all valid (e.g., properly opened and closed)
//    combinations of n-pairs of parentheses.
//    EXAMPLE
//    Input: 3
//    Output: ((())), (()()), (())(), ()(()), ()()()

    //solution 1
    static Set<String> generateParens(int n) {
        if (n < 0) return null;
        Set<String> ret = new HashSet<String>();
        if (n == 0) {
            ret.add("");
        }
        else {//XXX: caution: concurrent modification exception
            Set<String> last = generateParens(n - 1);
            for (String parens : last) {
                ret.add("()" + parens);// insert "()" to front
                for (int i = 0; i < parens.length(); ++i) {// insert "()" after each '('
                    if (parens.charAt(i) == '(') {
                        ret.add(parens.substring(0, i + 1) +
                                "()" +
                                parens.substring(i + 1));
                    }
                }
            }
        }
        return ret;
    }
    
    //solution 2
    static void generateParens(List<String> parens, int leftParenNum, int rightParenNum, 
            char[] string, int index) {
        if (leftParenNum < 0 || rightParenNum < 0) return;
        if (leftParenNum == 0 && rightParenNum == 0) {
            //do not attempt to use StringBuffer instead of char[]
            parens.add(new String(string));
            return;
        }
        if (leftParenNum > 0) {
            string[index] = '(';
            generateParens(parens, leftParenNum - 1, rightParenNum, string, index + 1);
        }
        if (rightParenNum > leftParenNum) {
            string[index] = ')';
            generateParens(parens, leftParenNum, rightParenNum - 1, string, index + 1);
        }
    }
    
    static List<String> generateParens2(int n) {
        List<String> ret = new ArrayList<String>();
        generateParens(ret, n, n, new char[n * 2], 0);
        return ret;
    }
    
    public static void main(String[]args) {
        System.out.println(generateParens(7));
        System.out.println(generateParens2(7));
//        Set s = new HashSet(generateParens2(4));
//        s.removeAll(generateParens(4));
//        System.out.println(s);
    }

}
