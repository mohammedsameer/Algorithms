package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm
 * 1. Sort the intervals using start
 * 2. Compare current with next, if the current end > next start then merge else add current
 */
public class Program {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    public static List<Interval> merge(List<Interval> intervals) {

        if(intervals.size() <= 1)
            return intervals;

        //Sort intervals using start
        intervals.sort((i, j) -> Integer.compare(i.start, j.start));
        List<Interval> result = new ArrayList<>();

        Interval curr = intervals.get(0);
        int index = 1;
        while (index < intervals.size()) {
            Interval next = intervals.get(index);
            if(curr.end >= next.start) {
                //Handle use case when current end is smaller than next end
                curr.end = Math.max(curr.end, next.end);
            } else {
                result.add(curr);
                curr = next;
            }
            index++;
        }

        //Add the last curr
        result.add(curr);
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval interval1 = new Interval(1,4);
        Interval interval2 = new Interval(0,1);
        intervals.add(interval1);
        intervals.add(interval2);
        System.out.println(merge(intervals));
    }
}