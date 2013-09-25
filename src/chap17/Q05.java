package chap17;

public class Q05 {
 //    The Came of Master Mind is played as follows:
//        The computer has four slots, and each slot will contain a ball that is red (R), yellow
//        (Y), green (C) or blue (B). For example, the computer might have RGGB (Slot # 1 is red,
//        Slots #2 and #3 are green, Slot #4 is blue).
//        You, the user, are trying to guess the solution. You might, for example, guess YRGB.
//        When you guess the correct color for the correct slot, you get a "hit." If you guess a
//        color that exists but is in the wrong slot, you get a "pseudo-hit." Note that a slot that
//        is a hit can never count as a pseudo-hit.
//        For example, if the actual solution is RGBYandyou guess GGRR, you have one hit
//        and one pseudo-hit.
//        Write a method that, given a guess and a solution, returns the number of hits and
//        pseudo-hits.
    
    static Tuple count(String guess, String solution) {
        Tuple res = new Tuple();
        int[] pseudohits = new int[4];
        if (guess.length() != solution.length()) return null;
        for (int i = 0; i < solution.length(); ++i) {
            if (solution.charAt(i) == guess.charAt(i)) {
                ++res.hit;
            }
            else {
                ++pseudohits[code(solution.charAt(i))];
            }
        }
        
        for (int i = 0; i < guess.length(); ++i) {
            int code = code(guess.charAt(i));
            if (code != -1 && pseudohits[code] > 0) {
                --pseudohits[code];
                ++res.pseudohit;
            }
        }
        return res;
    }
    
    private static int code(char ch) {
        switch (ch) {
            case 'R': return 0;
            case 'Y': return 1;
            case 'G': return 2;
            case 'B': return 3;
        }
        return -1;
    }
    
    static class Tuple {
        int hit; int pseudohit;
    }
    
    //----------------------------------------
    public static void main(String[]args) {
        Tuple res = count("GRRR", "RGBY");
        System.out.println(res.hit + " " + res.pseudohit);
    }

}
