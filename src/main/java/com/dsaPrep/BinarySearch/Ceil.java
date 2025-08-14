package com.dsaPrep.BinarySearch;

public class Ceil {

    public int findCeil(int[] arr, int x) {
        // code here
        int length = arr.length;
        int index = -1;

        int left = 0;
        int right = length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] < x){
                left = mid+1;
            }
            else if(arr[mid] >= x){
                index = mid;
                right = mid-1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Ceil ceil = new Ceil();
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        int result = ceil.findCeil(arr, x);
        if (result != -1) {
            System.out.println("Ceil of " + x + " is at index: " + result);
        } else {
            System.out.println("Ceil not found for " + x);
        }
    }
}
