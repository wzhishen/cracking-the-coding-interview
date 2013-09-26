package chap18;

public class Q03 {
//    Write a method to randomly generates set of m integers from an array of size n.
//    Each element must have equal probability of being chosen.
//    
//    SOLUTION:
//    We initialize an array subset to be the first m elements in original. Then, we 
//    iterate through the array, starting at element m, inserting array [i] into the 
//    subset at (random) position k whenever k < m.
    
    int[] generateRandomSubset(int[] a, int m) {
        assert m <= a.length;
        int[] ret = new int[m];
        for (int i = 0; i < m; ++i) {
            ret[i] = a[i];
        }
        for (int i = m; i < a.length; ++i) {
            int r = rand(0, i);
            if (r < m) {
                ret[r] = a[i];
            }
        }
        return ret;
    }
    
    int rand(int beg, int end) { /* Not implemented */ return 0; }

}
