package com.dsaPrep.BinarySearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int indexes[] = new int[2];
        Arrays.fill(indexes,-1);

        int left = 0;
        int right = length-1;
        while(left <= right){
            int mid = left + (right-left)/2;

            //Find starting position
            if(nums[mid] == target){
                indexes[0] = mid;
                right = mid-1;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        //reset the pointer
        left = 0;
        right = length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            //finding ending position
            if(nums[mid] == target){
                indexes[1] = mid;
                left = mid+1;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }

        }
        return indexes;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElement finder = new FindFirstAndLastPositionOfElement();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = finder.searchRange(nums, target);
        System.out.println("First and last position of " + target + " is: " + Arrays.toString(result));

        target = 6;
        result = finder.searchRange(nums, target);
        System.out.println("First and last position of " + target + " is: " + Arrays.toString(result));
    }
}
