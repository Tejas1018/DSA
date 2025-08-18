package com.dsaPrep.Recursion;

import java.util.ArrayList;

public class subsetsSum {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        countSubsetSums(arr,0,0,result);
        return result;
    }

    void countSubsetSums(int arr[],int index, int sum, ArrayList<Integer> result){
        if(index == arr.length){
            result.add(sum);
            return;
        }
        countSubsetSums(arr,index+1,sum,result);
        countSubsetSums(arr,index+1,sum + arr[index],result);
        sum = sum - arr[index]; // back tracking
    }
}
