package chap18;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import helpers.Trie;
import helpers.Trie.TrieNode;

/**
 * Given a list of millions of words, design an algorithm to create
 * the largest possible rectangle of letters such that every row
 * forms a word (reading left to right) and every column forms a
 * word (reading top to bottom). The words need not be chosen
 * consecutively from the list, but all rows must be the same
 * length and all columns must be the same height.
 */
public class Q13 {
    public static Rectangle buildLargestRectangle(String[] words) {
        sortWordsByLength(words);
        int maxWordLength = words[0].length();
        int maxSize = maxWordLength * maxWordLength;
        ArrayList<String>[] wordGroups = createWordGroups(words);
        TrieNode[] trieGroups = new TrieNode[maxWordLength + 1];
        for (int size = maxSize; size > 0; --size) {
            for (int length = maxWordLength; length > 0; --length) {
                if (size % length == 0) {
                    int width = size / length;
                    if (width <= maxWordLength) {
                        createTrieGroups(wordGroups, trieGroups, width);
                        Rectangle result = buildRectangle(wordGroups, trieGroups, length, width);
                        if (result != null) return result;
                    }
                }
            }
        }
        return null;
    }

    private static void createTrieGroups(ArrayList<String>[] wordGroups, TrieNode[] trieGroups, int width) {
        ArrayList<String> wordsByWidth = wordGroups[width];
        if (wordsByWidth != null) {
            TrieNode root = new TrieNode();
            trieGroups[width] = root;
            for (String word : wordsByWidth) {
                Trie.addWord(root, word);
            }
        }
    }

    private static Rectangle buildRectangle(ArrayList<String>[] wordGroups, TrieNode[] trieGroups, int length, int width) {
        ArrayList<String> cadidateWords = wordGroups[length];
        TrieNode trie = trieGroups[width];
        if (cadidateWords == null || trie == null) return null;
        return buildRectangleByRow(cadidateWords, trie, new Rectangle(length, width), 0);
    }

    private static Rectangle buildRectangleByRow(ArrayList<String> cadidateWords, TrieNode trie, Rectangle rectangle, int runningWidth) {
        if (runningWidth == rectangle.getWidth()) {
            if (isCompleteRectangle(trie, rectangle)) {
                return rectangle;
            } else {
                return null;
            }
        }
        if (!isPartialRectangle(trie, rectangle)) {
            return null;
        }
        for (String word : cadidateWords) {
            rectangle.append(word);
            Rectangle result = buildRectangleByRow(cadidateWords, trie, rectangle, runningWidth + 1);
            if (result != null) return result;
            rectangle.remove(); // restore state
        }
        return null;
    }

    private static boolean isCompleteRectangle(TrieNode trie, Rectangle rectangle) {
        return isValid(trie, rectangle, true);
    }

    private static boolean isPartialRectangle(TrieNode trie, Rectangle rectangle) {
        return isValid(trie, rectangle, false);
    }

    private static boolean isValid(TrieNode trie, Rectangle rectangle, boolean checkHasWord) {
        int length = rectangle.getLength();
        if (trie == null) return false;
        for (int i = 0; i < length; ++i) {
            String columnWord = rectangle.getWordByCol(i);
            if (checkHasWord) {
                if (!Trie.hasWord(trie, columnWord)) return false;
            } else {
                if (!Trie.hasPrefix(trie, columnWord)) return false;
            }
        }
        return true;
    }

    private static ArrayList<String>[] createWordGroups(String[] words) {
        int wordLength = words[0].length();
        ArrayList<String>[] wordGroups = new ArrayList[wordLength + 1];
        ArrayList<String> wordGroup = new ArrayList<String>();
        for (String word : words) {
            if (word.length() != wordLength) {
                wordGroups[wordLength] = new ArrayList<String>(wordGroup);
                wordGroup.clear();
                wordLength = word.length();
            }
            wordGroup.add(word);
        }
        if (!wordGroup.isEmpty()) {
            wordGroups[wordLength] = new ArrayList<String>(wordGroup);
        }
        return wordGroups;
    }

    private static void sortWordsByLength(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((Integer) o2.length()).compareTo(o1.length());
            }
        });
    }

    public static class Rectangle {
        private ArrayList<String> matrix;
        private int length, width;
        public Rectangle(int l, int w) {
            matrix = new ArrayList<String>();
            length = l;
            width = w;
        }
        public void append(String word) {
            if (word != null) matrix.add(word);
        }
        public void remove() {
            matrix.remove(matrix.size() - 1);
        }
        public int getLength() {
            return length;
        }
        public int getWidth() {
            return width;
        }
        public String getWordByRow(int row) {
            return matrix.get(row);
        }
        public String getWordByCol(int col) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matrix.size(); ++i) {
                sb.append(matrix.get(i).charAt(col));
            }
            return sb.toString();
        }
        public void print() {
            for (String row : matrix) {
                println(row);
            }
            println();
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String[] words = {
                "A", "AA", "CD", "AC", "AD", "ABC", "AQE", "BWF", "CED",
                "CEG", "DRH", "QWE", "ABCD","QWER","EFGH","UIOP","AQEU",
                "OPKI", "BWFI", "CEGO", "DRHP", "SDFE", "ECDV", "RFGN"
        };
        Rectangle rectangle = buildLargestRectangle(words);
        if (rectangle != null) rectangle.print();
        else println("No solution!");
    }
}
