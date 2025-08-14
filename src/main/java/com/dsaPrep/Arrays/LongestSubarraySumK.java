package com.dsaPrep.Arrays;
//Given an array nums of size n and an integer k,
// find the length of the longest sub-array that sums to k.
// If no such sub-array exists, return 0.

public class LongestSubarraySumK {
    // ----Brute Force Approach----
    // TC : O(n^3) for iterating through all subarrays
    // SC : O(1) for using constant space
    int longestSubarray1(int arr[],int target){
        int len = arr.length;
        int max = 0;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum += arr[k];
                }
                if(sum == target){
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // ----Optimized Approach----
    // TC : O(n^2) for iterating through all subarrays
    // SC : O(1) for using constant space
    int subArray2(int arr[],int target){
        int len = arr.length;
        int max = 0;
        for(int i = 0; i < len; i++){
            int sum = 0;
            for(int j = i; j < len; j++){
                sum += arr[j];
                if(sum == target){
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // ----Optimized Approach using Sliding Window----
    // TC : O(n) for iterating through the array
    // SC : O(1) for using constant space
    int subArray3(int arr[], int target) {
        int len = arr.length;
        int max = 0;
        int sum = 0;
        int first = 0;
        int second = 0;
        while(second < len){
            if(sum < target){
                sum += arr[second];
                second++;
            }
            else if(sum > target){
                sum -= arr[first];
                first++;
            }
            else{
                max = Math.max(max, second - first);
                sum += arr[second];
                second++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubarraySumK obj = new LongestSubarraySumK();
        int [] arr = {10, 5, 2, 7, 1, 9};
        int target = 15;
        int result1 = obj.longestSubarray1(arr, target);
        int result2 = obj.subArray2(arr, target);
        System.out.println("Length of the longest subarray with sum " + target + " is: " + result2);
    }
}
