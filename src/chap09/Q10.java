package chap09;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.List;

/**
 * You have a stack of n boxes, with widths w, heights h and
 * depths d. The boxes cannot be rotated and can only be stacked
 * on top of one another if each box in the stack is strictly
 * larger than the box above it in width, height, and depth.
 * Implement a method to build the tallest stack possible, where
 * the height of a stack is the sum of the heights of each box.
 */
public class Q10 {
    /*
     * Also see http://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
     * for a generalized version of box stacking problem.
     */
    public static ArrayList<Box> buildTallestStack(Box[] boxes) {
        if (boxes == null) return null;
        return buildTallestStack(boxes, null);
    }

    private static ArrayList<Box> buildTallestStack(Box[] boxes, Box bottom) {
        int maxHeight = 0;
        ArrayList<Box> maxStack = null;
        for (Box box : boxes) {
            if (box.canPlaceAbove(bottom)) {
                ArrayList<Box> boxStack = buildTallestStack(boxes, box);
                int height = getStackHeight(boxStack);
                if (height > maxHeight) {
                    maxHeight = height;
                    maxStack = boxStack;
                }
            }
        }
        if (maxStack == null) maxStack = new ArrayList<Box>();
        if (bottom != null) maxStack.add(0, bottom);
        return maxStack;
    }

    private static int getStackHeight(List<Box> boxes) {
        int height = 0;
        for (Box b : boxes) height += b.height;
        return height;
    }

    public static class Box {
        private int width, length, height;
        public Box(int w, int l, int h) {
            width = w;
            length = l;
            height = h;
        }
        public boolean canPlaceAbove(Box b) {
            return b == null ||
                    (this.width < b.width &&
                    this.length < b.length &&
                    this.height < b.height);
        }
        public String toString() {
            return "(" + width + ", " + length + ", " + height + ")";
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Box[] boxes = {
            new Box(1, 7, 4),
            new Box(2, 6, 9),
            new Box(4, 9, 6),
            new Box(10, 12, 8),
            new Box(6, 2, 5),
            new Box(3, 8, 5),
            new Box(5, 7, 7),
            new Box(2, 10, 16),
            new Box(12, 15, 9),
        };
        println(buildTallestStack(boxes));
    }
}
