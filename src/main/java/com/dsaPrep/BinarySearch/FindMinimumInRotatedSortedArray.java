package com.dsaPrep.BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length-1;
        int minElement = Integer.MAX_VALUE;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[left] <= nums[mid]){
                minElement = Math.min(minElement,nums[left]);
                left = mid+1;
            }
            else{
                minElement = Math.min(minElement,nums[mid]);
                right = mid-1;
            }
        }
        return minElement;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int[] nums = {3, 4, 5, 1, 2};
        int result = findMinimumInRotatedSortedArray.findMin(nums);
        System.out.println("The minimum element in the rotated sorted array is: " + result); // Output: 1

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        result = findMinimumInRotatedSortedArray.findMin(nums);
        System.out.println("The minimum element in the rotated sorted array is: " + result); // Output: 0
    }
}
