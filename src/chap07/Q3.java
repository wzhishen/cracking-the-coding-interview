package chap07;

import static helpers.Printer.*;

/**
 * Given two lines on a Cartesian plane, determine whether the two lines
 * would intersect. Two same lines are considered to be intersected.
 */
public class Q3 {
    public static class Line {
        static final double EPSILON = 0.0000001;
        double slope;
        double yintercept;
        public Line(double slope, double yintercept) {
            this.slope = slope;
            this.yintercept = yintercept;
        }
    }

    /*
     * Key: Don't assume that the slope and y-intercept are integers.
     * Understand limitations of floating point representations. Never check
     * for equality with ==. Instead, check if the difference is less than an
     * epsilon value.
     */
    public static boolean intersect(Line l1, Line l2) {
        return Math.abs(l1.slope - l2.slope) > Line.EPSILON ||
               Math.abs(l1.yintercept - l2.yintercept) < Line.EPSILON;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Line l1 = new Line(0.4, 0.79), l2 = new Line(0.5, 0.9), l3 = new Line(0.4, 1.3);
        println(intersect(l1, l2));
        println(intersect(l3, l1));
        println(intersect(l3, l3));
    }
}
