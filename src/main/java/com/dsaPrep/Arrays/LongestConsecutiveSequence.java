package com.dsaPrep.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    //-- TC O(n^2) | SC O(1)
    // --Brute Force Approach
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int maxCount = 0;

        for(int i = 0 ; i < len; i++){
            int ele = nums[i];
            int count = 1;
            for(int j = i+1; j < len; j++){
                if(nums[j] == ele+1){
                    count++;
                    ele = nums[j];
                }
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }

    //-- TC O(n) | SC O(n)
    public int longestConsecutive1(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        Arrays.sort(nums);
        int max = 1;
        int count = 0;
        int curr = Integer.MIN_VALUE;
        for(int i = 0 ; i < len; i++){
            if(curr == nums[i]-1){
                count++;
                curr = nums[i];
            }
            else if(curr != nums[i]){
                count = 1;
                curr = nums[i];
            }
            max = Math.max(max,count);
        }
        return max;
    }

    //-- TC O(n) | SC O(n)
    public int longestConsecutive2(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < len; i++){
            set.add(nums[i]);
        }
        int max = 0;
        for(int num : set){
            //only start counting if it is the starting ele
            if(!set.contains(num-1)){
                int curr = num;
                int count = 1;
                while(set.contains(curr+1)){
                    curr = curr+1;
                    count = count+1;
                }
                max = Math.max(max,count);
            }

        }
        return max;
    }
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2}; // Example input
        int result = lcs.longestConsecutive2(nums);
        System.out.println("Length of the longest consecutive sequence: " + result);
    }
}
