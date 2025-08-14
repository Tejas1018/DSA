package com.dsaPrep.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int length = stalls.length;
        int min = stalls[0];
        int max = stalls[length-1];
        int result = 0;
        int left = 1;
        int right = (max-min);
        while(left <= right){
            int mid = (left+right)/2;
            if(canPlace(stalls,mid,k)){
                result = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return result;
    }

    static boolean canPlace(int stalls[],int targetDistance,int cows){
        int cowsPlaced = 1;
        int lastCowPlaced = stalls[0];
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - lastCowPlaced >= targetDistance){
                cowsPlaced++;
                lastCowPlaced = stalls[i];
            }
        }
        return cowsPlaced >= cows;
    }

}
