package com.dsaPrep.Arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenXORSumstoTarget {

    //TC : O(n^2) || Space : O(1)    || ---Brute Force Approach---
    int countSubarraysWithSumXOR(int[] arr, int target) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int xorSum = 0;
            for (int j = i; j < n; j++) {
                xorSum ^= arr[j];
                if (xorSum == target) {
                    count++;
                }
            }
        }
        return count;
    }


    //TC : O(n) || Space : O(n)    || ---Optimized Approach---
    int countSubarraysWithSumXOR2(int[] arr, int target) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1); // To handle the case when subarray starts from index 0
        int xor = 0;

        for (int i = 0; i < len; i++) {
            xor ^= arr[i]; // Calculate the cumulative XOR up to the current index
            if (map.containsKey(xor ^ target)) {
                count += map.get(xor ^ target);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWithGivenXORSumstoTarget obj = new CountSubarraysWithGivenXORSumstoTarget();
        int[] arr = {5, 6, 7, 8, 9};
        int target = 5;
        System.out.println("Count of subarrays with XOR sum equal to " + target + ": " + obj.countSubarraysWithSumXOR2(arr, target));
    }
}
