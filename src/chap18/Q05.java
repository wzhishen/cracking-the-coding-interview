package chap18;

import java.util.HashMap;
import java.util.LinkedList;

public class Q05 {
//    You have a large text file containing words. Given any two words, find the shortest
//    distance (in terms of number of words) between them in the file. If the operation
//    will be repeated many times for the same file (but different pairs of words), can you
//    optimize your solution?
    
    int findShortestPath(String[] text, String word1, String word2) {
        int lastPosWord1 = -1;
        int lastPosWord2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < text.length; ++i) {
            if (text[i] == word1) {
                lastPosWord1 = i;
            }
            else if (text[i] == word2) {
                lastPosWord2 = i;
            }
            int distance = Math.abs(lastPosWord1 - lastPosWord2);
            if (lastPosWord1 != -1 &&
                    lastPosWord2 != -1 &&
                    distance < min) {
                min = distance;
            }
        }
        return min;
    }
    
    //if repeated operations needed
    HashMap<String, LinkedList<Integer>> buildMap (String[] text) {//word -> list of positions
        HashMap<String, LinkedList<Integer>> map = new HashMap<String, LinkedList<Integer>>();
        for (int i = 0; i < text.length; ++i) {
            if (map.containsKey(text[i])) {
                map.get(text[i]).add(i);
            }
            else {
                LinkedList<Integer> pos = new LinkedList<Integer>();
                pos.add(i);
                map.put(text[i], pos);
            }
        }
        return map;
    }

}
