package com.dsaPrep.BinarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int index = -1;
        int left = 0;
        int right = length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }

        }
        return index;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = searchInRotatedSortedArray.search(nums, target);
        System.out.println("Target " + target + " found at index: " + result);

        target = 3;
        result = searchInRotatedSortedArray.search(nums, target);
        System.out.println("Target " + target + " found at index: " + result);
    }
}
