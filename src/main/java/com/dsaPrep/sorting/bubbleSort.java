package com.dsaPrep.sorting;

// TC : O(N^2)
// SC : O(1) (In-place sorting)
public class bubbleSort {
    public int[] bubbleSort(int[] nums) {
        int len = nums.length;
        int count = 0;

        while(count < len-1){
            int p1 = 0;
            int p2 = 1;
            while(p1 < p2 && p2 < len){
                if(nums[p2] < nums[p1]){
                    //swap
                    int temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] = temp;
                }
                p1++;
                p2++;
            }
            count++;
        }
        return nums;
    }

    public static void main(String[] args) {
        bubbleSort obj = new bubbleSort();
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] sortedArr = obj.bubbleSort(arr);
        for(int i : sortedArr){
            System.out.print(i + " ");
        }
    }
}
