package com.dsaPrep.Arrays;

import java.util.Arrays;

public class MoveZerosToEnd {

    public int[] moveZeroes(int[] nums) {
        int len = nums.length;
        int l = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
            }
            l++;
        }
        return  nums;
    }

    public static void main(String[] args) {
        MoveZerosToEnd obj = new MoveZerosToEnd();
        int[] arr = {2,1};
        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        obj.moveZeroes(arr);
        System.out.print("Array after moving zeros to the end: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
