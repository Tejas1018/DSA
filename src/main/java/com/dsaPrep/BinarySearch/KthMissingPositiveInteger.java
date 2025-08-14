package com.dsaPrep.BinarySearch;

public class KthMissingPositiveInteger {
    public int findKthPositive(int[] arr, int k) {
        int length = arr.length;
        for(int i = 0 ; i < length; i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
}
