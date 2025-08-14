package com.dsaPrep.Arrays;

public class NextPermutations {
    //LeetCode Problem: https://leetcode.com/problems/next-permutation/
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        //longest prefix
        int index = -1;
        //longest prefix is the largest index i such that nums[i] < nums[i + 1]
        for(int i = len - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            reverse(nums, 0, len - 1);
            return; // Added return to exit after reversing the whole array
        }

        //find nearest greater ele to nums[index]
        for(int i = len - 1; i > index; i--){
            if(nums[i] > nums[index]){
                // Call the corrected swap method with the array and indices
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index + 1, len - 1);
    }

    // Corrected reverse method (already correct, but included for completeness)
    void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Corrected swap method: takes the array and two indices
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutations obj = new NextPermutations();
        int[] arr = {1, 2, 3};
        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        obj.nextPermutation(arr);
        System.out.print("Next Permutation: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
