package com.dsaPrep.BinarySearch;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }

        if(nums[0] != nums[1]) return nums[0];
        if(nums[length-1] != nums[length-2]) return nums[length-1];

        int left = 1;
        int right = length-2;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            if((mid%2 == 1) && nums[mid] == nums[mid-1] || ((mid%2==0) && nums[mid] == nums[mid+1])){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SingleElementInSortedArray singleElementInSortedArray = new SingleElementInSortedArray();
        int[] nums1 = {1, 1, 2, 2, 3};
        int result1 = singleElementInSortedArray.singleNonDuplicate(nums1);
        System.out.println("Single non-duplicate element in nums1: " + result1); // Output: 3
    }
}
