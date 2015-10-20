package chap07;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a two-dimensional graph with points on it, find a line
 * which passes the most number of points.
 */
public class Q6 {
    private static final double EPSILON = 0.0000001;

    public static Line findBestLine(Point[] points) {
        Line bestLine = null;
        int bestCnt = 0;
        HashMap<Double, ArrayList<Line>> lines = new HashMap<Double, ArrayList<Line>>();
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                Line line = new Line(points[i], points[j]);
                addLine(lines, line);
                int cnt = countEquivalentLines(lines, line);
                if (cnt > bestCnt) {
                    bestCnt = cnt;
                    bestLine = line;
                }
            }
        }
        return bestLine;
    }

    private static int countEquivalentLines(HashMap<Double, ArrayList<Line>> lines, Line line) {
        int cnt = 0;
        double key = floorToEps(line.slope);
        ArrayList<Line> linesOfSameKey = lines.get(key);
        if (linesOfSameKey != null) {
            for (Line l : linesOfSameKey) {
                if (line.equals(l)) ++cnt;
            }
        }
        linesOfSameKey = lines.get(key + EPSILON);
        if (linesOfSameKey != null) {
            for (Line l : linesOfSameKey) {
                if (line.equals(l)) ++cnt;
            }
        }
        linesOfSameKey = lines.get(key - EPSILON);
        if (linesOfSameKey != null) {
            for (Line l : linesOfSameKey) {
                if (line.equals(l)) ++cnt;
            }
        }
        return cnt;
    }

    private static void addLine(HashMap<Double, ArrayList<Line>> lines, Line line) {
        double key = floorToEps(line.slope);
        if (!lines.containsKey(key)) {
            lines.put(key, new ArrayList<Line>());
        }
        lines.get(key).add(line);
    }

    public static class Line {
        double slope, intercept, x;
        boolean vertical;
        public Line(Point p1, Point p2) {
            if (p1 == null || p2 == null) {
                throw new IllegalArgumentException("Points are null!");
            } else if (isEquivalent(p1.x, p2.x)) {
                vertical = true;
                this.x = p1.x;
            } else {
                slope = (p1.y - p2.y) / (p1.x - p2.x);
                intercept = p1.y - slope * p1.x;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Line)) return false;
            Line that = (Line) o;
            if (vertical) {
                return that.vertical &&
                       isEquivalent(x, that.x);
            } else {
                return isEquivalent(slope, that.slope) &&
                       isEquivalent(intercept, that.intercept);
            }
        }

        @Override
        public String toString() {
            if (vertical)
                return "X = " + x;
            else if (isEquivalent(slope, 0))
                return "Y = " + intercept;
            else
                return "Y = " + slope + "*X + " + intercept;
        }
    }

    public static class Point {
        double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static double floorToEps(double a) {
        return ((int)(a / EPSILON)) * EPSILON;
    }

    private static boolean isEquivalent(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Point[] points = {
            new Point(0, 1.11),
            new Point(0, 0),
            new Point(1, 1.11),
            new Point(1.11, 1.11),
            new Point(1.11, 1),
        };
        println(findBestLine(points));
    }
}
