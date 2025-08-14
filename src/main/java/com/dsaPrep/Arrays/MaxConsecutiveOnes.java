package com.dsaPrep.Arrays;

public class MaxConsecutiveOnes {

    int maxOnes(int ar[]){
        int len = ar.length;
        int count = 0;
        int max = 0;
        for(int i = 0 ; i < len; i++){
            if(ar[i] == 1){
                count++;
                max = Math.max(max,count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        int[] arr = {1, 1, 0, 1, 1, 1,0,1,1,1,1,1};
        System.out.println("Maximum consecutive ones: " + obj.maxOnes(arr));
    }
}
