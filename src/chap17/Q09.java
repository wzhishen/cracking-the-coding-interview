package chap17;

import java.util.HashMap;

public class Q09 {
//    Design a method to find the frequency of occurrences of any given word in a book.
    
    //assume case-insensitive
    HashMap<String, Integer> buildFrequencyMap(String[] book) {
        if (book == null) return null;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : book) {
            word = word.toLowerCase();
            int frequency = 0;
            if (map.containsKey(word)) {
                frequency = map.get(word);
            }
            map.put(word, ++frequency);
        }
        return map;
    }
    
    int getFrequency(String word, HashMap<String, Integer> map) {
        if (word == null || map == null) return -1;
        word = word.toLowerCase();
        if (!map.containsKey(word)) return 0;
        return map.get(word);
    }

}
