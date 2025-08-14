package com.dsaPrep.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSum0 {
    //TC : O(n^2) || Space : O(1)    || ---Brute Force Approach---
    public int maxLen(int[] arr) {
        int len = arr.length;
        int longest = 0;
        for(int i = 0 ; i < len; i++){
            int sum = 0;
            for(int j = i; j < len; j++){
                sum += arr[j];
                if(sum == 0){
                    longest = Math.max(longest,j-i+1);
                }
            }
        }
        return longest;
    }

    //TC : O(n) || Space : O(n)    || ---Optimized Approach---
    public int maxLen1(int arr[]){
        int len = arr.length;
        int maxLength = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); // To handle the case when subarray starts from index 0
        for(int i = 0 ; i < len; i++){
            sum += arr[i];
            if(map.containsKey(sum)) {
                int previousIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - previousIndex);
            }
            // If sum is not present in map, add it with the current index
            else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        LongestSubarrayWithSum0 obj = new LongestSubarrayWithSum0();
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};//{1,2,-1,-2,5,0};
        System.out.println("Length of the longest subarray with sum 0: " + obj.maxLen1(arr)); // Output: 6
    }
}
