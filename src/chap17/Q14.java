package chap17;

import static helpers.Printer.*;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Oh, no! You have just completed a lengthy document when you have
 * an unfortunate Find/Replace mishap. You have accidentally removed
 * all spaces, punctuation, and capitalization in the document. A
 * sentence like "I reset the computer. It still didn't boot!" would
 * become "iresetthecomputeritstilldidntboot". You figure that you
 * can add back in the punctuation and capitalization later, once you
 * get the individual words properly separated. Most of the words will
 * be in a dictionary but some strings, like proper names, will not.
 *
 * Given a dictionary (a list of words), design an algorithm to find
 * the optimal way of "unconcatenating" a sequence of words. In this
 * case, "optimal" is defined to be the parsing which minimizes the
 * number of unrecognized sequences of characters. 
 *
 * For example, the string "jesslookedjustliketimherbrother" would be
 * optimally parsed as "JESS looked just like TIM her brother". This
 * parsing has seven unrecognized characters, which we have capitalized
 * for clarity.
 */
public class Q14 {
    public static int parse(String sentence, HashSet<String> dictionary) {
        if (sentence == null || sentence.isEmpty()) return 0;
        int len = sentence.length();
        if (dictionary == null || dictionary.isEmpty()) return len;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                String word = sentence.substring(j, i);
                int unrecogCharNum = dictionary.contains(word) ? 0 : word.length();
                int totalUnrecogCharNum = dp[j] + unrecogCharNum;
                if (totalUnrecogCharNum < dp[i]) dp[i] = totalUnrecogCharNum;
                // recurrence:
                // dp[i] = min(dp[i], dp[j] + unrecogCharNum)
                // where dp[n] is minimal number of unrecognized chars in first n chars
            }
        }
        return dp[len];
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String[] strings = {
            "looked", "just", "like", "her", "brother"
        };
        HashSet<String> dictionary = new HashSet<String>(Arrays.asList(strings));
        String sentence = "jesslookedjustliketimherbrother";
        println(parse(sentence, dictionary));
    }
}
