package chap09;

import java.util.ArrayList;

public class Q05 {
//    Write a method to compute all permutations of a string.
    
//    SOLUTION: We solve for f ( n - 1 ), and then push a(n)
//    into every spot in each of these strings.
    
    static ArrayList<String> getPermutations(String s) {
        if (s == null) return null;
        ArrayList<String> strings = new ArrayList<String>();
        if (s.isEmpty()) { //XXX: even no need to have s.length()==1 base case
            strings.add(s);
            return strings;
        }
        ArrayList<String> last = getPermutations(s.substring(1));
        for (String oldString : last) {
            for (int i = 0; i <= oldString.length(); ++i) {
                strings.add(
                        oldString.substring(0, i) + 
                        s.charAt(0) + 
                        oldString.substring(i)
                        );
            }
        }
        return strings;
    }
    
    //------------------------------------------
    public static void main(String[]args) {
        ArrayList<String>l=getPermutations("abcde");
        for (String s:l) {
            System.out.println(s);
        }
        System.out.println("Total: "+l.size());
    }

}
