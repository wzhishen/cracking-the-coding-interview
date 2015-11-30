package chap18;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Given two words of equal length that are in a dictionary, write a
 * method to transform one word into another word by changing only
 * one letter at a time. The new word you get in each step must be
 * in the dictionary.
 *
 * EXAMPLE
 * Input: DAMP, LIKE
 * Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE
 */
public class Q10 {
    // BFS with a backtrack map
    public static ArrayList<String> transform(String start, String end, HashSet<String> dictionary) {
        LinkedList<String> queue = new LinkedList<String>();
        HashMap<String, String> backtrackMap = new HashMap<String, String>();
        HashSet<String> visited = new HashSet<String>();
        ArrayList<String> result = new ArrayList<String>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()) {
            String word = queue.remove();
            for (String newWord : transformOneLetter(word, dictionary)) {
                if (!visited.contains(newWord)) {
                    visited.add(newWord);
                    backtrackMap.put(newWord, word);
                    if (newWord.equals(end)) {
                        backtrack(start, newWord, backtrackMap, result);
                        break;
                    }
                    queue.add(newWord);
                }
            }
        }
        return result;
    }

    private static HashSet<String> transformOneLetter(String word, HashSet<String> dictionary) {
        HashSet<String> result = new HashSet<String>();
        for (int i = 0; i < word.length(); ++i) {
            StringBuilder sb = new StringBuilder(word);
            for (char letter = 'a'; letter <= 'z'; ++letter) {
                if (sb.charAt(i) != letter) {
                    sb.setCharAt(i, letter);
                    String newWord = sb.toString();
                    if (dictionary.contains(newWord)) {
                        result.add(newWord);
                    }
                }
            }
        }
        return result;
    }

    private static void backtrack(String start, String word, HashMap<String, String> backtrackMap, ArrayList<String> result) {
        result.add(word);
        while (backtrackMap.containsKey(word)) {
            if (word.equals(start)) break;
            word = backtrackMap.get(word);
            result.add(0, word);
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String[] words = {
            "damp", "lamp", "limp", "lime","line", "like", "wike"
        };
        HashSet<String> dictionary = new HashSet<String>(Arrays.asList(words));
        println(transform("damp", "like", dictionary));
    }
}
