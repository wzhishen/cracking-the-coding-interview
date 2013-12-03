package chap09;

import java.util.ArrayList;
import java.util.Arrays;

public class Q02_2 {
    /*
    FOLLOW UP
    Find all paths.
    */
    
    // pass in an ArrayList as buffer
    static void findPath(ArrayList<ArrayList<Point>> result, ArrayList<Point> path, int x, int y) {
        if (x < 0 || y < 0) return;
        if (!isFree(x, y)) return;
        Point p = new Point(x, y);
        path.add(0, p);
        if (x == 0 && y == 0) {
            result.add((ArrayList<Point>) path.clone());
            // do NOT add 'return;' here!
        }
        findPath(result, path, x - 1, y);
        findPath(result, path, x, y - 1);
        path.remove(p); //XXX: need to manually "pop"
    }
    
    // pass in an Array as buffer
    static void findPath2(ArrayList<ArrayList<Point>> result, Point[] path, int index, int x, int y) {
        if (x < 0 || y < 0) return;
        if (!isFree(x, y)) return;
        Point p = new Point(x, y);
        path[index] = p;
        if (x == 0 && y == 0) {
            ArrayList<Point> res = new ArrayList<Point>(Arrays.asList(path));
            result.add(res);
            return; // optional
        }
        findPath2(result, path, index - 1, x - 1, y);
        findPath2(result, path, index - 1, x, y - 1);
    }
    
    //-----------------------------------------
    public static void main(String[]args) {
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        findPath(result, new ArrayList<Point>(), 3, 3);
        System.out.println(result);
        
        result.clear();
        findPath2(result, new Point[7], 6, 3, 3);
        System.out.println(result);
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
