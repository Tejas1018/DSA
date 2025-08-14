package com.dsaPrep.BinarySearch;

public class SearchInARotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid]){
                left++;
                continue;
            }

            if(nums[left] < nums[mid]){
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
        return false;
    }

    public static void main(String[] args) {
        SearchInARotatedSortedArrayII searchInARotatedSortedArrayII = new SearchInARotatedSortedArrayII();
        int[] nums1 = {2,5,6,0,0,1,2};
        int target1 = 0;
        boolean result1 = searchInARotatedSortedArrayII.search(nums1, target1);
        System.out.println("Target " + target1 + " found: " + result1); // Output: true

    }
}
