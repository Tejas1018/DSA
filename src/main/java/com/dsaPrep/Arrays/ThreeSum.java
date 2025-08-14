package com.dsaPrep.Arrays;

import java.util.*;

public class ThreeSum {

    //--leetcode : https://leetcode.com/problems/3sum/
    // TC : O(n^3) || Space : O(1)    || ---Brute Force Approach---
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // To handle duplicates
                        resultSet.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(resultSet);

    }

    // TC : O(n^2) || Space : O(n)    || ---Better Approach---
    public List<List<Integer>> threeSum1(int[] nums) {
        int len = nums.length;
        Set<List<Integer>> resultSet = new HashSet<>();

        for(int i = 0 ; i < len; i++){
            Set<Integer> tripletSet = new HashSet<>();
            for(int j = i+1; j < len; j++){
                if(tripletSet.contains(-(nums[i]+nums[j]))){
                    List<Integer> triplets = Arrays.asList(nums[i],nums[j],-(nums[i]+nums[j]));
                    Collections.sort(triplets);
                    resultSet.add(triplets);
                }
                tripletSet.add(nums[j]);
            }
        }

        return new ArrayList<>(resultSet);
    }

    // TC : O(n^2) || Space : O(1)    || ---Optimized Approach---
    public List<List<Integer>> threeSum3(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> totalTriplets = new ArrayList<>();
        for(int i = 0 ; i < len-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = len-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum > 0){
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    //Equals to zero
                    List<Integer> triplets = Arrays.asList(nums[i],nums[j],nums[k]);
                    totalTriplets.add(triplets);
                    j++;
                    k--;
                    while(j < len-2 && nums[j] == nums[j-1]) j++;    //Goes to non prev element
                    while(k > j && nums[k] == nums[k+1]) k--;    //Goes to non prev element
                }
            }
        }
        return totalTriplets;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum3(nums);
        System.out.println(result); // Output: [[-1, -1, 2], [-1, 0, 1]]
    }
}
