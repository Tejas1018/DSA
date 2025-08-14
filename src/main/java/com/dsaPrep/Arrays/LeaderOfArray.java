package com.dsaPrep.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderOfArray {
    // TC O(n^2) | SC O(n)
    public ArrayList<Integer> leaders(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> result = new ArrayList<>();

        result.add(nums[len-1]);    // Last element is always a leader
        for(int i = len-2; i >= 0 ; i--){
            int ele = nums[i];
            int k = i;
            while(k < len){
                if(nums[k] > ele){
                    break;
                }
                k++;
                if(k == len-1 && nums[k] < ele){
                    result.add(nums[i]);
                }
            }

        }
        Collections.reverse(result);
        return result;
    }

    // Optimized TC O(n) | SC O(n)
    public ArrayList<Integer> leader(int nums[]){
        int len = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(nums[len-1]); // Last element is always a leader
        int maxEle = nums[len-1];
        for(int i = len-2; i >= 0 ; i--){
            if(nums[i] > maxEle){
                result.add(nums[i]);
                maxEle = nums[i];
            }
        }
        Collections.reverse(result);
        return  result;
    }
    public static void main(String[] args) {
        LeaderOfArray leaderOfArray = new LeaderOfArray();
        int[] nums = {1, 2, 5, 3, 1, 2};               //{-3, 4, 5, 1, -4, -5};
        ArrayList<Integer> leaders = leaderOfArray.leaders(nums);
        System.out.println("Leaders in the array: " + leaders);
    }
}
