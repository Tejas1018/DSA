package com.dsaPrep.Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    // LeetCode 560 - Subarray Sum Equals K
    // https://leetcode.com/problems/subarray-sum-equals-k/
    //--Brute Force Approach--
    // TC O(n^3) | SC O(1)
    public int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 0;
                for(int p = i; p <= j; p++){
                    sum += nums[p];
                }
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    //--Better Approach--
    // TC O(n^2) | SC O(1)
    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0 ; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    //--Optimal Approach--
    // TC O(n) | SC O(n)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            prefixSum += nums[i];
            int remaining = prefixSum - k;
            if(map.containsKey(remaining)){
                count += map.get(remaining);
            }

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);

        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        int count = subArraySumEqualsK.subarraySum(nums, k);
        System.out.println("Number of subarrays with sum equals to " + k + ": " + count);
    }
}
