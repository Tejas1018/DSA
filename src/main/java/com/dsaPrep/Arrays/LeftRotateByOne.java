package com.dsaPrep.Arrays;

public class LeftRotateByOne {
    // TC : O(N)
    // SC : O(1) (In-place rotation)
    public void rotation(int arr[]){
        int len = arr.length;
        int temp = arr[0];
        for(int i = 1; i < len; i++){
            arr[i-1] = arr[i];
        }
        arr[len-1] = temp;
    }

    public static void main(String[] args) {
        LeftRotateByOne  obj = new LeftRotateByOne();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Original Array: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        obj.rotation(arr);
        System.out.print("Array after left rotation by one: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }

    }
}
