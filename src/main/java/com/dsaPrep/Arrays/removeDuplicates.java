package com.dsaPrep.Arrays;

import java.util.HashSet;
import java.util.Set;

public class removeDuplicates {
    //--------BRUTEFORCE APPROACH--------
    // TC : O(N)
    // SC : O(N) (Using HashSet to store unique elements)
/*    int duplicates(int arr[]){
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(arr[i]);
        }
        return set.size();
    }*/
    //--------OPTIMIZED APPROACH--------
    // TC : O(N)
    // SC : O(1) (In-place counting of unique elements)
    int duplicates(int arr[]){
        int len = arr.length;
        int p1 = 0;
        int p2  = 0;
        int count = 0;
        while(p1 < len) {
            while (p2 < len && arr[p2] == arr[p1]) {
                p2++;
            }
            count++;
            p1 = p2;
        }
        return count;
    }

    //In-place modification of the array to keep unique elements

    int duplicates1(int arr[]){
        int len = arr.length;
        int i = 0;
        for(int j = 1; j < len; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1; // Return the count of unique elements
    }

    public static void main(String[] args) {
        removeDuplicates obj = new removeDuplicates();
        int[] arr = {1, 2, 3, 4, 4, 5, 5, 6,6, 7, 8, 8, 9,20,22,11,34,21};
        int uniqueCount = obj.duplicates(arr);
        System.out.println("Number of unique elements: " + uniqueCount);
        int inPlaceCount = obj.duplicates1(arr);
        System.out.println("Number of unique elements (in-place): " + inPlaceCount);
    }
}
