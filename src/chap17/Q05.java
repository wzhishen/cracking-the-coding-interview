package chap17;

import static helpers.Printer.*;

import java.util.HashMap;

/**
 * The Game of Master Mind is played as follows:
 * The computer has four slots, and each slot will contain a ball
 * that is red (R), yellow (Y), green (C) or blue (B). For example,
 * the computer might have RGGB (Slot # 1 is red, Slots #2 and #3
 * are green, Slot #4 is blue).
 *
 * You, the user, are trying to guess the solution. You might, for
 * example, guess YRGB. When you guess the correct color for the
 * correct slot, you get a "hit". If you guess a color that exists
 * but is in the wrong slot, you get a "pseudo-hit". Note that a
 * slot that is a hit can never count as a pseudo-hit.
 *
 * For example, if the actual solution is RGBY and you guess GGRR,
 * you have one hit and one pseudo-hit.
 *
 * Write a method that, given a guess and a solution, returns the
 * number of hits and pseudo-hits.
 */
public class Q05 {
    public static int[] playMasterMind(String solution, String guess) {
        if (solution == null || guess == null) return null;
        if (solution.length() != guess.length()) return new int[] {0, 0};

        int hits = 0, pseudoHits = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < solution.length(); ++i) {
            char letter = solution.charAt(i);
            if (letter == guess.charAt(i)) {
                ++hits;
            } else {
                Integer cnt = map.get(letter);
                if (cnt == null) {
                    map.put(letter, 1);
                } else {
                    map.put(letter, ++cnt);
                }
            }
        }
        for (int i = 0; i < guess.length(); ++i) {
            char letter = guess.charAt(i);
            if (letter != solution.charAt(i) && map.containsKey(letter)) {
                Integer cnt = map.get(letter);
                if (cnt > 0) {
                    map.put(letter, --cnt);
                    ++pseudoHits;
                }
            }
        }
        return new int[] {hits, pseudoHits};
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        test("RGBY", "GRRR");
        test("RGBY", "GGRR");
        test("RGBVEWIDMRENI4WQTYHUKYHUKY", "GGDF6Q7G8EFWJIOKRJHBTVHUKY");
    }

    private static void test(String solution, String guess) {
        int[] result = playMasterMind(solution, guess);
        println(result[0] + " " + result[1]);
    }
}
