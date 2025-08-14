package com.dsaPrep.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    //leetcode : https://leetcode.com/problems/majority-element-ii/

    // TC : O(n^2) || Space : O(1)    || ---Brute Force Approach---
    public List<Integer> majorityElement1(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        List<Integer> processed = new ArrayList<>();
        for(int i = 0 ; i < len; i++){
            int ele = nums[i];
            if(processed.contains(ele))   continue;
            int count = 0;
            for(int j = 0 ; j < len; j++){
                if(nums[j] == ele){
                    count++;
                }

            }
            if(count > (len/3)){
                ans.add(ele);
                processed.add(ele);
            }
        }
        return ans;
    }

    // TC : O(n) || Space : O(n)    || ---HashMap Approach---
    public List<Integer> majorityElement2(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < len; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if((entry.getValue()) > (len/3)){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    // TC : O(n) || Space : O(1)    || ---Optimized Approach---
    // Boyer-Moore Voting Algorithm
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for(int i = 0 ; i < len; i++){
            if(count1 == 0 && nums[i] != ele2){
                count1 = 1;
                ele1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != ele1){
                count2 = 1;
                ele2 = nums[i];
            }
            else if(ele1 == nums[i]) count1++;
            else if(ele2 == nums[i])  count2++;
            else{
                count1--;
                count2--;
            }
        }
        //Manual check if those maj. ele are > n/3
        count1 = 0;
        count2 = 0;
        for(int i = 0 ; i < len; i++){
            if(nums[i] == ele1) count1++;
            if(nums[i] == ele2) count2++;
        }
        if(count1  > (len/3)) ans.add(ele1);
        if(count2 > (len/3)) ans.add(ele2);
        return ans;
    }

    public static void main(String[] args) {
        MajorityElement2 obj = new MajorityElement2();

        int[] nums3 = {1,1,1,2,2,3,3,3,6,6,6};
        System.out.println(obj.majorityElement(nums3)); // Output: [1, 2]
    }
}
