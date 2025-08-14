package com.dsaPrep.BinarySearch;

public class CapacityToShipPackages {
    //TC : O(n*m) where n is the number of weights and m is the total weight
    public int shipWithinDays(int[] weights, int days) {
        int length = weights.length;
        int totalWeight = 0;
        for(int i = 0 ; i < length; i++){
            totalWeight += weights[i];
        }

        int index = -1;
        for(int i = 1; i <= totalWeight; i++){
            if(canShip(weights,i,days)){
                index = i;
                break;
            }
        }
        return index;
    }
    //TC : O(n) where n is the number of weights
    public int shipWithinDays1(int[] weights, int days) {
        int length = weights.length;
        int totalWeight = 0;
        for(int i = 0 ; i < length; i++){
            totalWeight += weights[i];
        }

        int index = -1;
        int left = 1;
        int right = totalWeight;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canShip(weights,mid,days)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    boolean canShip(int weights[],int target,int days){
        int count = 1;
        int totalWeight = 0;
        for(int weight : weights){
            if(weight > target){
                return false;
            }
            if(weight + totalWeight > target){
                count++;
                totalWeight = weight;
            }
            else{
                totalWeight += weight;
            }
        }
        return count <= days;
    }
}
