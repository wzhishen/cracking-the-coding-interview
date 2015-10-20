package chap07;

import java.util.ArrayList;

/**
 * Given two squares on a two-dimensional plane, find a line that
 * would cut these two squares in half. Assume that the top and
 * the bottom sides of the square run parallel to the x-axis.
 */
public class Q5 {
    public Line findLine(Square s1, Square s2) {
        return new Line(mid(s1), mid(s2));
    }

    private Point mid(Square s) {
        ArrayList<Point> points = s.points;
        int sumX = 0, sumY = 0, n = points.size();
        for (Point p : points) {
            sumX += p.x;
            sumY += p.y;
        }
        return new Point(sumX / n, sumY / n);
    }

    public class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Line {
        Point p1, p2;
        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    public class Square {
        ArrayList<Point> points;
        public Square(ArrayList<Point> points) {
            this.points = points;
        }
    }
}
