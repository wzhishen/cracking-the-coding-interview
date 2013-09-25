package chap09;

import java.util.ArrayList;
import java.util.HashMap;

public class Q10 {
    
    static ArrayList<Box> buildTallestStack(ArrayList<Box> boxes, Box bottom) {
        ArrayList<Box> maxStack = null;
        int maxHeight = 0;
        for (Box b : boxes) {
            if (b.canPlaceAbove(bottom)) {
                ArrayList<Box> newStack = buildTallestStack(boxes, b);
                int newHeight = stackHeight(newStack);
                if (newHeight > maxHeight) {
                    maxHeight = newHeight;
                    maxStack = newStack;
                }
            }
        }
        if (maxStack == null) maxStack = new ArrayList<Box>();
        if (bottom != null) maxStack.add(0, bottom);
        return maxStack;
    }
    
    static ArrayList<Box> buildTallestStack(ArrayList<Box> boxes) {
        return buildTallestStack(boxes, null);
    }
    
    static ArrayList<Box> buildTallestStackDP(ArrayList<Box> boxes, Box bottom, 
            HashMap<Box, ArrayList<Box>> cache) {
        if (bottom != null && cache.containsKey(bottom))
            return cache.get(bottom);
        
        ArrayList<Box> maxStack = null;
        int maxHeight = 0;
        for (Box b : boxes) {
            if (b.canPlaceAbove(bottom)) {
                ArrayList<Box> newStack = buildTallestStackDP(boxes, b, cache);
                int newHeight = stackHeight(newStack);
                if (newHeight > maxHeight) {
                    maxHeight = newHeight;
                    maxStack = newStack;
                }
            }
        }
        if (maxStack == null) maxStack = new ArrayList<Box>();
        if (bottom != null) maxStack.add(0, bottom);
        cache.put(bottom, maxStack);
        return maxStack;
    }
    
    static ArrayList<Box> buildTallestStackDP(ArrayList<Box> boxes) {
        return buildTallestStackDP(boxes, null, new HashMap<Box, ArrayList<Box>>());
    }
    
    //----------------------------------------
    public static void main(String[]args) {
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box(1, 7, 4));boxes.add(new Box(2, 6, 9));boxes.add(new Box(4, 9, 6));
        boxes.add(new Box(10, 12, 8));boxes.add(new Box(6, 2, 5));boxes.add(new Box(3, 8, 5));
        boxes.add(new Box(5, 7, 7));boxes.add(new Box(2, 10, 16));boxes.add(new Box(12, 15, 9));
        System.out.println(buildTallestStack(boxes));
        System.out.println(buildTallestStackDP(boxes));
    }
    
    private static int stackHeight(ArrayList<Box> boxes) {
        int height = 0;
        for (Box b : boxes) {
            height += b.height;
        }
        return height;
    }
    
    static class Box {
        int width; int length; int height;
        public Box(int w, int l, int h) {width=w;length=l;height=h;}
        
        boolean canPlaceAbove(Box b) {
            return b == null ||
                    (this.width < b.width &&
                    this.length < b.length &&
                    this.height < b.height);
        }
        
        @Override
        public String toString() {return "("+width+", "+length+", "+height+")";}
    }

}
