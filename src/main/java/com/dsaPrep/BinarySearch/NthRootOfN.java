package com.dsaPrep.BinarySearch;

public class NthRootOfN {
    int sqrt(int mid,int ele){
        long ans = 1;
        for(int i = 0; i < ele; i++){
            ans *= mid;
        }
        return (int)ans;
    }
    int findSqrt(int n,int ele){
        int left = 1;
        int right = ele;
        while(left <= right) {
            int mid = (left + right) / 2;
            // Calculate mid^ele
            if (sqrt(mid,n) == ele) {
                return mid;
            } else if (sqrt(mid,n) < ele) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;// No perfect nth root found
    }

    public static void main(String[] args) {
        NthRootOfN nthRootOfN = new NthRootOfN();
        int n = 27; // Example input
        int ele = 3; // Example root
        int result = nthRootOfN.findSqrt(n,ele);
        if (result != -1) {
            System.out.println("The " + ele + "th root of " + n + " is: " + result);
        } else {
            System.out.println("No perfect " + ele + "th root found for " + n);
        }
    }
}
