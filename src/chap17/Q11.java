package chap17;

public class Q11 {
//    Implement a method rand7() given rand5() That is, given a method that generates
//    a random number between 0 and 4 (inclusive), write a method that generates a
//    random number between 0 and 6 (inclusive).
    
    int rand7() {
        while (true) {
            int n = 5 * rand5() + rand5();
            if (n < 21) return n % 7;
        }
    }
    
    /* not yet implemented */
    int rand5() {return 0;}

}
