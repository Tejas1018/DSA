package com.dsaPrep.sorting;

public class insertionSort {
    int[] insertion(int arr[]){
        int len = arr.length;
        for(int i = 1; i < len; i++){
            int temp = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j]; //shift the larger element to the right
                j--; //move to the left
            }
            arr[j+1] = temp; //insert the temp element at the correct position
        }
        return arr;
    }

    public static void main(String[] args) {
        insertionSort obj = new insertionSort();
        int arr[] = {5, 2, 9, 1, 5, 6};
        int sortedArr[] = obj.insertion(arr);
        for(int i : sortedArr){
            System.out.print(i + " ");
        }
    }
}
