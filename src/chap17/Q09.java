package chap17;

import static helpers.Printer.*;

import java.util.HashMap;

/**
 * Design a method to find the frequency of occurrences of any
 * given word in a book.
 */
public class Q09 {
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();

    // assume words are case-insensitive
    public static HashMap<String, Integer> buildFrequencyMap(String book) {
        if (book == null) return null;
        String[] words = book.split("\\s+");

        for (String word : words) {
            if (word == null) continue;
            word = word.toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    public static int getFrequency(String word) {
        if (word == null || word.trim().isEmpty()) return -1;
        return map.getOrDefault(word.toLowerCase(), 0);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String book = "Java String array FAQ: Can you share some Java array examples," +
        " specifically some String array examples, as well as the Java 5 for loop syntax?";
        buildFrequencyMap(book);
        println(getFrequency(" "));
        println(getFrequency("python"));
        println(getFrequency("java"));
    }
}
