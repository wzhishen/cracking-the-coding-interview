package chap02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class E1 {
//    Given a set of time intervals in any order, merge all overlapping intervals into one and 
//    output the result which should have only mutually exclusive intervals. Let the intervals 
//    be represented as pairs of integers for simplicity. 
//    For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals 
//    {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly 
//    {5, 7} and {6, 8} should be merged and become {5, 8}
    
    static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start > b.start) return 1;
                else if (a.start == b.start) return 0;
                else return -1;
            }
        });
        
        ArrayList<Interval> stack = new ArrayList<Interval>();
        stack.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); ++i) {
            Interval interval = intervals.get(i);
            Interval topInterval = stack.get(stack.size()-1);
            if (topInterval.end < interval.start) {
                stack.add(interval);
            }
            else {
                if (interval.end > topInterval.end) {
                    topInterval.end = interval.end;
                }
            }
        }
        return stack;
    }

}
