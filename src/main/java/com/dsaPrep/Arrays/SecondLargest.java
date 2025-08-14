package com.dsaPrep.Arrays;

public class SecondLargest {

    int second(int arr[]){
        int len = arr.length;
        int first = arr[0];
        int second = -1;
        for(int i = 1; i < len; i++){
            if(arr[i] > first){
                second = first;
                first = arr[i];
            }
            else if(arr[i] < first && arr[i] > second){
                second = arr[i];
            }
        }
        return second; // Return -1 if no second largest element exists
    }

    public static void main(String[] args) {
        SecondLargest obj = new SecondLargest();
        int[] arr = {12, 35, 1, 10, 34, 1};
        int secondLargest = obj.second(arr);
        if (secondLargest != -1) {
            System.out.println("The second largest element is: " + secondLargest);
        } else {
            System.out.println("There is no second largest element.");
        }
    }
}
