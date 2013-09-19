package chap07;

import java.util.ArrayList;
import java.util.List;

public class Q7 {
//    Design an algorithm to find the kth number such that the only prime factors are 3,
//    5, and 7.
    static int findKthNum(int k) {// start with k = 1
        if (k <= 0) return -1;
        
        int val = 1;
        List<Integer> list = new ArrayList<Integer>();
        list.add(val);
        for (int i = 0; i < k; ++i) {
            val = removeMin(list);
            list.add(3 * val); list.add(5 * val); list.add(7 * val);
        }
        return val;
    }
    
    private static int removeMin(List<Integer> list) {
        Integer min = Integer.MAX_VALUE;//XXX: note Integer not int due to remove(Object) call
        for (Integer i : list) {
            if (i < min) min = i;
        }
        //XXX: or more fancy one:
        //while(list.remove(min));
        while (list.contains(min))
            list.remove(min);
        return min;
    }
    
    //-----------------------------------------
    public static void main(String[]args) {
        for (int i = 1; i <=10; ++i)
            System.out.println(findKthNum(i));
    }

}
