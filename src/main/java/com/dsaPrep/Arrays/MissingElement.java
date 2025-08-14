package com.dsaPrep.Arrays;

import java.util.Arrays;

public class MissingElement {

    // ----Brute Force Approach----
    // TC : O(nlogN) for sorting the array
    // SC : O(1) for using constant space
/*    int missing(int arr[]){
        int n = arr.length;
        int result = n;
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            if(arr[i] != i){
                result = i;
                break;
            }
        }
        return result;
    }*/

    // ----Better Approach----
    // TC : O(n^2) for iterating through the array
    // SC : O(1)
/*    int missing(int arr[]) {
        int n = arr.length;
        for(int i = 0 ; i < n; i++){
            int flag = 0;
            for(int j = 0 ; j < n; j++){
                if(arr[j] == i){
                    flag = 1;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return n;
    }*/

    //----Better 2 Appraoch
    // TC : O(n) for iterating through the array
    // SC : O(n) for using a hash array to store the elements
/*    int missing(int arr[]){
        int n = arr.length;
        int hash[] = new int[n+1];
        for(int i = 0 ; i <= n; i++ ){
            // Initialize the hash array
            hash[arr[i]] = 1;
        }
        for(int i = 0 ; i <= n; i++){
            // Check if the element is present in the hash array
            if(hash[i] == 0){
                return i; // Return the missing element
            }
        }
        return n; // If no element is missing, return n
    }*/

    // ----Optimized Approach----
    // TC : O(n) for iterating through the array
    // SC : O(1) for using constant space
    int missing(int arr[]) {
        int n = arr.length;
        int sum = (n * (n + 1)) / 2; // Sum of first n natural numbers
        for (int i = 0; i < n; i++) {
            sum -= arr[i]; // Subtract each element from the sum
        }
        return sum; // The remaining sum is the missing element
    }

    public static void main(String[] args) {
        MissingElement missingElement = new MissingElement();
        int arr[] = { 1, 2, 3, 4};
        System.out.println("Missing Element: " + missingElement.missing(arr));
    }
}
