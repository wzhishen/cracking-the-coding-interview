package chap18;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Given a list of words, write a program to find the longest word
 * made of other words in the list.
 * Returns all possible occurrences.
 *
 * FOLLOW UP
 * What if each single word can only be used once to construct
 * other words?
 *
 * EXAMPLE
 * Input: "cat", "banana", "dog", "nana", "my", "walk", "walker",
 *        "baby", "dogwalkers", "s", "babymybaby"
 * Output: ["dogwalkers"]
 */
public class Q07_2 {
    public static ArrayList<String> findLongestWord(String[] words) {
        if (words == null) return null;
        sortWordsByLength(words);
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            int cnt = 0;
            if (map.containsKey(word)) cnt = map.get(word);
            map.put(word, ++cnt);
        }
        int maxLen = 0;
        for (String word : words) {
            if (isValidWord(word, true, map) && word.length() >= maxLen) {
                result.add(word);
                maxLen = word.length();
            }
        }
        return result;
    }

    private static void sortWordsByLength(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((Integer) o2.length()).compareTo(o1.length());
            }
        });
    }

    private static boolean isValidWord(String word, boolean isOriginal, HashMap<String, Integer> map) {
        if (!isOriginal && map.containsKey(word) && map.get(word) > 0) {
            map.put(word, map.get(word) - 1);
            return true;
        }
        for (int i = 1; i < word.length(); ++i) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (map.containsKey(left) && map.get(left) > 0) {
                map.put(left, map.get(left) - 1);
                if (isValidWord(right, false, map)) {
                    return true;
                }
                map.put(left, map.get(left) + 1);
            }
        }
        return false;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String[] a = {"cat", "banana", "dog", "nana", "my", "walk",
                      "walker", "baby", "dogwalkers", "s", "babymybaby"};
        println(findLongestWord(a));
        a = new String[] {"A", "A", "A", "B", "C", "ABC", "AAA", "BAA", "B"};
        println(findLongestWord(a));
    }
}
