package chap01;

public class E2 {
//    Given n non-negative integers representing the histogram's bar height 
//    where the width of each bar is 1, find the area of largest rectangle in 
//    the histogram. Above is a histogram where width of each bar is 1, given 
//    height = [2,1,5,6,2,3]. The largest rectangle is shown in the shaded area, 
//    which has area = 10 unit. For example, Given height = [2,1,5,6,2,3], 
//    return 10.
    
    static int findMaxArea(int[] a) {
        int maxArea = 0;
        for (int i = 0; i < a.length; ++i) {
            int heightLimit = Integer.MAX_VALUE;
            for (int j = i; j < a.length; ++j) {
                if (a[j] < heightLimit) heightLimit = a[j];
                int area = heightLimit * (j - i + 1);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    //----------------------------------
    public static void main(String[]args) {
        System.out.println(findMaxArea(new int[] {2,1,5,6,2,3}));
    }
}
