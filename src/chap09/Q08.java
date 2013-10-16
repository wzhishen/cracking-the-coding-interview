package chap09;

public class Q08 {
//    Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5
//    cents) and pennies (1 cent), write code to calculate the number of ways of representing
//    n cents.
    
    // Get all the *combinations*
    static int getNumRepresentations(int n, int coin) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int sum = 0;
        switch (coin) { //XXX: note that there is no "break"s in-between
            case 25: sum += getNumRepresentations(n - 25, 25);
            case 10: sum += getNumRepresentations(n - 10, 10);
            case 5: sum += getNumRepresentations(n - 5, 5);
            case 1: sum += getNumRepresentations(n - 1, 1);
        }
        return sum;
    }
    
    // This is WRONG because we get all the *permutations*
    static int getNumRepresentationsWRONG(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return getNumRepresentationsWRONG(n - 25) +
                getNumRepresentationsWRONG(n - 10) +
                getNumRepresentationsWRONG(n - 5) +
                getNumRepresentationsWRONG(n - 1);
    }
    
    //-------------------------------------
    public static void main(String[]args) {
        System.out.println(getNumRepresentations(20, 25));
//        System.out.println(getNumRepresentationsWRONG(20));
    }
    
        
}
