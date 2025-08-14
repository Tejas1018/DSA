package com.dsaPrep.BinarySearch;

public class MinDaysToMakeBoquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int length = bloomDay.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < length; i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }
        if(m*k > length) return -1;
        int left = min;
        int right = max;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canMake(bloomDay,mid,m,k)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    boolean canMake(int bloomDay[],int days,int boquets,int adjacentFlowers){
        long noOfBoquets = 0;
        long count = 0;
        for(int i = 0 ; i < bloomDay.length; i++){
            if(bloomDay[i] <= days){
                count++;
            }
            else{
                noOfBoquets += (count/adjacentFlowers);
                count = 0;
            }
        }
        noOfBoquets += (count / adjacentFlowers);
        return noOfBoquets >= boquets;

    }
}
