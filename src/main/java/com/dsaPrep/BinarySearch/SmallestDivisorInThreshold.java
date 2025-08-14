package com.dsaPrep.BinarySearch;

public class SmallestDivisorInThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < length; i++){
            max = Math.max(max,nums[i]);
        }
        int left = 1;
        int right = max;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canDivide(nums,mid,threshold)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    boolean canDivide(int[] nums, int index, int threshold) {
        long divisor = 0;
        for (int num : nums) {
            divisor += (num + index - 1l) / index;
        }
        return (int)divisor <= threshold;
    }
}
