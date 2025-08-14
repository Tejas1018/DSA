package com.dsaPrep.BinarySearch;

public class NoTimesArrayIsSorted {
    int noOfTimes(int arr[]){
        int length = arr.length;
        int left = 0;
        int right = length-1;
        int minElement = Integer.MAX_VALUE;
        int index = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[left] <= arr[right]){
                if(arr[left] <= minElement){
                    minElement = arr[left];
                    index = left;
                    break;
                }
            }
            if(arr[left] <= arr[mid]){
                if(arr[left] < minElement){
                    minElement = arr[left];
                    index = left;
                }
                left = mid+1;
            }
            else{
                if(arr[mid] < minElement){
                    minElement = arr[mid];
                    index = mid;
                }
                right = mid-1;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        NoTimesArrayIsSorted noTimesArrayIsSorted = new NoTimesArrayIsSorted();
        int[] arr = { 4, 5,6,7,8,9,10,0, 1, 2};
        int result = noTimesArrayIsSorted.noOfTimes(arr);
        System.out.println("The array is sorted " + result + " times.");

    }
}


          /* if(left != mid && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                index = mid;
                break;
            }
            else if(arr[left] <= arr[mid]){
                if(arr[left] < arr[right]){
                    return 0; // Array is already sorted
                }
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return index+1;*/