package com.dsaPrep.Arrays;

public class MaximumSubarrayProduct {
    // Given an integer array nums, find the contiguous subarray within an array
    // (containing at least one number) which has the largest product.

    //TC : O(n^2) --Brute force approach
    //SC : O(1)
    public int maxProduct1(int[] nums) {
        int length = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for(int i = 0 ; i < length; i++){
            int product = 1;
            for(int j = i ; j < length; j++){
                product = product * nums[j];
                maxProduct = Math.max(maxProduct,product);
            }
        }
        return maxProduct;
    }
    //TC: O(n) --Optimized approach
    //SC: O(1)
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;
        for(int i = 0 ; i < len; i++){
            if(prefix  == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }

            prefix = prefix * nums[i];
            suffix = suffix * nums[len-i-1];
            max = Math.max(max,Math.max(prefix,suffix));
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarrayProduct msp = new MaximumSubarrayProduct();
        int[] nums = {2,3,-2,4};
        System.out.println("Maximum Subarray Product: " + msp.maxProduct(nums)); // Output: 6
        System.out.println("Maximum Subarray Product (Brute Force): " + msp.maxProduct1(nums)); // Output: 6
    }
}
