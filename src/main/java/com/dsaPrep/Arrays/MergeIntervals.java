package com.dsaPrep.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    //leetcode : https://leetcode.com/problems/merge-intervals/
    // TC : O(nlogn) || Space : O(n)    || ---Brute Force Approach---
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();
        int prev[] = intervals[0];
        for(int i = 1 ;i < intervals.length; i++){
            int []currInterval = intervals[i];
            if(currInterval[0] <= prev[1]){
                prev[1] = Math.max(prev[1],currInterval[1]);
            }
            else{
                merged.add(prev);
                prev = currInterval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}}; //{{1,4},{4,5}};
        int[][] mergedIntervals = mergeIntervals.merge(intervals);
        System.out.println("Merged Intervals: ");
        for(int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
