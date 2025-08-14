package com.dsaPrep.BinarySearch;

public class UpperBound {
    int upperBound(int[] nums, int x) {
        int length = nums.length;
        int result = -1;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > x) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] <= x) {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        UpperBound upperBound = new UpperBound();
        int[] nums = {1, 2, 2, 3};
        int x = 2;
        int result = upperBound.upperBound(nums, x);
        if (result != -1) {
            System.out.println("Upper bound of " + x + " is at index: " + result);
        } else {
            System.out.println("Upper bound not found for " + x);
        }
    }
}
