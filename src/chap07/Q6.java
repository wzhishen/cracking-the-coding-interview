package chap07;

import java.util.ArrayList;
import java.util.HashMap;

public class Q6 {
//    Given a two-dimensional graph with points on it, find a line which passes the most
//    number of points.
    
    public Line findBestLine(Point[] points) {
        Line bestLine = null;
        int bestCnt = 0;
        HashMap<Double, ArrayList<Line>> lines = new HashMap<Double, ArrayList<Line>>();
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                Line line = new Line(points[i], points[j]);
                insertLine(lines, line);
                int cnt = countEquivLines(lines, line);
                if (cnt > bestCnt) {
                    bestCnt = cnt;
                    bestLine = line;
                }
            }
        }
        return bestLine;
    }
    
    private int countEquivLines(HashMap<Double, ArrayList<Line>> lines, Line line) {
        int cnt = 0;
        double key = line.floorToPrecision(line.slope);
        ArrayList<Line> linesOfSameKey = lines.get(key);
        if (linesOfSameKey != null)
            for (Line l : linesOfSameKey) {
                if (l.isEquivalent(line)) ++cnt;
            }
        linesOfSameKey = lines.get(key + Line.precision);
        if (linesOfSameKey != null)
            for (Line l : linesOfSameKey) {
                if (l.isEquivalent(line)) ++cnt;
            }
        linesOfSameKey = lines.get(key - Line.precision);
        if (linesOfSameKey != null)
            for (Line l : linesOfSameKey) {
                if (l.isEquivalent(line)) ++cnt;
            }
        return cnt;
    }
    
    private void insertLine(HashMap<Double, ArrayList<Line>> lines, Line line) {
        double key = line.floorToPrecision(line.slope);
        if (!lines.containsKey(key)) {
            lines.put(key, new ArrayList<Line>());
        }
        lines.get(key).add(line);
    }
    
    class Line {
        static final double precision = 0.00001;
        double slope, intercept;
        boolean infiniteSlope = false;
        public Line(Point p1, Point p2) {
            if (Math.abs(p1.x - p2.x)>precision) {
                slope = (p1.y-p2.y)/(p1.x-p2.x);
                intercept = p1.y - slope*p1.x;
            }
            else {
                infiniteSlope = true;
                intercept = p1.x;
            }
        }
        
        public double floorToPrecision(double d) {
            return ((int)d/precision)*precision;
        }
        
        private boolean isEquivalent(double a, double b) {
            return Math.abs(a-b)<precision;
        }
        
        public boolean isEquivalent(Line line) {
            return isEquivalent(this.slope, line.slope) &&
                    isEquivalent(this.intercept, line.intercept) &&
                    this.infiniteSlope == line.infiniteSlope;
        }
    }
    class Point {
        int x, y;
        public Point(int x, int y) {this.x=x;this.y=y;}
    }

}
