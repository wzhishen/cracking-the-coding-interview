package chap18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Q07 {
//    Given a list of words, write a program to find the longest word made of other
//    words in the list.
//    EXAMPLE
//    Input: cat, banana, dog, nana, walk, walker, dogwalker
//    Output: dogwalker

    static String findLongestWord(String[] words) {
        if (words == null || words.length == 0) return null;
        HashSet<String> map = new HashSet<String>();
        for (String word : words) {
            map.add(word);
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((Integer) o2.length()).compareTo(o1.length());
            }
        });
        for (String word : words) {
            if (isValid(word, true, map)) {
                return word;
            }
        }
        return "";
    }
    
    private static boolean isValid(String word, boolean isOriginal, //XXX: check originality!
            HashSet<String> map) {
        if (!isOriginal && map.contains(word)) 
            return true;
        for (int i = 1; i < word.length(); ++i) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (isValid(left, false, map) && isValid(right, false, map))
                return true;
        }
        return false;
    }
    
    public static void main(String[]args) {
        String[]a= {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalkers", "s"};
        System.out.println(findLongestWord(a));
    }
}
