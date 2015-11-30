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
        if (text == null || word1 == null || word2 == null ||
            word1.isEmpty() || word2.isEmpty())
            return -1;
        int lastPos1 = -1, lastPos2 = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < text.length; ++i) {
            if (text[i].equals(word1)) {
                lastPos1 = i;
                if (lastPos2 != -1) {
                    minDistance = Math.min(minDistance, lastPos1 - lastPos2);
                }
            } else {
                if (text[i].equals(word2)) {
                    lastPos2 = i;
                    if (lastPos1 != -1) {
                        minDistance = Math.min(minDistance, lastPos2 - lastPos1);
                    }
                }
            }
        }
        return minDistance;
    }

    public static HashMap<String, ArrayList<Integer>> preprocess(String[] text) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        if (text == null) return map;
        for (int i = 0; i < text.length; ++i) {
            String word = text[i];
            ArrayList<Integer> indexes = new ArrayList<Integer>();
            if (map.containsKey(word)) {
                indexes = map.get(word);
            }
            indexes.add(i);
            map.put(word, indexes);
        }
        return map;
    }

    public static int findShortextPath2(HashMap<String, ArrayList<Integer>> map, String word1, String word2) {
        if (map == null || word1 == null || word2 == null ||
            word1.isEmpty() || word2.isEmpty())
            return -1;
        ArrayList<Integer> list1 = map.get(word1), list2 = map.get(word2);
        int minDistance = Integer.MAX_VALUE;
        if (list1 == null || list2 == null) return minDistance;
        // Merge result lists
        ArrayList<Position> list = new ArrayList<Position>();
        int p1 = 0, p2 = 0;
        while (p1 < list1.size() && p2 < list2.size()) {
            int pos1 = list1.get(p1);
            int pos2 = list2.get(p2);
            if (pos1 < pos2) {
                list.add(new Position(1, pos1));
                ++p1;
            } else {
                list.add(new Position(2, pos2));
                ++p2;
            }
        }
        while (p1 < list1.size()) {
            list.add(new Position(1, list1.get(p1)));
            ++p1;
        }
        while (p2 < list2.size()) {
            list.add(new Position(2, list2.get(p2)));
            ++p2;
        }
        // Calculate shortest distance
        for (int i = 0; i < list.size() - 1; ++i) {
            Position curr = list.get(i);
            Position next = list.get(i + 1);
            if (curr.listNum != next.listNum) {
                int distance = next.pos - curr.pos;
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }

    private static class Position {
        int listNum;
        int pos;
        public Position(int l, int p) {
            listNum = l;
            pos = p;
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String book = "Java String array FAQ: Can you share some Java array examples," +
        " specifically some String array examples, as well as the Java 5 for loop syntax?";
        String[] text = book.split("\\s+");
        HashMap<String, ArrayList<Integer>> map = preprocess(text);

        println(findShortextPath(text, "Java", "as"));
        println(findShortextPath(text, "FAQ:", "examples,"));
        println(findShortextPath2(map, "Java", "as"));
        println(findShortextPath2(map, "FAQ:", "examples,"));
    }
}
