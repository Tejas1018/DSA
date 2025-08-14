package com.dsaPrep.Arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    //leetcode : https://leetcode.com/problems/merge-sorted-array/
    // TC : O(nlogn) || Space : O(1)    || ---Brute Force Approach---
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i = 0 ; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int p1 = 0;
        for(int i = m; i < m+n; i++){
            nums1[i] = nums2[p1++];
        }
        Arrays.sort(nums1);
    }

    // TC : O(n) || Space : O(1)    || ---Optimized Approach---
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int k = m+n-1;

        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[k] = nums1[p1];
                k--;
                p1--;
            }
            else{
                nums1[k] = nums2[p2];
                p2--;
                k--;
            }
        }

        while(p2 >= 0){
            nums1[k] = nums2[p2];
            k--;
            p2--;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0}; //{1,2,3,0,0,0};
        int[] nums2 = {2, 5, 6}; //{2,5,6};
        int m = 3; // Length of nums1 excluding zeros
        int n = 3; // Length of nums2

        mergeTwoSortedArrays.merge1(nums1, m, nums2, n);
        System.out.println("Merged Array: " + Arrays.toString(nums1));
    }

}
