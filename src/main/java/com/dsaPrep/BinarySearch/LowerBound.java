package com.dsaPrep.BinarySearch;

public class LowerBound {
    // TC : O(log n) || Space : O(1)
    public int lowerBound(int[] nums, int x) {
        int length = nums.length;
        int result = -1;
        int left = 0;
        int right = length-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] >= x){
                result = mid;
                right = mid-1;
            }
            else if(nums[mid] < x){
                left = mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LowerBound lowerBound = new LowerBound();
        int[] nums = {1,2,2,3};
        int x = 2;
        int result = lowerBound.lowerBound(nums, x);
        if(result != -1) {
            System.out.println("Lower bound of " + x + " is at index: " + result);
        } else {
            System.out.println("Lower bound not found for " + x);
        }
    }
}
