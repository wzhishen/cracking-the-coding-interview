package chap11;

public class Q1 {
//    You are given two sorted arrays, A and B, where A has a large enough buffer at
//    the end to hold B. Write a method to merge B into A in sorted order.
    
    static void merge(int[] a, int[] b, int lastA) {
        for (int i = b.length-1; i >= 0; --i) {
            int indexA = lastA;
            while (indexA > 0 && b[i] < a[indexA]) {
                a[indexA+1] = a[indexA];
                --indexA;
            }
            a[indexA+1]=b[i];
            ++lastA;//XXX
        }
    }
    
    static void merge2(int[] a, int[] b, int lastA) {//better
        int lastB = b.length - 1;
        int last = lastA + b.length;//new end
        while (lastA >= 0 && lastB >= 0) {
            if (b[lastB] > a[lastA]) 
                a[last--] = b[lastB--];
            else 
                a[last--] = a[lastA--];
        }
        
        while (lastB >= 0) {//a[] hits the head first: copy elements left in b[]
            a[last--] = b[lastB--];
        }
    }
    
    //---------------------------------------
    public static void main(String[]args) {
        int[] a = {1,3,4,5,6,0,0,0,0,0,0,0,0,0,0}; int[] b = {2,3,4};
        int[] a2 = {1,3,4,5,6,0,0,0,0,0,0,0,0,0,0}; int[] b2 = {2,3,4};
        merge(a,b,4);
        for(int n:a)System.out.print(n+" ");System.out.println();
        merge2(a2,b2,4);
        for(int n:a)System.out.print(n+" ");
    }

}
