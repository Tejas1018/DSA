package com.dsaPrep.Arrays;

import java.util.ArrayList;

public class CountInversions {

    // Given an array of integers, return the number of inversions in the array.
    //TC : O(n^2) --Brute force approach
    static int inversionCount(int arr[]) {
        // Your Code Here
        int len = arr.length;
        int count = 0;
        for(int i = 0 ; i < len; i++){
            for(int j = i+1; j < len;j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }

    //TC : O(n log n) --Using Merge Sort
    static int inversionCount1(int arr[]) {
        return mergeSort(arr,0,arr.length-1);
    }

    static int mergeSort(int arr[],int left,int right){
        int count = 0;
        if(left >= right) return count;
        int mid = (left+right)/2;
        count += mergeSort(arr,left,mid);
        count += mergeSort(arr,mid+1,right);
        count += merge(arr,left,mid,right);
        return count;
    }

    static int merge(int arr[],int left,int mid,int right){
        int l = left;
        int r = mid+1;
        int count = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while(l <= mid && r <= right){
            if(arr[l] <= arr[r]){
                temp.add(arr[l]);
                l++;
            }
            else{
                count += (mid - l + 1);
                temp.add(arr[r]);
                r++;
            }
        }
        while(l <= mid){
            temp.add(arr[l]);
            l++;
        }
        while(r <= right){
            temp.add(arr[r]);
            r++;
        }

        for(int i = left,k = 0; i <= right; i++,k++){
            arr[i] = temp.get(k);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 6};
        System.out.println("Number of Inversions (Brute Force): " + inversionCount(arr)); // Output: 3
        System.out.println("Number of Inversions (Merge Sort): " + inversionCount1(arr)); // Output: 3
    }
}
