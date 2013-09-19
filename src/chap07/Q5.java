package chap07;

public class Q5 /*class Square*/{
//    Given two squares on a two-dimensional plane, find a line that would cut these two
//    squares in half. Assume that the top and the bottom sides of the square run parallel
//    to the x-axis.
    Point p1, p2, p3, p4;
    
    public static Line findLine(Q5 s1, Q5 s2) {
        return new Line(s1.mid(), s2.mid());
    }
    
    private Point mid() {
        return new Point((p1.x+p2.x)/2, (p1.y+p3.y)/2);
    }
    
    class Point {
        int x, y;
        public Point(int x, int y) {this.x = x; this.y = y;}
    }
    
    static class Line {
        Point p1, p2;
        public Line(Point p1, Point p2) {this.p1 = p1; this.p2 = p2;}
    }
}
