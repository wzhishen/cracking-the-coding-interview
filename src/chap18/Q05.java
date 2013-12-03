package chap18;

import java.util.HashMap;
import java.util.ArrayList;

public class Q05 {
//    You have a large text file containing words. Given any two words, find the shortest
//    distance (in terms of number of words) between them in the file. If the operation
//    will be repeated many times for the same file (but different pairs of words), can you
//    optimize your solution?
    
    int findShortestPath(String[] text, String word1, String word2) {
        if (text == null || word1 == null || word2 == null) return -1;
        int lastPosWord1 = -1;
        int lastPosWord2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < text.length; ++i) {
            if (text[i].equals(word1)) {
                lastPosWord1 = i;
            }
            else if (text[i].equals(word2)) {
                lastPosWord2 = i;
            }
            if (lastPosWord1 != -1 && lastPosWord2 != -1) {
                int distance = Math.abs(lastPosWord1 - lastPosWord2);
                if (distance < min) {
                    min = distance;
                }
            }
        }
        return min;
    }
    
    /* if repeated operations needed */
    
    HashMap<String, ArrayList<Integer>> buildMap (String[] text) {//word -> list of positions
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < text.length; ++i) {
            if (map.containsKey(text[i])) {
                map.get(text[i]).add(i);
            }
            else {
                ArrayList<Integer> pos = new ArrayList<Integer>();
                pos.add(i);
                map.put(text[i], pos);
            }
        }
        return map;
    }
    
    int findShortestPath(HashMap<String, ArrayList<Integer>> map, String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        if (!map.containsKey(word1) || !map.containsKey(word2)) return -1;
        
        // merge result lists
        ArrayList<Position> res = new ArrayList<Position>();
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);
        int h1 = 0;
        int h2 = 0;
        while (h1 < l1.size() && h2 < l2.size()) {
            if (l1.get(h1) < l2.get(h2)) {
                res.add(new Position(1, l1.get(h1)));
                ++h1;
            }
            else {
                res.add(new Position(2, l2.get(h2)));
                ++h2;
            }
        }
        if (h1 < l1.size()) {
            for (int i = h1; i < l1.size(); ++i ) {
                res.add(new Position(1, l1.get(h1)));
            }
        }
        else if (h2 < l2.size()) {
            for (int i = h2; i < l2.size(); ++i ) {
                res.add(new Position(2, l2.get(h2)));
            }
        }
        
        // calculate shortest distance
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < res.size() - 1; ++i) {
            if (res.get(i).listNum != res.get(i+1).listNum) {
                int distance = Math.abs(res.get(i).pos - res.get(i+1).pos);
                if (distance < minDistance) minDistance = distance;
            }
        }
        return minDistance;
    }
    
    class Position {
        int listNum;
        int pos;
        public Position(int l, int p) {
            listNum = l;
            pos = p;
        }
    }

}
