package com.dsaPrep.sorting;

// TC : O(N^2)

public class selectionSort {
    int[] insertionSort(int arr[]){
        int len = arr.length;
        for(int i = 0; i < len-1; i++){
            //Get the min ele from unsorted arr of subarray 'j'
            int min_index = i;
            for(int j = i+1; j < len; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j; //update the min index
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp; //swap the min element with the first element of unsorted subarray
        }
        return arr; //return the sorted array
    }
    public static void main(String[] args) {
        selectionSort obj = new selectionSort();
        int arr[] = {5, 2, 9, 1, 5, 6};
        int sortedArr[] = obj.insertionSort(arr);
        for(int i : sortedArr){
            System.out.print(i + " ");
        }
    }
}
