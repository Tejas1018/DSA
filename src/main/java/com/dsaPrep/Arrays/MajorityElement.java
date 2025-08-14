package com.dsaPrep.Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    // ----Brute Force Approach----
    // TC : O(n^2) for iterating through all pairs
    // SC : O(1) for using constant space
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        //  store the freq. of the ele
        for(int i = 0 ; i < len; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        // ge the freq. and find maj.ele
        int majEle = 0;
        for(int i = 0 ; i < len; i++){
            int freq = map.get(nums[i]);
            if(freq > (len/2)){
                majEle = nums[i];
            }
        }
        return majEle;
    }

    // ----Optimized Approach using Boyer-Moore Voting Algorithm----
    // TC : O(n) for iterating through the array
    // SC : O(1) for using constant space
    public int majorityElement1(int[] nums) {
        int len = nums.length;
        int majElement = majority(nums);
        int freq = 0;
        for(int i = 0 ; i < len; i++){
            if(nums[i] == majElement){
                freq++;
            }
        }
        // cal. freq of the maj. element and return
        if(freq > (len/2)){
            return majElement;
        }
        return majElement;
    }
    // Find the majority element form the array
    int majority(int nums[]){
        int len = nums.length;
        int ele = nums[0];
        int count = 1;
        int i = 1;
        while(i < len){
            if(nums[i] == ele){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                ele = nums[i];
                count = 1;
            }
            i++;
        }
        return ele;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] arr = {3, 2, 3};
        int result = obj.majorityElement1(arr);
        System.out.println("Majority Element: " + result);
    }
}
