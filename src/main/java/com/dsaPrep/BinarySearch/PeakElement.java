package com.dsaPrep.BinarySearch;

public class PeakElement {
    //TC : O(log n) || Space : O(1)
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if(length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[length-1] > nums[length-2]) return length-1;

        int left = 1;
        int right = length-2;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            else if(nums[mid-1] > nums[mid]){
                right = mid-1;
            }
            else if(nums[mid+1] > nums[mid]){
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PeakElement peakElement = new PeakElement();
        int[] nums1 = {1, 2, 3, 1};
        int result1 = peakElement.findPeakElement(nums1);
        System.out.println("Peak element found at index: " + result1);

    }
}
