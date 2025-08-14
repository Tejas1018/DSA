package com.dsaPrep.Arrays;

public class MaxSubarray {
    // Function to find the maximum subarray sum using Kadane's algorithm
    // TC : O(n) for iterating through the array
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0 ; i < len; i++){
            currSum += nums[i];
            maxSum = Math.max(maxSum,currSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarray obj = new MaxSubarray();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + obj.maxSubArray(arr));
    }
}
