package com.dsaPrep.Arrays;

public class RishShiftByKtimes {

    void rightShift(int arr[], int k) {
        int len = arr.length;
        k = k % len; // Handle cases where k is greater than array length
        reverse(arr, 0, len - 1); // Reverse the entire array
        reverse(arr, 0, k - 1); // Reverse the first k elements
        reverse(arr, k, len - 1); // Reverse the remaining elements
    }
    void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RishShiftByKtimes obj = new RishShiftByKtimes();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2; // Number of positions to shift
        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        obj.rightShift(arr, k);
        System.out.print("Array after right shift by " + k + " positions: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
