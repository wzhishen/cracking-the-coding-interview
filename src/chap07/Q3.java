package chap07;

public class Q3 /*class Line*/ {
//    Given two lines on a Cartesian plane, determine whether the two lines would
//    intersect.
//    Two same lines are considered to be intersected.
    
    static double precision = 0.0000001;
    double slope;
    double yintercept;
    
    public Q3 /*class Line*/ (double slope, double yintercept) {
        this.slope = slope;
        this.yintercept = yintercept;
    }
    
    boolean intersect(Q3 line) {
        //XXX: Don't assume that the slope and y-intercept are integers.
        //Understand limitations of floating point representations. Never check for equality
        //with ==. Instead, check if the difference is less than an epsilon value.
        return Math.abs(slope - line.slope) > precision ||
               Math.abs(yintercept - line.yintercept) < precision;
        /* equals to
               Math.abs(slope - line.slope) > precision ||
               (Math.abs(slope - line.slope) < precision &&
               Math.abs(yintercept - line.yintercept) < precision); */
    }
}
