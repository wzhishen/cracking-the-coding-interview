package chap01;

import java.util.Arrays;
import java.util.Stack;

public class E2 {
//    Given n non-negative integers representing the histogram's bar height 
//    where the width of each bar is 1, find the area of largest rectangle in 
//    the histogram. Above is a histogram where width of each bar is 1, given 
//    height = [2,1,5,6,2,3]. The largest rectangle is shown in the shaded area, 
//    which has area = 10 unit. For example, Given height = [2,1,5,6,2,3], 
//    return 10.
    
    // use a stack, O(n) time
    static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        height = Arrays.copyOfRange(height, 0, height.length + 1);
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int currHeight = height[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int area = currHeight * (i - left - 1);
                if (area > maxArea) maxArea = area;
            }
            stack.push(i);
        }
        return maxArea;
    }
    
    // brute force: O(n^2) time
    static int largestRectangleAreaBF(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            int heightLimit = Integer.MAX_VALUE;
            for (int j = i; j < height.length; ++j) {
                if (height[j] < heightLimit) heightLimit = height[j];
                int area = heightLimit * (j - i + 1);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    //----------------------------------
    public static void main(String[]args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
        System.out.println(largestRectangleAreaBF(new int[] {2,1,5,6,2,3}));
    }
}
