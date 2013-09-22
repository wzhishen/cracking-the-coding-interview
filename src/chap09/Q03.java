package chap09;

public class Q03 {
//    A magic index in an array A[0.. .n-1] is defined to be an index such that A[i]
//    = i. Given a sorted array of distinct integers, write a method to find a magic
//    index, if one exists, in array A.
//    FOLLOW UP
//    What if the values are not distinct?
    
    static int getMagicIndex(int[] a, int start, int end) {
        if (start > end || start < 0 || end > a.length - 1) return -1;
        
        int mid = (start + end) / 2;
        if (a[mid] == mid) {
            return mid;
        }
        else if (a[mid] < mid) {
            return getMagicIndex(a, mid + 1, end);
        }
        else {
            return getMagicIndex(a, start, mid - 1);
        }
    }
    
    static int getMagicIndex(int[] a) { return getMagicIndex(a, 0, a.length - 1); }
    
    static int getMagicIndex2(int[] a, int start, int end) {
        if (start > end || start < 0 || end > a.length - 1) return -1;
        
        int mid = (start + end) / 2;
        if (a[mid] == mid) {
            return mid;
        }
        int left = Math.min(mid - 1, a[mid]);
        int ret = getMagicIndex2(a, start, left);
        if (ret != -1) return ret;
        
        int right = Math.max(mid + 1, a[mid]);
        ret = getMagicIndex2(a, right, end);
        return ret;
    }
    
    static int getMagicIndex2(int[] a) { return getMagicIndex2(a, 0, a.length - 1); }
    
    //----------------------------------------
    public static void main(String[]args) {
        System.out.println(getMagicIndex(new int[] {-1, 0, 1, 3, 5, 7, 9}));
        System.out.println(getMagicIndex2(new int[] {-1,0,2,2,2,2,3,4,6,9,11,12,13}));
    }

}
