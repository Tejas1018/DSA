package com.dsaPrep.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    // Given an integer array nums, return the number of reverse pairs in the array.
    //TC : O(n log n) --Using Merge Sort
    //SC : O(n) --Auxiliary space for merge operation
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    int mergeSort(int[] arr, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int count = mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right);
        count += countPairs(arr, left, mid, right);
        merge(arr, left, mid, right);
        return count;
    }

    int countPairs(int[] arr, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long)arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }

    void merge(int[] arr, int left, int mid, int right) {
        List<Integer> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);
            }
        }
        while (i <= mid) temp.add(arr[i++]);
        while (j <= right) temp.add(arr[j++]);
        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }

    public static void main(String[] args) {
        ReversePairs rp = new ReversePairs();
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println("Number of Reverse Pairs: " + rp.reversePairs(nums)); // Output: 2
    }
}
