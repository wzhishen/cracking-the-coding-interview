package chap18;

import static helpers.Printer.*;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * You have a large text file containing words. Given any two words,
 * find the shortest distance (in terms of number of words) between
 * them in the file. If the operation will be repeated many times
 * for the same file (but different pairs of words), can you
 * optimize your solution?
 */
public class Q05 {
    public static int findShortextPath(String[] text, String word1, String word2) {
        if (text == null || word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) return -1;

        int p1 = -1, p2 = -1, minDistance = text.length;
        for (int i = 0; i < text.length; ++i) {
            if (text[i].equals(word1)) p1 = i;
            else if ((text[i].equals(word2))) p2 = i;
            if (p1 != -1 && p2 != -1) minDistance = Math.min(minDistance, Math.abs(p1 - p2));
        }
        return minDistance;
    }

    public static HashMap<String, ArrayList<Integer>> preprocess(String[] text) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < text.length; ++i) {
            String word = text[i];
            ArrayList<Integer> indexes = map.getOrDefault(word, new ArrayList<Integer>());
            indexes.add(i);
            map.put(word, indexes);
        }
        return map;
    }

    public static int findShortextPath2(String[] text, String word1, String word2) {
        if (text == null || word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) return -1;

        HashMap<String, ArrayList<Integer>> map = preprocess(text);

        int p1 = 0, p2 = 0, minDistance = text.length;
        ArrayList<Integer> list1 = map.get(word1), list2 = map.get(word2);
        if (list1 == null || list2 == null) return minDistance;
        while (p1 < list1.size() && p2 < list2.size()) {
            int index1 = list1.get(p1), index2 = list2.get(p2);
            minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            if (index1 < index2) ++p1;
            else ++p2;
        }
        return minDistance;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String book = "Java String array FAQ: Can you share some Java array examples," +
        " specifically some String array examples, as well as the Java 5 for loop syntax?";
        String[] text = book.split("\\s+");

        println(findShortextPath(text, "Java", "as"));
        println(findShortextPath(text, "FAQ:", "examples,"));
        println(findShortextPath2(text, "Java", "as"));
        println(findShortextPath2(text, "FAQ:", "examples,"));
    }
}
