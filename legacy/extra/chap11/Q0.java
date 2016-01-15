package chap11;

public class Q0 {
    //bubble sort
    static void bubblesort(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            bubblesortHelper(a);
        }
    }
    private static void bubblesortHelper(int[] a) {
        for (int i = 0; i < a.length-1; ++i) {
            if (a[i] > a[i+1]) swap(a, i, i+1);
        }
    }
    
    //insertion sort
    static void insertionsort(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            int j = i;
            int curr = a[i];
            while (j > 0 && curr < a[j-1]) {
                a[j] = a[j-1];
                --j;
            }
            a[j] = curr;
        }
    }
    
    //selection sort
    static void selectionsort(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            int min = i;
            for (int j = i+1; j < a.length; ++j) {
                if (a[j] < a[min]) min = j;
            }
            swap(a, i, min);//select the min to the front
        }
    }
    
    //merge sort
    static void mergesort(int[] a) {
        mergesort(a, new int[a.length], 0, a.length-1);//XXX: [0, LAST] inclusive
    }
    static void mergesort(int[] a, int[] cache, int low, int high) {
        if (low >= high) return; //XXX: when low==high, we should also return
        int mid = (low+high)/2;
        mergesort(a, cache, low, mid);
        mergesort(a, cache, mid+1, high);
        merge(a, cache, low, mid, high);
    }
    private static void merge(int[] a, int[] cache, int low, int mid, int high) {
        //copy to cache. XXX: from low to high
        for (int i = low; i <= high; ++i) {
            cache[i] = a[i];
        }
        
        int left = low; int right = mid+1; int curr = low;
        while (left <= mid && right <= high) {
            if (cache[left] < cache[right]) {
                a[curr] = cache[left];
                ++left;
            }
            else {
                a[curr] = cache[right];
                ++right;
            }
            ++curr;
        }
        
        //XXX: copy remaining left
        for (int i = 0; i <= mid - left; ++i) {//XXX: <= not <
            a[curr+i] = cache[left+i];
        }
    }
    
    //quick sort
    static void quicksort(int[] a) {
        quicksort(a, 0, a.length-1);//XXX: [0, LAST] inclusive
    }
    static void quicksort(int[] a, int left, int right) {
        if (left >= right) return;//XXX: when left==right, we should also return
        int p = partition(a, left, right);
        quicksort(a, left, p-1);//XXX
        quicksort(a, p, right);
    }
    private static int partition(int[] a, int left, int right) {
        int pivot = a[(left+right)/2];
        while (left < right) {
            while (a[left] < pivot) ++left;
            while (a[right] > pivot) --right;
            if (left <= right) {//XXX
                swap(a, left, right);
                //XXX: make another move after swapping!
                ++left;
                --right;
            }
        }
        return left;
    }
    
    static int binarySearch(int[] a, int target) {
        return binarySearch(a, target, 0, a.length-1);//XXX: [0, LAST] inclusive
    }
    static int binarySearch(int[] a, int target, int low, int high) {
        if (low > high) return -1;
        int mid = (low+high)/2;
        if (a[mid] == target) 
            return mid;
        else if (a[mid] > target) 
            return binarySearch(a, target, low, mid-1);
        else
            return binarySearch(a, target, mid+1, high);
    }
    
    //--------------------------------------------
    public static void main(String[]args) {
        int[] a = resetArray();//a = {1,3,4,9,8,2,6,6,10,5,14,13,20};
        
        bubblesort(a);
        System.out.println("Bubble sort: ");for(int n:a)System.out.print(n+" ");
        a = resetArray();
        
        insertionsort(a);
        System.out.println("\nInsertion sort: ");for(int n:a)System.out.print(n+" ");
        a = resetArray();
        
        selectionsort(a);
        System.out.println("\nSelection sort: ");for(int n:a)System.out.print(n+" ");
        a = resetArray();
        
        mergesort(a);
        System.out.println("\nMerge sort: ");for(int n:a)System.out.print(n+" ");
        a = resetArray();
        
        quicksort(a);
        System.out.println("\nQuick sort: ");for(int n:a)System.out.print(n+" ");
        
        int x=10;
        System.out.println("\nBinary search of "+x+": "+binarySearch(a, x));
    }
    
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i]; a[i] =a[j]; a[j] = tmp;
    }
    
    private static int[] resetArray() {
        return new int[] {1,3,4,9,8,2,6,6,10,5,14,13,20};
    }

}
