package chap11;

public class Q3 {
//    Given a sorted array of n integers that has been rotated an unknown number of
//    times, write code to find an element in the array. You may assume that the array was
//    originally sorted in increasing order.
    
    static int search(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (a[mid] == x) return mid;
            // left half sorted
            if (a[low] < a[mid]) {
                if (a[low] <= x && x < a[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            //right half sorted
            else {
                if (a[mid] < x && x <= a[high])
                    low = mid + 1;
                else
                    high = mid - 1;    
                }
            }
        return -1;
    }
    
    // normal binary search
    int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (a[mid] == x) return mid;
            else if (a[mid] < x) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    
    //----------------------------------------
    public static void main(String[]args) {
        int[] a = {4,5,6,7,8,9,1,2,3};
        System.out.print(search(a, 7));
    }

}
