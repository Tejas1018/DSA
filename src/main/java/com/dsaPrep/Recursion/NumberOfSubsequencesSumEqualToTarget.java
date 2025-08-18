package com.dsaPrep.Recursion;

import java.util.Arrays;

public class NumberOfSubsequencesSumEqualToTarget {
    public int numSubseq(int[] nums, int target) {
        int length = nums.length;
        int mod = 1000000007;
        int power[] = new int[length];
        power[0] = 1;
        for(int i = 1; i < length; i++){
            power[i] = (power[i-1] * 2)%mod;
        }

        int count = 0;
        // 1. sort the array
        Arrays.sort(nums);

        // 2. l = 0, r = length-1

        int left = 0;
        int right = length-1;

        while(left <= right){
            if(nums[left] + nums[right] <= target){
                int difference = right - left;
                count = (count%mod) + (power[difference] % mod);
                left++;
            }
            else{
                right--;
            }
        }

        return count % mod;
    }
}
