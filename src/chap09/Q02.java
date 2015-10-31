package chap09;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Imagine a robot sitting on the upper left comer of an X by Y
 * grid. The robot can only move in two directions: right and down.
 * How many possible paths are there for the robot to go from (0, 0)
 * to (X, Y)?
 *
 * Choose X from X + Y: C(X+Y, X) = (X+Y)!/(X!Y!)
 *
 * FOLLOW UP
 * Imagine certain spots are "off limits", such that the robot
 * cannot step on them. Design an algorithm to find a path for
 * the robot from the top left to the bottom right.
 */
public class Q02 {
    public static ArrayList<Point> findPath(int[][] map) {
        ArrayList<Point> path = new ArrayList<Point>();
        findPath(map.length - 1, map[0].length - 1, map, path);
        return path;
    }

    private static boolean findPath(int x, int y, int[][] map, ArrayList<Point> path) {
        if (x < 0 || y < 0) return false;
        if (map[x][y] == 0) return false;
        Point p = new Point(x, y);
        if (x == 0 && y == 0) {
            path.add(p);
            return true;
        }
        boolean success = findPath(x - 1, y, map, path);
        if (!success) success = findPath(x, y - 1, map, path);
        if (success) path.add(p);
        return success;
    }

    public static ArrayList<Point> findPathDP(int[][] map) {
        ArrayList<Point> path = new ArrayList<Point>();
        HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
        findPathDP(map.length - 1, map[0].length - 1, map, path, cache);
        return path;
    }

    private static boolean findPathDP(int x, int y, int[][] map, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
        if (x < 0 || y < 0) return false;
        if (map[x][y] == 0) return false;
        Point p = new Point(x, y);
        if (cache.containsKey(p)) return cache.get(p);
        if (x == 0 && y == 0) {
            path.add(p);
            return true;
        }
        boolean success = findPathDP(x - 1, y, map, path, cache);
        if (!success) success = findPathDP(x, y - 1, map, path, cache);
        if (success) path.add(p);
        cache.put(p, success);
        return success;
    }

    /**
     * FOLLOW UP 2
     * What if multiple paths are available?
     * Find all paths.
     */
    public static ArrayList<ArrayList<Point>> findAllPaths(int[][] map) {
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        findAllPaths(map.length - 1, map[0].length - 1, map, new ArrayList<Point>(), result);
        return result;
    }

    // pass in an ArrayList as buffer
    @SuppressWarnings("unchecked")
    private static void findAllPaths(int x, int y, int[][] map,
            ArrayList<Point> path, ArrayList<ArrayList<Point>> result) {
        if (x < 0 || y < 0) return;
        if (map[x][y] == 0) return;
        Point p = new Point(x, y);
        path.add(0, p);
        if (x == 0 && y == 0) {
            result.add((ArrayList<Point>) path.clone());
        }
        findAllPaths(x - 1, y, map, path, result);
        findAllPaths(x, y - 1, map, path, result);
        path.remove(p);
    }

    public static ArrayList<ArrayList<Point>> findAllPaths2(int[][] map) {
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        Point[] path = new Point[2 * map.length - 1];
        findAllPaths2(map.length - 1, map[0].length - 1, map, path, path.length - 1, result);
        return result;
    }

    // pass in an Array as buffer
    private static void findAllPaths2(int x, int y, int[][] map,
            Point[] path, int index, ArrayList<ArrayList<Point>> result) {
        if (x < 0 || y < 0) return;
        if (map[x][y] == 0) return;
        Point p = new Point(x, y);
        path[index] = p;
        if (x == 0 && y == 0) {
            result.add(new ArrayList<Point>(Arrays.asList(path)));
        }
        findAllPaths2(x - 1, y, map, path, index - 1, result);
        findAllPaths2(x, y - 1, map, path, index - 1, result);
    }

    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point that = (Point) o;
            return x == that.x && y == that.y;
        }
        public int hashCode() {
            return Integer.valueOf(x).hashCode() *
                   Integer.valueOf(y).hashCode();
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[][] map = {{1,1,0,1},
                       {1,1,1,1},
                       {1,0,1,1},
                       {1,1,0,1}};
        println(findPath(map));
        println(findPathDP(map));
        println(findAllPaths(map));
        println(findAllPaths2(map));
    }
}
