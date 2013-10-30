package chap09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q02 {
    /*
    Imagine a robot sitting on the upper left comer of an X by Ygrid. The robot can only
    move in two directions: right and down. How many possible paths are there for the
    robot to go from (0, 0) to (X, Y) ?
    
    Choose X from X + Y:
    C(X+Y, X) = (X+Y)!/(X!Y!)
    
    FOLLOW UP
    Imagine certain spots are "off limits," such that the robot cannot step on them.
    Design an algorithm to find a path for the robot from the top left to the bottom right.
    */
    static List<Point> path = new ArrayList<Point>();
    
    // normal recursion
    static boolean findPath(int x, int y) {
        if (x < 0 || y < 0) return false;
        if (x == 0 && y == 0) return true;
        
        boolean success = false;
        if (isFree(x-1, y))
            success = findPath(x-1, y);
        if (!success && isFree(x, y-1))
            success = findPath(x, y-1);
        if (success)
            path.add(new Point(x, y));
        return success;
    }
    
    static HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
    // DP
    static boolean findPathDP(int x, int y) {
        Point p = new Point(x, y);
        if (cache.containsKey(p))
            return cache.get(p);
        if (x < 0 || y < 0) return false;
        if (x == 0 && y == 0) return true;
        
        boolean success = false;
        if (isFree(x-1, y))
            success = findPath(x-1, y);
        if (!success && isFree(x, y-1))
            success = findPath(x, y-1);
        if (success)
            path.add(new Point(x, y));
        cache.put(p, success);
        return success;
    }
    
    //-----------------------------------------
    public static void main(String[]args) {
        System.out.println(findPathDP(3,3));
        System.out.println(path);
    }
    
    private static boolean isFree(int x, int y) {
        /*not fully implemented*/
        if (x==0 && y==2 ||
            x==2 && y==1 ||
            x==3 && y==2 ||
            x==1 && y==3)
            return false;
        return true;
    }
    
    static class Point {
        int x; int y;
        public Point(int x, int y) {this.x=x; this.y=y;}
        @Override
        public String toString() {return "("+x+", "+y+")";}
    }

}
