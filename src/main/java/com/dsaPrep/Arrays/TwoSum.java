package com.dsaPrep.Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // ----Brute Force Approach----
    // TC : O(n^2) for iterating through all pairs
    // SC : O(1) for using constant space
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int count[] = new int[2];
        for(int i = 0 ; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(nums[i]+nums[j] == target){
                    count[0] = i;
                    count[1] = j;
                    break;
                }
            }
        }
        return count;
    }

    // ----Optimized Approach using HashMap----
    // TC : O(n) for iterating through the array
    // SC : O(n) for using a HashMap to store the elements

    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        int count[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //  <key,value> -> <ele,index>

        for(int i = 0 ; i < len; i++){
            if(map.containsKey(target-nums[i])){
                count[0] = map.get(target-nums[i]);
                count[1] = i;
                break;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = obj.twoSum1(arr, target);
        System.out.println("Indices of the two numbers that add up to " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}
