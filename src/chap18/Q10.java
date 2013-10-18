package chap18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Q10 {
//    Given two words of equal length that are in a dictionary, write a method to
//    transform one word into another word by changing only one letter at a time.
//    The new word you get in each step must be in the dictionary.
//    EXAMPLE
//    Input: DAMP, LIKE
//    Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE
    
    //BFS, and use a backtrack map
    static LinkedList<String> getStepsTransformation(String start, String end) {
        if (start == null || end == null) return null;
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        HashMap<String, String> backtrackMap = new HashMap<String, String>();//XXX
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String word = queue.removeFirst();
            for (String newWord : transform(word)) {
                if (!visited.contains(newWord)) {
                    visited.add(newWord);
                    backtrackMap.put(newWord, word);//newWord 'links to' prev word
                    if (newWord.equals(end)) {
                        LinkedList<String> ret = new LinkedList<String>();
                        String n = newWord;
                        ret.add(n);
                        while (backtrackMap.containsKey(n)) {
                            n = backtrackMap.get(n);
                            ret.add(0, n);
                        }
                        return ret;
                    }
                    else {
                        queue.add(newWord);
                    }
                }
            }
        }
        return null;
    }
    
    private static HashSet<String> transform(String s) {
        HashSet<String> ret = new HashSet<String>();
        for (int i = 0; i < s.length(); ++i) {
            StringBuffer sb = new StringBuffer(s);
            for (char ch = 'A'; ch <= 'Z'; ++ch) {
                if (sb.charAt(i) != ch) {
                    sb.setCharAt(i, ch);
                    if (containsDictWord(sb.toString())) {
                        ret.add(sb.toString());
                    }
                }
            }
        }
        return ret;
    }
    
    private static boolean containsDictWord(String s) {
        HashSet<String> dict = new HashSet<String>();
        dict.add("DAMP");dict.add("LAMP");dict.add("LIMP");dict.add("LIME");dict.add("LIKE");
        return dict.contains(s);
    }
    
    //-----------------------------------------------
    public static void main(String[]args) {
        System.out.println(getStepsTransformation("DAMP", "LIKE"));
    }

}
