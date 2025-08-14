package com.dsaPrep.BinarySearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int index = length;
        int left = 0;
        int right = length-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                index = mid;
                right = mid-1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = searchInsertPosition.searchInsert(nums, target);
        System.out.println("Target " + target + " should be inserted at index: " + result);

        target = 2;
        result = searchInsertPosition.searchInsert(nums, target);
        System.out.println("Target " + target + " should be inserted at index: " + result);

        target = 7;
        result = searchInsertPosition.searchInsert(nums, target);
        System.out.println("Target " + target + " should be inserted at index: " + result);

        target = 0;
        result = searchInsertPosition.searchInsert(nums, target);
        System.out.println("Target " + target + " should be inserted at index: " + result);
    }
}
