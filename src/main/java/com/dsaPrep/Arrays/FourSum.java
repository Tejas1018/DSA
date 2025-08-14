package com.dsaPrep.Arrays;

import java.util.*;

public class FourSum {

    //leetcode : https://leetcode.com/problems/4sum/
    // TC : O(n^4) || Space : O(1)    || ---Brute Force Approach---
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Set<List<Integer>> qudSet = new HashSet<>();

        for(int i = 0 ; i < len; i++){
            Set<Integer> quadraples = new HashSet<>();
            for(int j = i+1; j < len; j++){
                for(int k = j+1; k < len; k++){
                    for(int l = k+1; l < len; l++){
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                            List<Integer> ele = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                            Collections.sort(ele);
                            qudSet.add(ele);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(qudSet);
    }

    // TC : O(n^3) || Space : O(n)    || ---Better Approach---
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        int len = nums.length;
        Set<List<Integer>> qudSet = new HashSet<>();
        for(int i = 0 ; i < len; i++){
            Set<Integer> quadraples = new HashSet<>();
            for(int j = i+1; j < len; j++){
                for(int k = j+1; k < len; k++){
                    if(quadraples.contains(target - (nums[i] + nums[j] + nums[k]))){
                        List<Integer> ele = Arrays.asList(nums[i],nums[j],nums[k],target - (nums[i] + nums[j] + nums[k]));
                        Collections.sort(ele);
                        qudSet.add(ele);
                    }
                    quadraples.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(qudSet);
    }

    // TC : O(n^3) || Space : O(1)    || ---Optimized Approach---
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < len; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < len; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = len-1;
                while(k < l){
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum < target)   k++;
                    else if(sum > target)   l--;
                    else{
                        //equals to target
                        List<Integer> quadrples = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(quadrples);

                        k++;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        l--;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum.fourSum2(nums, target);
        System.out.println(result); // Expected output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }
}
