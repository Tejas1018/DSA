package com.dsaPrep.Arrays;
//Given a non-empty array of integers nums, every element appears twice except for one.
// Find that single one.

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ele = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            ele = ele ^ nums[i];
        }
        return ele;
    }

    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println("The single number is: " + obj.singleNumber(arr));
    }
}
