package com.dsaPrep.Arrays;

public class RearrangeArrayBySigns {
    //-- Approach: Two Pointer Technique
    // TC: O(n) for iterating through the array
    // SC: O(n) for using additional space for the result array
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int result[] = new int[len];
        int pos  = 0;
        int neg = 0;
        int even[] = new int[len/2];
        int odd[] = new int[len/2];
        for(int ele : nums){
            if(ele > 0){
                even[pos++] = ele;
            }
            else{
                odd[neg++] = ele;
            }
        }

        int i = 0;
        int p = 0;
        int n = 0;
        while(i < len){
            result[i++] = even[p++];
            result[i++] = odd[n++];
        }
        return result;
    }
    //-- Approach: Two Pointer Technique with Separate Arrays for Positive and Negative Numbers
    // TC: O(n) for iterating through the array
    // SC: O(n) for using additional space for the result array
    public int[] rearrangeArray1(int[] nums) {
        int len = nums.length;
        int result[] = new int[len];
        int pos = 0;
        int neg = 0;
        int even[] = new int[len / 2];
        int odd[] = new int[len / 2];
        for (int ele : nums) {
            if (ele > 0) {
                even[pos++] = ele;
            } else {
                odd[neg++] = ele;
            }
        }

        int i = 0;
        int p = 0;
        int n = 0;
        while (i < len) {
            result[i++] = even[p++];
            result[i++] = odd[n++];
        }
        return result;
    }

    public static void main(String[] args) {
        RearrangeArrayBySigns obj = new RearrangeArrayBySigns();
        int[] arr = {3, -2, 1, -5, 2, -4};
        int[] result = obj.rearrangeArray(arr);
        System.out.print("Rearranged Array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
