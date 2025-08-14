package com.dsaPrep.BinarySearch;

public class Floor {
    static int findFloor(int[] arr, int x) {
        // write code here
        int length = arr.length;
        int index = -1;

        int left = 0;
        int right = length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] <= x){
                index = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        int result = findFloor(arr, x);
        if (result != -1) {
            System.out.println("Floor of " + x + " is at index: " + result);
        } else {
            System.out.println("Floor not found for " + x);
        }
    }
}
