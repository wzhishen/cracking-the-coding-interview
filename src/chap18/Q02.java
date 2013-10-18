package chap18;

import java.util.Random;

public class Q02 {
//    Write a method to shuffle a deck of cards. It must be a perfect shuffle¡ªin other
//    words, each of the 52! permutations of the deck has to be equally likely. Assume
//    that you are given a random number generator which is perfect.
//    
//    SOLUTION:
//    moving through the array and, for each element i, swapping array [i] with a random element
//    between 0 and i, inclusive.
    
    void shuffle(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            int r = rand(0, i);
            int tmp = a[i]; a[i] = a[r]; a[r] = tmp;
        }
    }
    
    int rand(int beg, int end) {
        Random r = new Random();
        return r.nextInt(end-beg+1)+beg;
    }

}
