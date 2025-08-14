package com.dsaPrep.Arrays;

public class SortColours {
    // Sort an array containing 0s, 1s, and 2s in a single pass
    // This is a variation of the Dutch National Flag problem
    // TC : O(n) for iterating through the array
    // SC : O(1) for using constant space
    public void sortColors(int[] nums) {
        int len = nums.length;
        //  un-sorted array
        for(int i = 1; i < len; i++){
            int j = i-1;    //sorted sub-array
            int temp = nums[i];
            while(j >= 0 && nums[j] > temp){
                nums[j+1] = nums[j];    //shift the greater ele to the right
                j--;
            }
            nums[j+1] = temp;   //shift the ele to its correct place
        }
    }

    public static void main(String[] args) {
        SortColours obj = new SortColours();
        int[] arr = {2, 0, 2, 1, 1, 0};
        obj.sortColors(arr);
        System.out.print("Sorted array: ");
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
