package chap11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Q2 {
//    Write a method to sort an array of strings so that all the anagrams are next to each
//    other.
    
    static void sortStrings(String[] strings) {
        HashMap<String, LinkedList<String>> cache = new HashMap<String, LinkedList<String>>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (cache.containsKey(key)) {
                cache.get(key).add(s);
            }
            else {
                LinkedList<String> list = new LinkedList<String>();
                list.add(s);
                cache.put(key, list);
            }
        }
        int i = 0;
        for (String key : cache.keySet()) {
             for (String val : cache.get(key)) {
                 strings[i++] = val;
             }
        }
    }
    
    //--------------------------------------
    public static void main(String[]args) {
        String[] strings = {"acb", "ijh", "abc", "iop", "cab", "pio", "hij"};
        sortStrings(strings);
        for(String s:strings)System.out.print(s+" ");
    }
}
