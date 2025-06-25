package com.dsaPrep.sorting;

public class mergeSort {

    int []mergesort(int arr[]){
        int len = arr.length;
        return merging(arr,0,len-1);
    }
    int[] merging(int[] arr, int start, int end) {
        if (start >= end) {
            return new int[]{arr[start]};
        }
        int mid = (start + end) / 2;
        int[] left = merging(arr, start, mid);
        int[] right = merging(arr, mid + 1, end);
        return merge(left, right);
    }
    int[]merge(int[] left,int[] right){
        int i = 0, j = 0, k = 0;
        int[] merged = new int[left.length + right.length];
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                merged[k++] = left[i++];
            }
            else{
                merged[k++] = right[j++];
            }
        }
        while(i < left.length){
            merged[k++] = left[i++];
        }
        while(j < right.length){
            merged[k++] = right[j++];
        }
        return merged;
    }

    public static void main(String[] args) {
        mergeSort obj = new mergeSort();
        int arr[] = {5, 2, 9, 1, 5, 6,32,12,12,34,5,6,7,8,43,21};
        int sortedArr[] = obj.mergesort(arr);
        for(int i : sortedArr){
            System.out.print(i + " ");
        }
    }
}
